package com.ust.BookService.BookService.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record BookDto(long bookId,
                      @NotEmpty(message = "Book Name is Required")
                      String bookName,
                      @NotEmpty(message = "Author Name Required")
                      @Length(min = 2, max = 255)
                      String authorName,
                      @NotNull(message = "Price Field is required")
                      int price,
                      @NotNull(message = "Stock needs to be specified")
                      @Min(value = 0)
                      int stock
)
{}
