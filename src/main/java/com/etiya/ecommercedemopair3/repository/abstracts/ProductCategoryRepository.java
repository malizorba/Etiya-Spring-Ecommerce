package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
