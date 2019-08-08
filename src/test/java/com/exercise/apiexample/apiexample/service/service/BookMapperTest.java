package com.exercise.apiexample.apiexample.service.service;

import com.exercise.apiexample.apiexample.Service.BookMapper;
import com.exercise.apiexample.apiexample.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapperTest {

    @InjectMocks
    BookMapper bookMapper;


    @Before
    public void init(){
        bookMapper=new BookMapper();
        Book book=new Book();
        book.setAuthor_first_name("FIRSTNAME");
        book.setBook_name("BOOK");
        book.setBook_details("BookDetails");
        book.setAuthor_last_name("LASTNAME");
    }

    @After
    public void tearDown(){
        bookMapper=null;
    }

    @Test
    public void test() throws SQLException {




    }
}
