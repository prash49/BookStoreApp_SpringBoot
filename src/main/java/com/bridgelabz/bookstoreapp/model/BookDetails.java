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

}
