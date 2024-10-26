package se331.pbandjbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.pbandjbackend.entity.Comment;

public interface CommentRepository extends JpaRepository <Comment, Long> {
}
