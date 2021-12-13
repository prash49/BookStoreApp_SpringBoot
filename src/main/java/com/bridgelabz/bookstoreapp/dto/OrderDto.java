package com.bridgelabz.bookstoreapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
}
