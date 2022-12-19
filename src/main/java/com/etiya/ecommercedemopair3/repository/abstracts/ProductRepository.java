package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.responses.product.GetProductResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    @Query("Select p from Product as p WHERE name=:name")
    Product findByName(String name);

    @Query("Select new com.etiya.ecommercedemopair3.business.dtos.responses.product.GetProductResponse(p.name,p.stock,p.unitPrice) from Product  " +
            "as p inner join ProductCategory as pc on p=pc.product inner join Category as c on pc.category=c where c.id in(:identity)" +
            " group by p.name,p.stock,p.unitPrice")
    List<GetProductResponse> getProductByCategoryId(int identity);
    @Query("Select p from Product as p")
    Slice<Product> getAllWithSlice(Pageable pageable);
}
