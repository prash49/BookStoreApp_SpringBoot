package com.bridgelabz.bookstoreapp.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int price;
    private int quantity;
    private String address;

    private int userId;

    private int bookId;

    private boolean cancel = false;

    public int getPrice() {
        return price;
    }

    public OrderDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getBookId() {
        return bookId;
    }

    public OrderDto setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public boolean isCancel() {
        return cancel;
    }

    public OrderDto setCancel(boolean cancel) {
        this.cancel = cancel;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public OrderDto setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderDto setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
