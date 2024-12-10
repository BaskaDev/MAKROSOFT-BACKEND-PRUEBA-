package co.company.macrosoft.pruebatenica.rest.repository;

import co.company.macrosoft.pruebatenica.rest.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
