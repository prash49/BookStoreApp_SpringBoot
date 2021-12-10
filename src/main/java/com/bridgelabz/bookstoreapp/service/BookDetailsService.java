package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.BookDetails;

import com.bridgelabz.bookstoreapp.model.UserRegistrationData;
import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
import com.bridgelabz.bookstoreapp.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class BookDetailsService implements IBookDetailsService {
    @Autowired
    BookDetailsRepository bookRepo;

    @Autowired
    UserRegistrationRepository userRepo;

    @Autowired
    UserRegistrationService service;

    @Autowired
    TokenUtil tokenUtil;


    @Override
    public List<BookDetails> showAllBooks(String token) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            List<BookDetails> allBooks = bookRepo.findAll();
            return allBooks;
        } else return null;
    }

    @Override
    public BookDetails addBook(String token, BookDetailsDto bookDto) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            BookDetails bookAdded = new BookDetails();
            bookAdded.createBook(bookDto);
            return bookRepo.save(bookAdded);
        }
        return null;
    }

    @Override
    public BookDetails getBookById(String token, int bookId) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            return bookRepo.findByBookId(bookId)
                    .orElseThrow(() -> new UserRegistrationException("Book  with id " + bookId + " does not exist in database..!"));
        }
        return null;
    }

    @Override
    public BookDetails getBookByName(String token, String bookName) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            return bookRepo.findByBookName(bookName)
                    .orElseThrow(() -> new UserRegistrationException("Book does not exist in database..!"));
        }
        return null;
    }


    @Override
    public BookDetails updateBook(String token, int bookId, BookDetailsDto bookDTO) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            BookDetails bookData = this.getBookById(token, bookId);
            bookData.updateBook(bookDTO);
            return bookRepo.save(bookData);
        }
        return null;
    }

    @Override
    public BookDetails updateBookByName(String token, String bookName, BookDetailsDto bookDTO) {
//        Optional<BookDetails> bookPresence = bookRepo.findByBookName(bookName);
//        if (bookPresence.isPresent()) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            BookDetails bookData = this.getBookByName(token, bookName);
            bookData.updateBook(bookDTO);
            return bookRepo.save(bookData);
        }
        return null;
    }

    @Override
    public void deleteBook(String token, int bookId) {
        int id = Math.toIntExact(tokenUtil.decodeToken(token));
        Optional<UserRegistrationData> isPresent = userRepo.findById(id);
        if (isPresent.isPresent()) {
            BookDetails isBookPresent = this.getBookById(token, bookId);
            bookRepo.delete(isBookPresent);

        }
    }

        @Override
        public BookDetails updateBookQuantity (String token,int bookId, int bookQuantity){
            int id = Math.toIntExact(tokenUtil.decodeToken(token));
            Optional<UserRegistrationData> isPresent = userRepo.findById(id);
            if (isPresent.isPresent()) {
                BookDetails book = this.getBookById(token,bookId);
                book.setBookQuantity(bookQuantity);
                return bookRepo.save(book);
            }
            return null;
        }

        @Override
        public BookDetails updateBookPrice (String token,int bookId, int bookPrice){

            int id = Math.toIntExact(tokenUtil.decodeToken(token));
            Optional<UserRegistrationData> isPresent = userRepo.findById(id);
            if (isPresent.isPresent()) {
                BookDetails book = this.getBookById(token,bookId);
                book.setBookPrice(bookPrice);
                return bookRepo.save(book);
            }
            return null;

        }
    }
