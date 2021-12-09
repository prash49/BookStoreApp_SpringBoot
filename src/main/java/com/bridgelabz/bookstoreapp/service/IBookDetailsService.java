package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.model.BookDetails;
import com.bridgelabz.bookstoreapp.model.UserRegistrationData;

import java.util.List;

public interface IBookDetailsService {

    List<BookDetails> showAllBooks();

    BookDetails addBook(BookDetailsDto bookDto);
    BookDetails getBookById(int bookId);
    BookDetails getBookByName(String bookName);
    BookDetails updateBook(int bookId, BookDetailsDto bookDTO);

    BookDetails updateBookByName(String bookName, BookDetailsDto bookDTO);


    void deleteBook(int bookId);

    BookDetails updateBookQuantity(int bookId, int bookQuantity);

    BookDetails updateBookPrice(int bookId, int bookPrice);
}
