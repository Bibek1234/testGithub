package com.exercise.apiexample.apiexample.Service;

import com.exercise.apiexample.apiexample.model.Book;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Repository
public class BookServiceImpl implements BookService {


@Autowired
    private final RestTemplate restTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${createBookQuery}")
    private String createBookQuery;

    @Value("${getBookByFirstName}")
    private String bookQuery;

    private String bookQ;

    public BookServiceImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void hello(){
    System.out.println("Hello this is Bibek"+this.getClass());

}
  @PostConstruct
  public void init(){
        try { bookQ= IOUtils.toString(this.getClass().getResourceAsStream(bookQuery));
        } catch (IOException e) {
            e.printStackTrace();
        }
}



    @Override
    public List<Book> getBookByFirstName(Book book) throws IOException {


        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
        mapSqlParameterSource.addValue("book_first_name",book.getAuthor_first_name());


        List<Book> bookList=namedParameterJdbcTemplate.query(bookQ,mapSqlParameterSource,(new BookMapper()));
        return bookList;
    }



}
