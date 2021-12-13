package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.bridgelabz.bookstoreapp.model.OrderData;

import java.util.List;

public interface IOrderService {

    OrderData placeOrder(String token, OrderDto orderDto);

    String cancelOrder(String token, int orderId);

    List<OrderData> userOrders(String token);

    List<OrderData> allOrders();
}
