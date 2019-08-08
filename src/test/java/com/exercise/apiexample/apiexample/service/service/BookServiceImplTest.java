package com.exercise.apiexample.apiexample.service.service;

import com.exercise.apiexample.apiexample.Service.BookMapper;
import com.exercise.apiexample.apiexample.Service.BookService;
import com.exercise.apiexample.apiexample.Service.BookServiceImpl;

import com.exercise.apiexample.apiexample.model.Book;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


public class BookServiceImplTest {


    @Mock
    RestTemplate restTemplate;

    @Mock
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    BookServiceImpl bookServiceImpl;

    @Mock
    MapSqlParameterSource mapSqlParameterSource;

    @Mock
    BookService bookService;

    @Mock
    BookMapper  bookMapper;


    @Test
     public void getBookByFirstName() {



    }



}


