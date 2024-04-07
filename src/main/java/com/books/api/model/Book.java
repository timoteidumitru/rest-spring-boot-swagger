package com.books.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String name;
    private String intro;
    private String category;
    private double rating;
}
