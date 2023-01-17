package com.pruebaTecnica.ricardoDiaz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pruebaTecnica.ricardoDiaz.entity.ProductEntity;
import com.pruebaTecnica.ricardoDiaz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<ProductEntity[]> productPlatzi(){
        return productService.getAllProductPlatzi().map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<String> postProduct(@RequestBody ProductEntity product) throws IOException {
        return new ResponseEntity<>(productService.postProduct(product), HttpStatus.OK);
    }
}
