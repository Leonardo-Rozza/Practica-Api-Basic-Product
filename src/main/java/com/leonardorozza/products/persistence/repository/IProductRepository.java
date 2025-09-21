package com.leonardorozza.products.persistence.repository;

import com.leonardorozza.products.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
