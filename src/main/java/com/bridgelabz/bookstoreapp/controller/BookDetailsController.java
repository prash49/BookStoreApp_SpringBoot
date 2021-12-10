package com.bridgelabz.bookstoreapp.controller;


import com.bridgelabz.bookstoreapp.dto.BookDetailsDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;

import com.bridgelabz.bookstoreapp.model.BookDetails;

import com.bridgelabz.bookstoreapp.repository.BookDetailsRepository;
import com.bridgelabz.bookstoreapp.service.IBookDetailsService;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookservice")
@Slf4j
public class BookDetailsController {

    @Autowired
    private IBookDetailsService bookService;

    @Autowired
    private BookDetailsRepository bookRepo;

    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping(value = {"", "/", "/getbooks"})
    public ResponseEntity<ResponseDTO> getAllBooks() {
        List<BookDetails> allBooks = bookService.showAllBooks();
        ResponseDTO dto = new ResponseDTO("All Books Retrieved successfully:", allBooks);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/getBookByName/{bookName}")
    public ResponseEntity<ResponseDTO> getOneBookByName(@PathVariable String bookName)
    {
        BookDetails getOneBook = bookService.getBookByName(bookName);
        ResponseDTO dto = new ResponseDTO("Book retrieved successfully"+bookName, getOneBook);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/getBook/{bookId}")
    public ResponseEntity<ResponseDTO> getOneBook(@PathVariable int bookId)
    {
        BookDetails getOneBook = bookService.getBookById(bookId);
        ResponseDTO dto = new ResponseDTO("Book retrieved successfully"+bookId, getOneBook);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookDetailsDto bookDto) {
        BookDetails addBook = bookService.addBook(bookDto);
        ResponseDTO dto = new ResponseDTO("Book added sucessfully ", tokenUtil.createToken(addBook.getBookId()) );
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateBookData(@PathVariable("bookId") int bookId,
                                                      @Valid @RequestBody BookDetailsDto bookDTO) {
        BookDetails updateBook = bookService.updateBook(bookId, bookDTO);
        log.debug(" After Update " + updateBook.toString());
        ResponseDTO response = new ResponseDTO("Updated  for" + bookId, updateBook);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PutMapping("/updateByName/{bookName}")
    public ResponseEntity<ResponseDTO> updateBookDataByName(@PathVariable("bookName") String bookName,
                                                            @Valid @RequestBody BookDetailsDto bookDTO) {
        BookDetails updateBook = bookService.updateBookByName(bookName, bookDTO);
        log.debug(" After Update " + updateBook.toString());
        ResponseDTO response = new ResponseDTO("Updated  for Data " + bookName, updateBook);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + bookId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }

    @PutMapping("/updatequantity/{bookId}/{bookQuantity}")
    public ResponseEntity<ResponseDTO> updateBookQuantity(@PathVariable int bookId, @PathVariable int bookQuantity) {
        BookDetails updateBookQuantity = bookService.updateBookQuantity(bookId, bookQuantity);
        ResponseDTO response = new ResponseDTO("Book Quantity Update is success for id " + bookId, updateBookQuantity);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }


    @PutMapping("/updateprice/{bookId}/{bookPrice}")
    public ResponseEntity<ResponseDTO> updateBookPrice(@PathVariable int bookId, @PathVariable int bookPrice) {
        BookDetails updateBookPrice = bookService.updateBookPrice(bookId, bookPrice);
        ResponseDTO response = new ResponseDTO("Book Price Update is success for id " + bookId, updateBookPrice);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }


}
