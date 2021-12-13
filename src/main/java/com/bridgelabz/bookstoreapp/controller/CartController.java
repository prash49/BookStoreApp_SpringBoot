package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.CartServiceDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.CartData;
import com.bridgelabz.bookstoreapp.repository.CartRepository;
import com.bridgelabz.bookstoreapp.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private ICartService cartService;

    @Autowired
    CartRepository cartRepo;

    @PostMapping("/add")
    ResponseEntity<ResponseDTO> addToCart(@RequestHeader(name = "token") String token, @RequestBody CartServiceDto cartDTO) {
        CartData add = cartService.addToCart(token, cartDTO);
        ResponseDTO response = new ResponseDTO("Product Added To Cart ", add);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{cartId}")
    ResponseEntity<ResponseDTO> removeFromCart(@PathVariable("cartId") int cartId) {
        cartService.deleteFromCart(cartId);
        ResponseDTO response = new ResponseDTO("Delete call success for item Removed From Cart ", "deleted id:" + cartId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{cartId}/{quantity}")
    ResponseEntity<ResponseDTO> updateCart(@RequestHeader(name = "token") String token, @PathVariable("cartId") int cartId,
                                           @PathVariable("quantity") int quantity) {
        CartData cart = cartService.updateQuantity(token, cartId, quantity);
        ResponseDTO response = new ResponseDTO("Update call success for item Quantity updated From Cart ", cart);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    ResponseEntity<ResponseDTO> findAllCartsByUser(@RequestHeader(name = "token") String token) {
        List<CartData> allItemsForUser = cartService.findAllInCart(token);
        ResponseDTO response = new ResponseDTO("All Items in Cart for user ", allItemsForUser);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    ResponseEntity<ResponseDTO> findAllCarts() {
        List<CartData> allItems = cartRepo.findAll();
        ResponseDTO response = new ResponseDTO("All Items in Cart ", allItems);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

}
