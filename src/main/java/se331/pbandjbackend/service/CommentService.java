package se331.pbandjbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.pbandjbackend.entity.Comment;

public interface CommentService {
    Integer getCommentSize();
    Page<Comment> getComments(Integer pageSize, Integer page);
    Comment getComment(Long id);
    Comment save(Comment comment);
    Page<Comment> getComments(Long countryId, Pageable page);
}
