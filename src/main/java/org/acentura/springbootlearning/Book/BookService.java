package org.acentura.springbootlearning.Book;

import org.acentura.springbootlearning.Exceptions.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book addBook(BookDto bookDto) {
        if (bookRepo.existsByTitle(bookDto.getTitle())) {
            throw new ResourceAlreadyExistsException("Book with this title already exists.");
        }
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        return bookRepo.save(book);
    }


}
