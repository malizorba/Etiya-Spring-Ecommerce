package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.PaymentType;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentTypeRepository extends JpaRepository<PaymentType,Integer> {
    @Query("Select pt from PaymentType as pt where name=:name")
    PaymentType findByName(String name);

    PaymentType findPaymentTypeByDescription(String description);
    @Query("Select p from Product as p")
    Slice<PaymentType> getAllWithSlice(Pageable pageable);
}
