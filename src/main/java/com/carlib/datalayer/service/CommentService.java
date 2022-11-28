package com.carlib.datalayer.service;

import com.carlib.datalayer.model.Comment;
import com.carlib.datalayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }
}
