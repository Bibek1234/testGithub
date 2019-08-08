package com.exercise.apiexample.apiexample.Service;

import com.exercise.apiexample.apiexample.model.Book;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {


    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book book = new Book();
        book.setBook_name(getString(rs.getString("book_name")));
        book.setAuthor_last_name(rs.getString("author_last_name"));
        book.setAuthor_first_name(rs.getString("author_first_name"));
        book.setBook_details(rs.getString("book_details"));
        book.setBook_type(rs.getString("book_type"));
        return book;
    }

    static String getString(String a){
        if (StringUtils.isNotEmpty(a)){
            return a.trim();
        }
        return null;
    }
}
