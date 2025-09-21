package com.leonardorozza.products.utils;


import com.leonardorozza.products.persistence.entity.ProductEntity;
import com.leonardorozza.products.service.dto.ProductDto;
import org.yaml.snakeyaml.util.EnumUtils;

public class ProductMapper {

    public static ProductDto toDto(ProductEntity productEntity){
        if (productEntity == null) return null;

        return new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getDescription(),
                productEntity.getPrice(), productEntity.getStock());
    }


    public static ProductEntity toEntity(ProductDto productDto){
        if (productDto == null) return null;

        return new ProductEntity(productDto.id(), productDto.name(), productDto.description(), productDto.price(),
                productDto.stock());
    }

    public static void update(ProductEntity productEntity, ProductDto productDto){
        if (productEntity == null || productDto == null) return;

        productEntity.setName(productDto.name());
        productEntity.setDescription(productDto.description());
        productEntity.setPrice(productDto.price());
        productEntity.setStock(productDto.stock());
    }



}
