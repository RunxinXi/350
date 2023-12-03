package com.example.cms.controller;

import com.example.cms.model.entity.Specification;
import com.example.cms.model.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SpecificationController {


    @Autowired
    private final SpecificationRepository repository;

    public SpecificationController(SpecificationRepository repository)
    {this.repository = repository;}

    @GetMapping("/specs")
    List<Specification> retrieveAllSpecs(){return repository.findAll();}





}
