package se331.pbandjbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.pbandjbackend.entity.Sport;
import se331.pbandjbackend.service.SportService;
import se331.pbandjbackend.util.LabMapper;

@RestController
@RequestMapping("/sports")
@RequiredArgsConstructor
public class SportController {
    final SportService sportService;

    @GetMapping
    public ResponseEntity<?> getSportList(@RequestParam(value = "_limit", required = false) Integer perPage,
                                          @RequestParam(value = "_page", required = false) Integer page,
                                          @RequestParam(value = "title", required = false) String title) {
        perPage = (perPage == null) ? 3 : perPage;
        page = (page == null) ? 1 : page;

        Page<Sport> pageOutput;
        if (title == null) {
            pageOutput = sportService.getSports(perPage, page);
        } else {
            pageOutput = sportService.getSports(title, PageRequest.of(page - 1, perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        return new ResponseEntity<>(LabMapper.INSTANCE.getSportDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addSport(@RequestBody Sport sport) {
        Sport output = sportService.save(sport);
        return ResponseEntity.ok(LabMapper.INSTANCE.getSportDto(output));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSport(@PathVariable("id") Long id) {
        Sport output = sportService.getSport(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getSportDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given ID is not found");
        }
    }
}
