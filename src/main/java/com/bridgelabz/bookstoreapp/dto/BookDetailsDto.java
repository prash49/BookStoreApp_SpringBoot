package com.bridgelabz.bookstoreapp.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDetailsDto {
    public String bookName;
    public String bookAuthor;
    public String bookDescription;
    public String bookLogo;
    public int bookPrice;
    public int bookQuantity;

    public String getBookName() {
        return bookName;
    }

    public BookDetailsDto setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public BookDetailsDto setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
        return this;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public BookDetailsDto setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }

    public String getBookLogo() {
        return bookLogo;
    }

    public BookDetailsDto setBookLogo(String bookLogo) {
        this.bookLogo = bookLogo;
        return this;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public BookDetailsDto setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
        return this;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public BookDetailsDto setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
        return this;
    }
}
