package org.acentura.springbootlearning.Book;

import jakarta.validation.Valid;
import org.acentura.springbootlearning.Exceptions.ResourceAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {

    private BookService  bookService;

    @PostMapping("/create")
    public ResponseEntity<?> addBook(@RequestBody @Valid BookDto bookDto, BindingResult bindingResult) {
        // Handle validation errors
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            Book savedBook = bookService.addBook(bookDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully with ID " + savedBook.getId());
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong "+ e.getMessage());
        }
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }
}
