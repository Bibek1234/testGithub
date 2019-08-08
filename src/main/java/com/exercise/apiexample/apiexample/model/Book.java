package com.exercise.apiexample.apiexample.model;

public class Book {

    private String book_name;
    private String author_first_name;
    private String author_last_name;
    private String book_type;
    private String book_details;

    public Book(){

    }

    public Book(String book_name, String author_first_name, String author_last_name, String book_type, String book_details) {
        this.book_name = book_name;
        this.author_first_name = author_first_name;
        this.author_last_name = author_last_name;
        this.book_type = book_type;
        this.book_details = book_details;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBook_details() {
        return book_details;
    }

    public void setBook_details(String book_details) {
        this.book_details = book_details;
    }
}
