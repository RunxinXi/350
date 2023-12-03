package com.example.cms.controller;

import com.example.cms.controller.dto.StorageDto;
import com.example.cms.controller.exceptions.ProductNotFoundException;
import com.example.cms.model.entity.Product;
import com.example.cms.model.entity.Storage;
import com.example.cms.model.repository.ProductRepository;
import com.example.cms.model.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StorageController {

    @Autowired
    private final StorageRepository repository;
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private StorageController(StorageRepository repository,ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    @GetMapping("/models")
    List<Storage> retrieveAllModel(){return  repository.findAll();}

    @GetMapping("/models/search/price/{priceTerm}")
    List<Storage> searchModelPrice(@PathVariable("priceTerm") double priceTerm) {
        return repository.searchStoragePrice(priceTerm);
    }

    @PutMapping("/models/{pid}/{sid}")
    Storage updateModel (@RequestBody StorageDto storageDto, @PathVariable("sid")long sid) {
        return repository.findById(sid)
                .map(storage -> {
                    storage.setStore(storageDto.getStore());
                    storage.setPrice(storageDto.getPrice());
                    Product product = productRepository.findById(storageDto.getPid()).orElseThrow(
                            () -> new ProductNotFoundException(storageDto.getPid()));
                    storage.setProduct(product);
                    return repository.save(storage);
                })
                .orElseGet(() -> {
                    Storage newStorage = new Storage();
                    newStorage.setSid(storageDto.getSid());
                    newStorage.setPrice(storageDto.getPrice());
                    newStorage.setStore(storageDto.getStore());
                    Product product = productRepository.findById(storageDto.getPid())
                            .orElseThrow(()-> new ProductNotFoundException(storageDto.getPid()));
                    newStorage.setProduct(product);
                    return  repository.save(newStorage);

                    }
                );

    }

    @DeleteMapping("/models/{sid}")
    void deleteModel(@PathVariable("sid")long sid){repository.deleteById(sid);}
}
