package com.exercise.apiexample.apiexample.Service;

import org.springframework.web.multipart.MultipartFile;

public interface IPStackService {

    Object getDetailsOfIpAddress(String address);

    void uploadFile(MultipartFile multipartFile);


}
