package org.airbnb.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.airbnb.domain.Comment;
import org.airbnb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilebedyuk
 */
@Service
@NoArgsConstructor
@Data
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Comment findOne(long commentId) {
        return commentRepository.findOne(commentId);
    }

    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }
}
