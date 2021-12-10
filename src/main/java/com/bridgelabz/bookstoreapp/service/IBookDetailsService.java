package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;

import java.util.List;

public interface IBookDetailsService {

    List<BookDetails> showAllBooks(String token);

    BookDetails addBook(String token,BookDetailsDto bookDto);
    BookDetails getBookById(String token,int bookId);
    BookDetails getBookByName(String token,String bookName);
    BookDetails updateBook(String token,int bookId, BookDetailsDto bookDTO);

    BookDetails updateBookByName(String token,String bookName, BookDetailsDto bookDTO);


    void deleteBook(String token,int bookId);

    BookDetails updateBookQuantity(String token,int bookId, int bookQuantity);

    BookDetails updateBookPrice(String token,int bookId, int bookPrice);
}
