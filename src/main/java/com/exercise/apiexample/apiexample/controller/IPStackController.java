package com.exercise.apiexample.apiexample.controller;

import com.exercise.apiexample.apiexample.Service.IPStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@RestController
@Produces("/application/json")
@Consumes("/application/json")
public class IPStackController {

    @Autowired
    IPStackService ipStackService;


    @PostMapping("/details/{ipAddress}")
    public Object getDetailsOfIpAddress(@PathVariable("ipAddress")String address){

        return ipStackService.getDetailsOfIpAddress(address);

    }

    @PostMapping("/uploadFiles/")
    public String uploadDoc(MultipartFile multipartFile){

        return "Files Uploaded Successfully";
    }

}
