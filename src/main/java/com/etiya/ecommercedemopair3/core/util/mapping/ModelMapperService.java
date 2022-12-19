package com.etiya.ecommercedemopair3.core.util.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper getMapperRequest();
    ModelMapper getMapperResponse();
}