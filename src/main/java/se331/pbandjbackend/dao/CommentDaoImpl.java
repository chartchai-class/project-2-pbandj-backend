package se331.pbandjbackend.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.pbandjbackend.entity.Comment;
import se331.pbandjbackend.repository.CommentRepository;

@Repository
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao{
    final CommentRepository commentRepository;
    @Override
    public Integer getCommentSize() {
        return Math.toIntExact(commentRepository.count());
    }

    @Override
    public Page<Comment> getComments(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? getCommentSize() : pageSize;
        page = page == null ? 1 : page;
        return commentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getComments(String title, Pageable page) {
        return null;
    }
}
