package com.ust.BookService.BookService.service;

import com.ust.BookService.BookService.model.Book;
import com.ust.BookService.BookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findABook(long id) {

        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book with id:"+id+"not found"));
    }

    @Override
    public Book createABook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateABook(long id, Book book) throws RuntimeException {
        return bookRepository.findById(book.getBookId()).map(existingBook->{
            existingBook.setBookName(book.getBookName());
            existingBook.setAuthorName(book.getAuthorName());
            existingBook.setStock(book.getStock());
            existingBook.setPrice(book.getPrice());
            existingBook.setBookId(book.getBookId());
            return bookRepository.save(existingBook);
        }).orElseThrow(()->new RuntimeException("Book does not exist"));

    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);

    }

    public int returnQuantity(long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not fond"));
        int quantity = book.getStock();
        return quantity;
    }
}
