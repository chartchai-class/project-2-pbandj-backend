package se331.pbandjbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.pbandjbackend.entity.Country;
import se331.pbandjbackend.service.CountryService;
import se331.pbandjbackend.util.LabMapper;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {
    final CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getCountryList(@RequestParam(value = "_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "title", required = false) String title) {
        perPage = (perPage == null) ? 3 : perPage;
        page = (page == null) ? 1 : page;

        Page<Country> pageOutput;
        if (title == null) {
            pageOutput = countryService.getCountries(perPage, page);
        } else {
            pageOutput = countryService.getCountries(title, PageRequest.of(page - 1, perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        return new ResponseEntity<>(LabMapper.INSTANCE.getCountryDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCountry(@RequestBody Country country) {
        Country output = countryService.save(country);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCountryDto(output));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCountry(@PathVariable("id") Long id) {
        Country output = countryService.getCountry(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getCountryDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given ID is not found");
        }
    }
}
