package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.bridgelabz.bookstoreapp.model.OrderData;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.OrderRepository;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderService implements  IOrderService{

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    UserRegistrationRepository userRepo;

    @Autowired
    OrderRepository orderRepo;


    @Override
    public OrderData placeOrder(String token, OrderDto orderDto) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if(isPresent.isPresent()){
            OrderData order = new OrderData();
           order.crateOrder(orderDto);
           return orderRepo.save(order);
        }
        return null;
    }

    @Override
    public String cancelOrder(String token, int orderId) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            Optional<OrderData> order = orderRepo.findById(orderId);
            if (order.isPresent()) {
                order.get().setCancel(true);
                orderRepo.save(order.get());
                return "Cancel order Successfull";
            }

        }
        return  "cancel order not successfull";
    }

    @Override
    public List<OrderData> userOrders(String token) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            List<OrderData> orders = orderRepo.findAllByUserId(id);
            return orders;
        }
        return  null;
    }

    @Override
    public List<OrderData> allOrders() {
       List<OrderData> orders = orderRepo.findAll();
       if(orders.isEmpty()){
           return null;
       }else
       {
        for(int i=0;i< orders.size();i++) {
            int id = orders.get(i).getId();
            Optional<OrderData> orderByOrderId = orderRepo.findById(id);
            if (orderByOrderId.isPresent()) {
                orderByOrderId.get().setCancel(false);
                orderRepo.save(orderByOrderId.get());
                return orders;
            }
        }

       }return  null;
    }
}
