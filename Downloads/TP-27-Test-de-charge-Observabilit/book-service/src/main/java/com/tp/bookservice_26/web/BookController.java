package com.tp.bookservice_26.web;

import com.tp.bookservice_26.domain.Book;
import com.tp.bookservice_26.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> all() { return service.all(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book b) { return service.create(b); }

    @PostMapping("/{id}/borrow")
    public BookService.BorrowResult borrow(@PathVariable long id) {
        return service.borrow(id);
    }
}