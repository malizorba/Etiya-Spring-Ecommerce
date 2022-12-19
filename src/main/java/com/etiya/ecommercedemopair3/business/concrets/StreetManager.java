package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.StreetService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.street.AddStreetRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.entities.concrets.Street;
import com.etiya.ecommercedemopair3.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair3.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StreetManager implements StreetService {
    private StreetRepository streetRepository;
    private ModelMapperService modelMapperService;
    private CityRepository cityRepository;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<Street> getById(int id) {
        Street response = streetRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Street>(response, messageSourceService.getMessages(Messages.Street.streetGetByIdSuccessMessage));
    }

    @Override
    public DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest) {
//        Street street = new Street();
//        street.setName(addStreetRequest.getName());
        checkIfCityExists(addStreetRequest.getCityId());
        Street street=modelMapperService.getMapperRequest().map(addStreetRequest,Street.class);
        Street savedStreet = streetRepository.save(street);
//        AddStreetResponse response = new AddStreetResponse(savedStreet.getId(),
//                savedStreet.getName());
        AddStreetResponse response=modelMapperService.getMapperResponse().map(savedStreet,AddStreetResponse.class);
        return new SuccessDataResult<AddStreetResponse>(response, messageSourceService.getMessages(Messages.Street.streetAddSuccessMessage));
    }

    @Override
    public DataResult<List<GetAllStreetsResponse>> getAllDto() {
        List<GetAllStreetsResponse> response= streetRepository.getAllDto();
        return new SuccessDataResult<List<GetAllStreetsResponse>>(response,messageSourceService.getMessages(Messages.Street.streetGetAllSuccessMessage));
    }
    @Override
    public Page<Street> findAllWithPagination(Pageable pageable) {
        return streetRepository.findAll(pageable);
    }

    @Override
    public Slice<Street> findAllWithSlice(Pageable pageable) {
        return streetRepository.getAllWithSlice(pageable);
    }

    private void checkIfCityExists(int id){
        boolean isExists = cityRepository.existsById(id);
        if(!isExists) {
            throw new BusinessException(messageSourceService.getMessages(Messages.City.CityNotExistWithId));
        }
    }
}