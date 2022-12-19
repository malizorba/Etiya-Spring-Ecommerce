package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair3.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemopair3.business.abstracts.ProductService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.productCategory.AddProductCategoryResponse;
import com.etiya.ecommercedemopair3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.ProductCategory;
import com.etiya.ecommercedemopair3.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair3.repository.abstracts.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;
    private CategoryService categoryService;
    private ProductService productService;
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<AddProductCategoryResponse> addProductCategory(AddProductCategoryRequest addProductCategoryRequest) {
//        ProductCategory productCategory = new ProductCategory();
        checkIfCategoryExists(addProductCategoryRequest.getCategoryId());
//        Category category = categoryService.getById(addProductCategoryRequest.getCategoryId());
//        productCategory.setCategory(category);
//        Product product = productService.getById(addProductCategoryRequest.getProductId());
//        productCategory.setProduct(product);
        ProductCategory productCategory=modelMapperService.getMapperRequest().map(addProductCategoryRequest,ProductCategory.class);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);

//        AddProductCategoryResponse response = new AddProductCategoryResponse(savedProductCategory.getId(),savedProductCategory.getCategory().getId(), savedProductCategory.getProduct().getId());
        AddProductCategoryResponse response=modelMapperService.getMapperResponse().map(savedProductCategory,AddProductCategoryResponse.class);
        return new SuccessDataResult<AddProductCategoryResponse>(response, messageSourceService.getMessages(Messages.ProductCategory.productCategoriesAddSuccesMessage));
    }

    private void checkIfCategoryExists(int id){
        boolean isExists = categoryRepository.existsById(id);
        if(!isExists) {
            throw new BusinessException(messageSourceService.getMessages(Messages.Category.CategoryNotExistWithId));
        }
    }


//    private void checkIfCategoryExist(Category category){
//        List<Category> categories = categoryRepository.findAll();
//        for (Category categoryItem: categories
//             ) {
//            if (category.getId() != categoryItem.getId()){
//                throw new RuntimeException("Bu id'ye sahip kategori mevcut değil!");
//            }
//        }
//    }

}