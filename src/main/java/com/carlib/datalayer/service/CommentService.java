package com.carlib.datalayer.service;

import com.carlib.datalayer.model.Comment;
import com.carlib.datalayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * @return a list of Comments
     * */
    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }

    /**
     * @return one Comment relative to its id
     * */
    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    /**
     * @param comment
     * @return a new object of Class Comment
     * */
    public Comment add(Comment comment) { return commentRepository.save(comment); }
}
