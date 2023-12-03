package com.example.cms.controller.exceptions;

import com.example.cms.model.entity.CommentKey;

public class CommentNotFoundException extends RuntimeException{
    public  CommentNotFoundException(CommentKey key){super("could not find the comment");};
}
