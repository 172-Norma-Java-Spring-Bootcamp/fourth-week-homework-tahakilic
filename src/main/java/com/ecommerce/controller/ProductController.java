package com.ecommerce.controller;

import com.ecommerce.core.model.dto.ProductDTO;
import com.ecommerce.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.ok().body("Kayıt Başarlı");
    }

}
