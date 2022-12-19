package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.IndividualCustomer;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,Integer> {
    @Query("Select inn from IndividualCustomer as inn where nationalIdentity=:nationalIdentity")
    IndividualCustomer findIndividualCustomerBynationalIdentity(String nationalIdentity);

    List<IndividualCustomer> findIndividualCustomerByFirstName(String firstName);
    @Query("Select p from Product as p")
    Slice<IndividualCustomer> getAllWithSlice(Pageable pageable);
}
