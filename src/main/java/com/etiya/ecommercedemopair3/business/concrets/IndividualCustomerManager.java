package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.IndividualCustomer;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.repository.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<List<IndividualCustomer>> getAll() {
        List<IndividualCustomer> response = individualCustomerRepository.findAll();
        return new SuccessDataResult<List<IndividualCustomer>>(response, messageSourceService.getMessages(Messages.IndividualCustomer.individualCustomerGetByIdSuccessMessage));
    }

    @Override
    public DataResult<IndividualCustomer> getById(int id) {
        IndividualCustomer response = individualCustomerRepository.findById(id).orElseThrow();
        return new SuccessDataResult<IndividualCustomer>(response, messageSourceService.getMessages(Messages.IndividualCustomer.individualCustomerGetByIdSuccessMessage)) ;
    }

    @Override
    public DataResult<IndividualCustomer> getIndividualCustomerBynationalIdentity(String nationalIdentity) {
        IndividualCustomer response = individualCustomerRepository.findIndividualCustomerBynationalIdentity(nationalIdentity);
        return new SuccessDataResult<IndividualCustomer>(response,messageSourceService.getMessages(Messages.IndividualCustomer.individualCustomerGetByIdentityNumberSuccessMessage));
    }

    @Override
    public DataResult<List<IndividualCustomer>> getIndividualCustomerByFirstName(String firstName) {
        List<IndividualCustomer> response = individualCustomerRepository.findIndividualCustomerByFirstName(firstName);
        return new  SuccessDataResult<List<IndividualCustomer>>(response, messageSourceService.getMessages(Messages.IndividualCustomer.individualCustomerGetByFirstNameSuccessMessage));
    }

    @Override
    public DataResult<AddIndividualCustomerResponse> addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest) {
        IndividualCustomer individualCustomer=modelMapperService.getMapperRequest().map(addIndividualCustomerRequest,IndividualCustomer.class);

        IndividualCustomer savedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        AddIndividualCustomerResponse response=modelMapperService.getMapperResponse().map(savedIndividualCustomer,AddIndividualCustomerResponse.class);
        return new SuccessDataResult<AddIndividualCustomerResponse>(response,messageSourceService.getMessages(Messages.IndividualCustomer.individualCustomerAddSuccessMessage));
    }
    @Override
    public Page<IndividualCustomer> findAllWithPagination(Pageable pageable) {
        return individualCustomerRepository.findAll(pageable);
    }

    @Override
    public Slice<IndividualCustomer> findAllWithSlice(Pageable pageable) {
        return individualCustomerRepository.getAllWithSlice(pageable);
    }
}