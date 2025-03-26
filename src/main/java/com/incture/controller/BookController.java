package com.incture.controller;

import com.incture.entity.Book;
import com.incture.service.BookService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

  @GetMapping("/{id}")
  public Book getBookById(@PathVariable Long id) {
      return bookService.getBookById(id)
              .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
  }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        boolean isDeleted = bookService.deleteBook(id);
        if (isDeleted) {
            return ResponseEntity.ok().body(Map.of("message", "Book deleted successfully"));
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

}
