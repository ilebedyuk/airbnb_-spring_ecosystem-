package org.airbnb.repository;

import org.airbnb.domain.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ilebedyuk
 */
public interface CommentRepository extends CrudRepository<Comment,Long> {
}
