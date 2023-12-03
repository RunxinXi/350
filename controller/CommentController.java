package com.example.cms.controller;

import com.example.cms.controller.dto.CommentDto;
import com.example.cms.controller.exceptions.AccountNotFoundException;
import com.example.cms.controller.exceptions.BlacklistException;
import com.example.cms.controller.exceptions.CommentNotFoundException;
import com.example.cms.controller.exceptions.ProductNotFoundException;
import com.example.cms.model.entity.*;
import com.example.cms.model.repository.AccountRepository;
import com.example.cms.model.repository.BlacklistRepository;
import com.example.cms.model.repository.CommentRepository;
import com.example.cms.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CommentController {
    @Autowired
    private final CommentRepository repository;

    @Autowired
    private  AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BlacklistRepository blacklistRepository;



    public CommentController(CommentRepository repository, AccountRepository accountRepository, ProductRepository productRepository,
    BlacklistRepository blacklistRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
        this.blacklistRepository = blacklistRepository;

    }

    @GetMapping("/comments")
    List<Comment> retrieveAllComments(){return repository.findAll();}

    @GetMapping("/comments/{uid}")
    List<Comment> retrieveAllUserComments(@PathVariable("uid")Long uid){
        return  repository.searchUserComment(uid);
    }

    @GetMapping("/comments/{uid}/{pid}")
    Comment retrieveComment(@PathVariable("uid")Long uid, @PathVariable("pid")long pid){
        CommentKey key = new CommentKey();
        key.setUid(uid);
        key.setPid(pid);
        return repository.findById(key) .orElseThrow(
                ()-> new CommentNotFoundException(key)
        );
    }

    @PostMapping("/comments")
    Comment createComment(@RequestBody CommentDto commentDto){
        Comment newComment = new Comment();
        long uid = commentDto.getUid();
        long pid = commentDto.getPid();
        String detail = commentDto.getDetail();
        boolean isEdited = commentDto.isEdited();

        if (isUserBlacklisted(uid)) {
            throw new BlacklistException("User (ID: " + uid + ") is blacklisted and cannot post comments.");
        }

        CommentKey key = new CommentKey();
        key.setPid(commentDto.getPid());
        key.setUid(commentDto.getUid());
        newComment.setCommentId(key);

        Account account = accountRepository.findById(uid).orElseThrow(
                () -> new AccountNotFoundException(uid));
        Product product = productRepository.findById(pid).orElseThrow(
                () -> new ProductNotFoundException(pid)
        );

        newComment.setAccount(account);
        newComment.setProduct(product);
        newComment.setDetail(detail);
        newComment.setEdited(false);

        return repository.save(newComment);
    }

    @PutMapping("/comments/{uid}/{pid}")
    Comment updateComment(@RequestBody CommentDto commentDto, @PathVariable("uid")Long uid,@PathVariable("pid")Long pid){
        String detail = commentDto.getDetail();
        boolean Edited = commentDto.isEdited();

        CommentKey key = new CommentKey();
        key.setUid(commentDto.getUid());
        key.setPid(commentDto.getPid());
        return repository.findById(key).map(
                comment ->  {
                    comment.setDetail(commentDto.getDetail());
                    comment.setEdited(true);
                    return repository.save(comment);
                })
                .orElseGet(() ->{
                    Comment  newComment = new Comment();
                    newComment.setCommentId(key);
                    newComment.setDetail(commentDto.getDetail());
                    newComment.setEdited(false);
                    Account account = accountRepository.findById(commentDto.getUid()).orElseThrow(
                            () -> new AccountNotFoundException(commentDto.getUid())
                    );
                    Product product = productRepository.findById(commentDto.getPid()).orElseThrow(
                            () -> new ProductNotFoundException(commentDto.getPid())
                    );
                    newComment.setAccount(account);
                    newComment.setProduct(product);
                    return repository.save(newComment);
                }
                );
    }

    @DeleteMapping("/comments/{uid}/{pid}")
    void deleteComment(@PathVariable("uid") Long uid, @PathVariable("pid") Long pid){
        CommentKey key = new CommentKey();
        key.setUid(uid);
        key.setPid(pid);
        repository.deleteById(key);
    }

    private boolean isUserBlacklisted(long uid) {
        Account account = accountRepository.findById(uid)
                .orElseThrow(() -> new AccountNotFoundException(uid));

        Blacklist blacklist = account.getBlacklist();
        return blacklist != null;

    }
}
