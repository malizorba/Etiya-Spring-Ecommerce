package com.etiya.ecommercedemopair3.business.constants;

public class Messages {
    public static class Category {
        public static final String CategoryExistWithSameName = "CategoryExistWithSameName";
        public static final String CategoryNotExistWithId="CategoryNotExistWithId";
        public static final String CategoryAddSuccessMessage = "CategoryAddSuccessMessage";
        public static final String CategoryGetByIdSuccessMessage = "CategoryGetByIdSuccessMessage";
        public static final String CategoryGetAllSuccessMessage = "CategoryGetAllSuccessMessage";
    }

    public static class City {
        public static final String CityNotExistWithId = "CityNotExistWithId";
        public static final String CityAddSuccessMessage = "CityAddSuccessMessage";
        public static final String CityGetById = "CityGetById";
    }

    public static class Country {
        public static final String CountryNotExistWithId = "CountryNotExistWithId";
        public static final String countryAddSuccesMessage = "countryAddSuccesMessage";
        public static final String countryGetByIdSuccesMessage = "countryGetByIdSuccesMessage";
    }

    public static class Street {
        public static final String streetAddSuccessMessage = "streetAddSuccessMessage";
        public static final String StreetNotExistWithId = "StreetNotExistWithId";
        public static final String streetGetByIdSuccessMessage = "streetGetByIdSuccessMessage";
        public static final String streetGetAllSuccessMessage = "Sokak listelendi";
    }

    public static class Customer {
        public static final String CustomerNotExistWithId = "CustomerNotExistWithId";
        public static final String customerGetByIdSuccessMessage = "customerGetByIdSuccessMessage";
        public static final String customerGetAllSuccessMessage = "customerGetAllSuccessMessage";
    }

    public static class Address {
        public static final String addressAddingSuccessMessage = "addressAddingSuccessMessage";

        public static final String addressListAllSuccessMessage= "addressListAllSuccessMessage";

        public static final String addressGetByIdSuccessMessage= "addressGetByIdSuccessMessage";

    }

    public static class Cart {
        public static final String cartAddSuccessMessage = "cartAddSuccessMessage";
    }

    public static class IndividualCustomer {
        public static final String individualCustomerAddSuccessMessage = "individualCustomerAddSuccessMessage";
        public static final String individualCustomerGetAllSuccessMessage = "individualCustomerGetAllSuccessMessage";
        public static final String individualCustomerGetByIdSuccessMessage = "individualCustomerGetByIdSuccessMessage";
        public static final String individualCustomerGetByFirstNameSuccessMessage = "individualCustomerGetByFirstNameSuccessMessage";
        public static final String individualCustomerGetByIdentityNumberSuccessMessage = "individualCustomerGetByIdentityNumberSuccessMessage";
    }

    public static class ProductCategory {
        public static final String productCategoriesAddSuccesMessage = "productCategoriesAddSuccesMessage";
        public static final String ProductCategoryNotExistWithId="ProductCategoryNotExistWithId";
    }

    public static class Product {
        public static final String productGetByNameSuccesMessage = "productGetByNameSuccesMessage";
        public static final String productAllByStockGreaterThanSuccesMessage = "productAllByStockGreaterThanSuccesMessage";
        public static final String productAddSuccesMessage = "productAddSuccesMessage";
        public static final String productGetByIdSuccesMessage = "productGetByIdSuccesMessage";
        public static final String productGetByCategoryIdSuccessMessage= "productGetByCategoryIdSuccessMessage";
    }

    public static class PaymentType {
        public static final String paymentTypeGetByDescriptionSuccessMessage = "paymentTypeGetByDescriptionSuccessMessage";
        public static final String paymentTypeGetByNameSuccessMessage = "paymentTypeGetByNameSuccessMessage";
        public static final String paymentTypeGetByIdSuccessMessage = "paymentTypeGetByIdSuccessMessage";
        public static final String paymentTypeGetAllSuccessMessage = "paymentTypeGetAllSuccessMessage";
        public static final String paymentTypeAddSuccessMessage = "paymentTypeAddSuccessMessage";
    }

    public static class Order{
        public  static  final  String orderAddSuccessMessage="orderAddSuccessMessage";
    }

    public static class Invoice {
        public static final String invoiceAddSuccessMessage = "invoiceAddSuccessMessage";
    }



}
