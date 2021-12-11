package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartServiceDto;
import com.bridgelabz.bookstoreapp.model.CartData;

import java.util.List;

public interface ICartService {

    CartData addToCart(String token,CartServiceDto cartDTO);

    void deleteFromCart(int cartId);

    CartData updateQuantity(String token, int cartId, int quantity);

    List<CartData> findAllInCart(String token);
}
