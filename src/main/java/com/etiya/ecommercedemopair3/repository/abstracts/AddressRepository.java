package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.Address;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    List<Address> findAllAddressByTitle(String title);

    @Query("Select ad From Address as ad where description=:description")
    Address findByDescription(String description);

    @Query("Select p from Address as p")
    Slice<Address> getAllWithSlice(Pageable pageable);

}
