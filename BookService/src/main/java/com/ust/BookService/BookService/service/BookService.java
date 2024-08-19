package com.ust.BookService.BookService.service;
import com.ust.BookService.BookService.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findABook(long id);
    Book createABook(Book book);
    Book updateABook(long id, Book book);
    void deleteBook(long id);
    int returnQuantity(long id);


}
