package com.exercise.apiexample.apiexample.model;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Headers {



    //THis is use to add headers in the rest webservices like application content language etc


    private MultiValueMap<String,String> generateHeaders(){

        MultiValueMap<String,String> map=new LinkedMultiValueMap<>();
        Map map1 =new HashMap<String,String>();
        map1.put("Content-Type","application/json");
        map1.put("x-request-unique-id", UUID.randomUUID().toString());
        map.setAll(map1);
        return map;
    }
}
