package com.exercise.apiexample.apiexample.model;

import javax.ws.rs.core.Response;

public interface ResponsePayLoadExtractor {

    static Response returnResponseAs(Response response,String groupKey,String propagationMessage){
        return Response.accepted().build();
    }
}
