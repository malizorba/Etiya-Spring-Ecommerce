package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.City;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City,Integer> {
    boolean existsById(int id);
    @Query("Select p from Product as p")
    Slice<City> getAllWithSlice(Pageable pageable);
}
