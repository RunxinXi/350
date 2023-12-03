package com.example.cms.controller;
import com.example.cms.controller.exceptions.AccountNotFoundException;
import com.example.cms.controller.exceptions.ProductNotFoundException;
import com.example.cms.model.entity.*;
import com.example.cms.model.repository.AccountRepository;
import com.example.cms.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
public class AccountController {
    @Autowired
    private final AccountRepository repository;
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private AccountController(AccountRepository repository, ProductRepository productRepository)
    {this.repository = repository;this.productRepository = productRepository;}



    @GetMapping("/accounts")
    List<Account> retrieveAllAccount(){return repository.findAll();};

    @GetMapping("/accounts/{uid}")
    Account retrieveAccount(@PathVariable("uid")Long uid ){
        return repository.findById(uid)
                .orElseThrow(() -> new AccountNotFoundException(uid));
    }

    @GetMapping("/accounts/{uid}/liked")
    Set retrieveliked(@PathVariable("uid")long uid){
        Account account = repository.findById(uid)
                .orElseThrow(() -> new AccountNotFoundException(uid));
        return account.getLikedProducts();
    }

    @PostMapping("/accounts")
    Account createAccount(@RequestBody Account newAccount) {
        return repository.save(newAccount);
    }


    @PostMapping("/accounts/{uid}/add/{pid}")
    Account addProductsToLikedProducts(@PathVariable ("uid") long uid, @PathVariable ("pid") long pid) {
        Account account = repository.findById(uid)
                .orElseThrow(() -> new AccountNotFoundException(uid));
        Product product = productRepository.findById(pid)
                .orElseThrow(() -> new ProductNotFoundException(pid));
        account.getLikedProducts().add(product);
        return repository.save(account);

        }
    @DeleteMapping("/accounts/{uid}")
    void deleteAccount(@PathVariable("uid")Long uid) {repository.deleteById(uid);}



}
