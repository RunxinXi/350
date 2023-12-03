package com.example.cms.controller;

import com.example.cms.controller.dto.ProductDto;
import com.example.cms.controller.exceptions.CameraNotFoundException;
import com.example.cms.controller.exceptions.ProductNotFoundException;
import com.example.cms.model.entity.*;
import com.example.cms.model.entity.Product;
import com.example.cms.model.repository.ProductRepository;
import com.example.cms.model.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    private final ProductRepository repository;
    @Autowired
    private CameraRepository cameraRepository;
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> retrieveAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/products/{pid}")
    Product retrieveProduct(@PathVariable("pid") long pid) {
        return repository.findById(pid)
                .orElseThrow(() -> new ProductNotFoundException(pid));
    }

    @GetMapping("/products/search/{searchstring}")
    List<Product> searchProduct(@PathVariable("searchstring") String searchString) {
        return repository.search(searchString);
    }

    @GetMapping("/products/search/price/{priceTerm}")
    List<Product> searchProductPrice(@PathVariable("priceTerm") double priceTerm) {
        return repository.searchPrice(priceTerm);
    }

    @GetMapping("/products/{pid}/rating")
    public double calculateRating(@PathVariable Long pid) {
        Product product = repository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid));

        int total = product.getTotal();
        int number = product.getNum();

        if (number == 0) {
            return 0.00;
        }
        else {
            double rating =  (double) total / number;
            DecimalFormat df = new DecimalFormat("0.00");
            return Double.parseDouble(df.format(rating));
        }
    }

    @PostMapping("/products")
    Product createProduct(@RequestBody ProductDto productDto) {
        Product newProduct = new Product();
        newProduct.setPid(productDto.getPid());
        newProduct.setPname(productDto.getPname());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setNum(productDto.getNum());
        newProduct.setTotal(productDto.getTotal());
        Camera camera = cameraRepository.findById(productDto.getCid())
                .orElseThrow(() -> new CameraNotFoundException(productDto.getCid()));
        newProduct.setCamera(camera);
        return repository.save(newProduct);
    }


    @PutMapping("/products/rate/{pid}")
    public Product addIntToRating(@PathVariable long pid, @RequestParam int rating) {
        Product newproduct = repository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid));
        int newTotal = newproduct.getTotal() + rating;
        int newNum = newproduct.getNum() + 1;
        newproduct.setTotal(newTotal);
        newproduct.setNum(newNum);
        return repository.save(newproduct);
    }
    //example : http://localhost:8085/products/rate/102?rating=3

    @PutMapping("/products/{pid}")
    Product updateProduct(@RequestBody ProductDto productDto, @PathVariable("pid") long pid){
        return repository.findById(pid)
                .map(product -> {
                    product.setPname(productDto.getPname());
                    product.setPrice(productDto.getPrice());
                    product.setTotal(productDto.getTotal());
                    product.setNum(productDto.getNum());
                    Camera camera = cameraRepository.findById(productDto.getCid()).orElseThrow(
                            () -> new CameraNotFoundException(productDto.getCid()));
                    product.setCamera(camera);
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    Product newProduct = new Product();
                    newProduct.setPid(productDto.getPid());
                    newProduct.setPname(productDto.getPname());
                    newProduct.setPrice(productDto.getPrice());
                    newProduct.setNum(productDto.getNum());
                    newProduct.setTotal(productDto.getTotal());
                    Camera camera = cameraRepository.findById(productDto.getCid())
                            .orElseThrow(() -> new CameraNotFoundException(productDto.getCid()));
                    newProduct.setCamera(camera);
                    return repository.save(newProduct);
                        }
                );
    }


    @DeleteMapping("/products/{pid}")
    void deleteProduct(@PathVariable("pid") Long pid) {
        repository.deleteById(pid);
    }
}