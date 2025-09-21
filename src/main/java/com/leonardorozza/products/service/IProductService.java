package com.leonardorozza.products.service;


import com.leonardorozza.products.ProductsApplication;
import com.leonardorozza.products.service.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductDto> getAll();
    Optional<ProductDto> findById(Long id);
    Optional<ProductDto> save(ProductDto productDto);
    Optional<ProductDto> update(Long id, ProductDto productDto);
    boolean deleteById(Long id);


}
