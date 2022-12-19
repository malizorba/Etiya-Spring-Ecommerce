package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CityService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercedemopair3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.City;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair3.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;
    private CountryRepository countryRepository;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<City> getById(int id) {
        City response=  cityRepository.findById(id).orElseThrow();
        return new SuccessDataResult<City>(response, messageSourceService.getMessages(Messages.City.CityGetById));
    }

    @Override
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {
//        City city = new City();
//        city.setName(addCityRequest.getName());
        checkIfCountryExists(addCityRequest.getCountryId());
        City city = modelMapperService.getMapperRequest().map(addCityRequest, City.class);
        City savedCity = cityRepository.save(city);
//        AddCityResponse response = new AddCityResponse(savedCity.getId(), savedCity.getName());
        AddCityResponse response = modelMapperService.getMapperResponse().map(savedCity, AddCityResponse.class);
        return new SuccessDataResult<AddCityResponse>(response, messageSourceService.getMessages(Messages.City.CityAddSuccessMessage));
    }
    @Override
    public Page<City> findAllWithPagination(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Slice<City> findAllWithSlice(Pageable pageable) {
        return cityRepository.getAllWithSlice(pageable);
    }
    private void checkIfCountryExists(int id) {
        boolean isExists = countryRepository.existsById(id);
        if (!isExists) {
            //business exception
            throw new BusinessException(messageSourceService.getMessages(Messages.Country.CountryNotExistWithId));
        }
    }
}

