package org.airbnb.controller;

import org.airbnb.domain.Comment;
import org.airbnb.services.CommentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ilebedyuk
 */
@RestController
public class CommentController {
    @Inject
    CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> findAll() {
        final List<Comment> resultList = new ArrayList<>();
        final Iterable<Comment> all = commentService.findAll();
        all.forEach(new Consumer<Comment>() {
            @Override
            public void accept(Comment comment) {
                resultList.add(comment);
            }
        });
        return resultList;
    }
}
