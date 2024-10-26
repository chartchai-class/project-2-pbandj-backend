package se331.pbandjbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.pbandjbackend.entity.Comment;
import se331.pbandjbackend.entity.Country;
import se331.pbandjbackend.service.CommentService;
import se331.pbandjbackend.service.CountryService;
import se331.pbandjbackend.util.LabMapper;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;

    @GetMapping
    public ResponseEntity<?> getCommentList(@RequestParam(value = "_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "country_id", required = true) Long countryId) {
        perPage = (perPage == null) ? commentService.getCommentSize() : perPage;
        page = (page == null) ? 1 : page;

        Page<Comment> pageOutput;

        pageOutput = commentService.getComments(countryId, PageRequest.of(perPage, page));


        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        return new ResponseEntity<>(LabMapper.INSTANCE.getCommentDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDto(output));
    }


}
