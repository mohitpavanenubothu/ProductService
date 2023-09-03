package com.mssql.ProductService.controller;

import com.mssql.ProductService.model.ProductRequest;
import com.mssql.ProductService.model.ProductResponse;
import com.mssql.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productApi")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addPro")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long productId) {
        ProductResponse productResponse = productService.getProductId(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
