package se331.pbandjbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.pbandjbackend.dao.CommentDao;
import se331.pbandjbackend.dao.CountryDao;
import se331.pbandjbackend.entity.Comment;
import se331.pbandjbackend.entity.Country;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    final CountryDao countryDao;
    final CommentDao commentDao;
    @Override
    public Integer getCommentSize() {
        return commentDao.getCommentSize();
    }

    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        return commentDao.getComments(pageSize, page);
    }

    @Override
    public Comment getComment(Long id) {
        return commentDao.getComment(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Page<Comment> getComments(Long countryId, Pageable page) {
        Country targetCountry = countryDao.getCountry(countryId);
        List<Comment> comments = targetCountry.getComments();

        // Calculate the start and end index for the current page
        int start = (int) page.getOffset();
        int end = Math.min((start + page.getPageSize()), comments.size());

        // Return a PageImpl containing a sublist of the comments for pagination
        return new PageImpl<>(comments.subList(start, end), page, comments.size());
    }
}
