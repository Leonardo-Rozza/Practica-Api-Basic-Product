package com.leonardorozza.products.presentation.controller;


import com.leonardorozza.products.service.IProductService;
import com.leonardorozza.products.service.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        List<ProductDto> productDtos = this.productService.getAll();
        return ResponseEntity.ok(productDtos);
    };


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id){
        return this.productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto productDto){
        return this.productService.save(productDto)
                .map(product -> ResponseEntity.status(HttpStatus.CREATED).body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @Valid @RequestBody ProductDto productDto){
        return this.productService.update(id, productDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        return this.productService.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
