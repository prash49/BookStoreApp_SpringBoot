package com.bridgelabz.bookstoreapp.model;


import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bookId")
//    private BookDetails book;

    private int bookId;

//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private UserRegistrationData user;

private int userId;
    private boolean cancel = false;
//
    public void crateOrder(OrderDto orderDto) {
        this.orderDate = LocalDate.now();
        this.price = orderDto.getPrice();
        this.quantity = orderDto.getQuantity();
        this.address = orderDto.getAddress();
        this.userId = orderDto.getUserId();
        this.bookId = orderDto.getBookId();
       this.cancel = false;

    }
    public OrderData(OrderDto orderDto){
       this.orderDate = LocalDate.now();
       this.price = orderDto.getPrice();
       this.address = orderDto.getAddress();
       this.userId = orderDto.getUserId();
       this.bookId = orderDto.getBookId();
       this.quantity = orderDto.getQuantity();

    }
//
//    public OrderData() {
//
//    }
//
//    public OrderData(UserRegistrationData user, BookDetails book, int price, int quantity, String address, boolean cancel) {
//        this.user = user;
//        this.book = book;
//        this.price = price;
//        this.quantity = quantity;
//        this.address = address;
//        this.cancel = cancel;
//
//
//    }


    public int getId() {
        return id;
    }

    public OrderData setId(int id) {
        this.id = id;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderData setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderData setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OrderData setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderData setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getBookId() {
        return bookId;
    }

    public OrderData setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public boolean isCancel() {
        return cancel;
    }

    public OrderData setCancel(boolean cancel) {
        this.cancel = cancel;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public OrderData setUserId(int userId) {
        this.userId = userId;
        return this;
    }
}
