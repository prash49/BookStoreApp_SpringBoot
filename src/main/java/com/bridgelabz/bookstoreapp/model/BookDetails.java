package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookDetails implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column( name = "bookName")
    private String bookName;
    @Column  (name = "bookAuthor")
    private String bookAuthor;
    @Column (name = "bookDescription")
    private String bookDescription;
    @Column (name = "bookLogo")
    private String bookLogo;
    @Column (name = "bookPrice")
    private int bookPrice;
    @Column (name = "bookQuantity")
    private int bookQuantity;

    public void createBook (BookDetailsDto bookDto){
        this.bookName = bookDto.getBookName();
        this.bookAuthor = bookDto.getBookAuthor();
        this.bookDescription =  bookDto.getBookDescription();
        this.bookLogo =  bookDto.getBookLogo();
        this.bookPrice = bookDto.getBookPrice();
        this.bookQuantity = bookDto.getBookQuantity();

    }


    public void updateBook (BookDetailsDto bookDto){
        this.bookName = bookDto.getBookName();
        this.bookAuthor = bookDto.getBookAuthor();
        this.bookDescription =  bookDto.getBookDescription();
        this.bookLogo =  bookDto.getBookLogo();
        this.bookPrice = bookDto.getBookPrice();
        this.bookQuantity = bookDto.getBookQuantity();

    }

    public int getBookId() {
        return bookId;
    }

    public BookDetails setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public BookDetails setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public BookDetails setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public BookDetails setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
        return this;
    }

    public String getBookLogo() {
        return bookLogo;
    }

    public BookDetails setBookLogo(String bookLogo) {
        this.bookLogo = bookLogo;
        return this;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public BookDetails setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
        return this;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public BookDetails setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
        return this;
    }
}
