package com.leonardorozza.products.service.impl;

import com.leonardorozza.products.persistence.entity.ProductEntity;
import com.leonardorozza.products.persistence.repository.IProductRepository;
import com.leonardorozza.products.service.IProductService;
import com.leonardorozza.products.service.dto.ProductDto;
import com.leonardorozza.products.utils.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAll() {
        return this.productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return this.productRepository.findById(id)
                .map(ProductMapper::toDto);
    }

    @Override
    public Optional<ProductDto> save(ProductDto productDto) {
        ProductEntity product = ProductMapper.toEntity(productDto);
        product.setId(null);
        ProductEntity productSaved = this.productRepository.save(product);
        return Optional.of(ProductMapper.toDto(productSaved));
    }

    @Override
    public Optional<ProductDto> update(Long id, ProductDto productDto) {
        return this.productRepository.findById(id)
                .map(entity ->{
                    ProductMapper.update(entity, productDto);
                    ProductEntity productSaved = this.productRepository.save(entity);
                    return ProductMapper.toDto(productSaved);
                });
    }

    @Override
    public boolean deleteById(Long id) {
        if (this.productRepository.existsById(id)){
            this.productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
