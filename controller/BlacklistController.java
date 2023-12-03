package com.example.cms.controller;

import com.example.cms.controller.exceptions.AccountNotFoundException;
import com.example.cms.controller.exceptions.BlacklistNotFoundException;
import com.example.cms.model.entity.Account;
import com.example.cms.model.entity.Blacklist;
import com.example.cms.model.repository.AccountRepository;
import com.example.cms.model.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BlacklistController {

    @Autowired
    private final BlacklistRepository repository;

    @Autowired
    private final AccountRepository accountRepository;


    public BlacklistController(BlacklistRepository repository, AccountRepository accountRepository)
    {this.repository = repository;
    this.accountRepository = accountRepository;}

    @GetMapping("/blacklist")
    List<Blacklist> retrieveAllSuspendedId(){return  repository.findAll();}

    @PostMapping("/blacklist/add/{uid}")
    Blacklist addUidToBlacklist( @PathVariable("uid") long uid){
        Blacklist blacklist = repository.findById(Long.valueOf(1))
                .orElseThrow(() -> new BlacklistNotFoundException(Long.valueOf(1)));

        Account account = accountRepository.findById(uid)
                .orElseThrow(() ->  new AccountNotFoundException(uid));

        blacklist.getAccounts().add(account);
        account.setBlacklist(blacklist);

        return repository.save(blacklist);
    }

    @DeleteMapping("/blacklist/delete/{uid}")
    Blacklist deleteUidFromBlacklist(@PathVariable("uid") Long uid){
        Blacklist blacklist = repository.findById(Long.valueOf(1))
                .orElseThrow(() -> new BlacklistNotFoundException(Long.valueOf(1)));
        Account account = accountRepository.findById(uid).orElseThrow(
                ()-> new AccountNotFoundException(uid)
        );
        blacklist.removeAccount(account);
        account.setBlacklist(null);
        return repository.save(blacklist);
    }


}
