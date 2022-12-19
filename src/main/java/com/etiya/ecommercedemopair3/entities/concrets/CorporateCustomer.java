package com.etiya.ecommercedemopair3.entities.concrets;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "corporate_customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

@PrimaryKeyJoinColumn(name = "id")
public class CorporateCustomer extends Customer {

    @Column(name = "company_name")
    private String companyName;
}