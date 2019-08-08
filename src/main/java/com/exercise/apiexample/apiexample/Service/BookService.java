package com.exercise.apiexample.apiexample.Service;

import com.exercise.apiexample.apiexample.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public interface BookService {


    List<Book> getBookByFirstName(Book book) throws IOException;



}
