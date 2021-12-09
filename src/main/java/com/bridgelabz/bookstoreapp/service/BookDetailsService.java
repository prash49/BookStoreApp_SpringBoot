package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.BookDetails;

import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;


@Service
@Slf4j
public class BookDetailsService implements IBookDetailsService {
    @Autowired
    BookDetailsRepository bookRepo;

    @Override
    public List<BookDetails> showAllBooks() {
        List<BookDetails> allBooks = bookRepo.findAll();
        return allBooks;
    }

    @Override
    public BookDetails addBook(BookDetailsDto bookDto) {
        BookDetails bookAdded = new BookDetails();
        bookAdded.createBook(bookDto);
        return bookRepo.save(bookAdded);

    }

    @Override
    public BookDetails getBookById(int bookId) {
        return bookRepo.findByBookId(bookId)
                .orElseThrow(() -> new UserRegistrationException("Book  with id " + bookId + " does not exist in database..!"));
    }

    @Override
    public BookDetails getBookByName(String bookName) {
        return bookRepo.findByBookName(bookName)
                .orElseThrow(() -> new UserRegistrationException("Book does not exist in database..!"));
    }


    @Override
    public BookDetails updateBook(int bookId, BookDetailsDto bookDTO) {
        BookDetails bookData = this.getBookById(bookId);
        bookData.updateBook(bookDTO);
        return bookRepo.save(bookData);

    }

    @Override
    public BookDetails updateBookByName(String bookName, BookDetailsDto bookDTO) {
        BookDetails bookData = this.getBookByName(bookName);
        bookData.updateBook(bookDTO);
        return bookRepo.save(bookData);
    }

    @Override
    public void deleteBook(int bookId) {
        BookDetails isBookPresent = this.getBookById(bookId);
        bookRepo.delete(isBookPresent);

    }

    @Override
    public BookDetails updateBookQuantity(int bookId, int bookQuantity) {
      BookDetails book = this.getBookById(bookId);
      book.setBookQuantity(bookQuantity);
      return bookRepo.save(book);
    }

    @Override
    public BookDetails updateBookPrice(int bookId, int bookPrice) {
        BookDetails book = this.getBookById(bookId);
        book.setBookPrice(bookPrice);
        return bookRepo.save(book);
    }


}
