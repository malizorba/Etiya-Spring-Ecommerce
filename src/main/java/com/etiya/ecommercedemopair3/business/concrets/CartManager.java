package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CartService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.cart.AddCartRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.cart.AddCartResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.messages.MessageSourceService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Cart;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.repository.abstracts.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private ModelMapperService modelMapperService;
    private MessageSourceService messageSourceService;

    @Override
    public DataResult<AddCartResponse> addCart(AddCartRequest addCartRequest) {
//        Cart cart = new Cart();
//        cart.setTotalPrice(addCartRequest.getTotalPrice());
        Cart cart=modelMapperService.getMapperRequest().map(addCartRequest,Cart.class);
        Cart savedCart = cartRepository.save(cart);
//        AddCartResponse response = new AddCartResponse(savedCart.getId(), savedCart.getTotalPrice());
        AddCartResponse response= modelMapperService.getMapperResponse().map(savedCart,AddCartResponse.class);
        return new SuccessDataResult<AddCartResponse>(response, messageSourceService.getMessages(Messages.Cart.cartAddSuccessMessage));
    }

    @Override
    public Page<Cart> findAllWithPagination(Pageable pageable) {
        return cartRepository.findAll(pageable);
    }

    @Override
    public Slice<Cart> findAllWithSlice(Pageable pageable) {
        return cartRepository.getAllWithSlice(pageable);
    }
}
