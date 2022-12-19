package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.responses.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.entities.concrets.Street;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Integer> {
    boolean existsById(int id);
    @Query("select new com.etiya.ecommercedemopair3.business.dtos.responses.street.GetAllStreetsResponse" +
            "(s.id,s.name,ci.name) from Street s inner join s.city ci")
    List<GetAllStreetsResponse> getAllDto();
    @Query("Select p from Product as p")
    Slice<Street> getAllWithSlice(Pageable pageable);
}
