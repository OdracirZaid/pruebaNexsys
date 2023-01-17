package com.pruebaTecnica.ricardoDiaz.controller;

import com.pruebaTecnica.ricardoDiaz.entity.CategoryEntity;
import com.pruebaTecnica.ricardoDiaz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<CategoryEntity[]> productPlatzi(){
        return categoryService.getAllCategoryPlatzi().map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
