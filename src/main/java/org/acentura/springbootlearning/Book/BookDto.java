package org.acentura.springbootlearning.Book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDto {


    @NotBlank(message = "Title is mandatory")
    @Size(min = 2, max = 256, message = "Title must be between 2 and 256 characters")
    private String title;

    public BookDto(Long id, String title, String author) {

        this.title = title;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
