package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.Address;
import com.etiya.ecommercedemopair3.entities.concrets.Cart;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("Select p from Address as p")
    Slice<Cart> getAllWithSlice(Pageable pageable);
}
