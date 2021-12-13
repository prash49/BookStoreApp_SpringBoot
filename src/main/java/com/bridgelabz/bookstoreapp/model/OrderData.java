package com.bridgelabz.bookstoreapp.model;


import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderDate;
    private int price;
    private int quantity;
    private String address;
    private int userId;
    private int bookId;
    private boolean cancel= false;

    public void crateOrder(OrderDto orderDto) {
        this.orderDate = LocalDate.now();
        this.price = orderDto.getPrice();
        this.quantity = orderDto.getQuantity();
        this.address = orderDto.getAddress();
        this.userId = orderDto.getUserId();
        this.bookId = orderDto.getBookId();
       this.cancel = false;

    }

}
