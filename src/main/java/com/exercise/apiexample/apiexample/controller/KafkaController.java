package com.exercise.apiexample.apiexample.controller;

import com.exercise.apiexample.apiexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private static final String TOPIC="us_bibek";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


   /* @PostMapping("/publish/{message}")
    public String postMessage(@PathVariable String message){
        kafkaTemplate.send(TOPIC,new Book(message,"bibek","bhurtel","history","hello this is history"));
        return "Message Published Successfully";
    }*/



}
