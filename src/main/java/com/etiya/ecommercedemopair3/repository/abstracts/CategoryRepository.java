package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.Category;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    //List<Category> findByNameEquals(String name);
    boolean existsCategoryByName(String name);
    boolean existsById(int id);
    @Query("Select p from Product as p")
    Slice<Category> getAllWithSlice(Pageable pageable);

}
