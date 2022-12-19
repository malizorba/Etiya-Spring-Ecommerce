package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;

public interface OrderService {
    DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);
}
