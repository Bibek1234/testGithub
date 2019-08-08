package com.exercise.apiexample.apiexample.controller;

import com.exercise.apiexample.apiexample.Service.BookService;
import com.exercise.apiexample.apiexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;


@RestController
public class BookController {

  //  private static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(BookController.class);

    @Autowired
     private BookService bookService;

    @GetMapping("/getBookByFirstName")
    public List<Book> getListOfBooksByFirstName(Book book) throws IOException {

        List<Book> bookList=bookService.getBookByFirstName(book);

        return bookList;
    }

    @PostMapping("/upload/doc")
    public Response uploadDoc(String a,@Context UriInfo uriInfo) throws Exception {
        System.out.println("hello");
        UriBuilder uriBuilder=uriInfo.getRequestUriBuilder();

        return Response.created(uriBuilder.build()).build();
    }





}
