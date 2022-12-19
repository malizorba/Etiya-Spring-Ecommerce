package com.etiya.ecommercedemopair3.entities.concrets;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CartDetailId implements Serializable {

    private static final long serialVersionUID = 1L;
    private Product product;
    private Cart cart;
}
