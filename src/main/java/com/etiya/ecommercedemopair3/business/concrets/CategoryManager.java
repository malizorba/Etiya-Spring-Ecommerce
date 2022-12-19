package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Category;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private MessageSourceService messageSourceService;
    @Override
    public DataResult<List<Category>> getAll() {
        List<Category> response = categoryRepository.findAll();
        return new SuccessDataResult<List<Category>>(response, messageSourceService.getMessages(Messages.Category.CategoryGetAllSuccessMessage));
    }

    @Override
    public DataResult<Category> getById(int id) {
        Category response = categoryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Category>(response,messageSourceService.getMessages(Messages.Category.CategoryGetByIdSuccessMessage));
    }

    @Override
    public DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {
//        Category category = new Category();
//        category.setName(addCategoryRequest.getName());
//        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        Category category = modelMapperService.getMapperRequest().map(addCategoryRequest, Category.class);
        Category savedCategory = categoryRepository.save(category);
//        AddCategoryResponse response =
//                new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
        AddCategoryResponse response=modelMapperService.getMapperResponse().map(savedCategory,AddCategoryResponse.class);
        return new SuccessDataResult<AddCategoryResponse>(response,messageSourceService.getMessages(Messages.Category.CategoryAddSuccessMessage));
    }
    @Override
    public Page<Category> findAllWithPagination(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Slice<Category> findAllWithSlice(Pageable pageable) {
        return categoryRepository.getAllWithSlice(pageable);
    }

    private void categoryCanNotExistWithSameName(String name){
        // Exception fırlatma
        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(!isExists)
            throw new BusinessException(messageSourceService.getMessages(Messages.Category.CategoryExistWithSameName));
    }

}
