package com.ust.BookService.BookService.controller;

import com.ust.BookService.BookService.dto.BookDto;
import com.ust.BookService.BookService.model.Book;
import com.ust.BookService.BookService.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping
    public Book createABook(@RequestBody @Valid BookDto book){
        Book newBook = toEntity(book);
        return bookService.createABook(newBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> book = bookService.findAllBooks();
        return ResponseEntity.status(HttpStatus.FOUND).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findABook(@PathVariable long id){
        Book book = bookService.findABook(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateABook(@PathVariable long id,@RequestBody @Valid BookDto book){
        Book newBook = toEntity(book);
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.updateABook(id,newBook));
    }

    @DeleteMapping("/{id}")
    public void deleteABook(@PathVariable long id){
        bookService.deleteBook(id);
    }

    @GetMapping("/getquantity/{id}")
    public int returnQuantity(@PathVariable long id){
        return bookService.returnQuantity(id);
    }

    public BookDto toDto(Book book){
        return new BookDto(book.getBookId(),
                book.getBookName(),
                book.getAuthorName(),
                book.getPrice(),
                book.getStock());
    }

    public Book toEntity(BookDto dto){
        Book book = new Book();
        book.setBookId(dto.bookId());
        book.setBookName(dto.bookName());
        book.setPrice(dto.price());
        book.setStock(dto.stock());
        book.setAuthorName(dto.authorName());
        return book;
    }

}
