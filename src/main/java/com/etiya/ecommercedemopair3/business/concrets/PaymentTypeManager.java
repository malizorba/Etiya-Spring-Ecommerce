package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.PaymentTypeService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.PaymentType;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.repository.abstracts.PaymentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentTypeManager implements PaymentTypeService {
    private PaymentTypeRepository paymentTypeRepository;
    private ModelMapperService modelMapperService;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<List<PaymentType>> getAll() {
        List<PaymentType> response = paymentTypeRepository.findAll();
        return new SuccessDataResult<List<PaymentType>>(response, messageSourceService.getMessages(Messages.PaymentType.paymentTypeGetAllSuccessMessage));
    }

    @Override
    public DataResult<PaymentType> getById(int id) {
        PaymentType response = paymentTypeRepository.findById(id).orElseThrow();
        return new  SuccessDataResult<PaymentType>(response,messageSourceService.getMessages(Messages.PaymentType.paymentTypeGetByIdSuccessMessage));
    }

    @Override
    public DataResult<PaymentType> getByName(String name) {
        PaymentType response =  paymentTypeRepository.findByName(name);
        return new SuccessDataResult<PaymentType>(response,messageSourceService.getMessages(Messages.PaymentType.paymentTypeGetByNameSuccessMessage));
    }

    @Override
    public DataResult<PaymentType> getByDescription(String description) {
        PaymentType response = paymentTypeRepository.findPaymentTypeByDescription(description);
        return new SuccessDataResult<PaymentType>(response, messageSourceService.getMessages(Messages.PaymentType.paymentTypeGetByDescriptionSuccessMessage));
    }

    @Override
    public DataResult<AddPaymentTypeResponse> addPaymentType(AddPaymentTypeRequest addPaymentTypeRequest) {
//        PaymentType paymentType=new PaymentType();
//        paymentType.setDescription(addPaymentTypeRequest.getDescription());
//        paymentType.setName(addPaymentTypeRequest.getName());
        PaymentType paymentType = modelMapperService.getMapperRequest().map(addPaymentTypeRequest, PaymentType.class);
        PaymentType savedPaymentType=paymentTypeRepository.save(paymentType);
//        AddPaymentTypeResponse response=new AddPaymentTypeResponse(savedPaymentType.getId(),savedPaymentType.getDescription(),savedPaymentType.getName());
        AddPaymentTypeResponse response = modelMapperService.getMapperResponse().map(savedPaymentType, AddPaymentTypeResponse.class);
        return new SuccessDataResult<AddPaymentTypeResponse>(response,messageSourceService.getMessages(Messages.PaymentType.paymentTypeAddSuccessMessage));
    }
    @Override
    public Page<PaymentType> findAllWithPagination(Pageable pageable) {
        return paymentTypeRepository.findAll(pageable);
    }

    @Override
    public Slice<PaymentType> findAllWithSlice(Pageable pageable) {
        return paymentTypeRepository.getAllWithSlice(pageable);
    }
}