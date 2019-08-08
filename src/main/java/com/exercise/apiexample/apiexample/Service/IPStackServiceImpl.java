package com.exercise.apiexample.apiexample.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.core.MediaType;

@Service
public class IPStackServiceImpl implements IPStackService {

    private static final org.slf4j.Logger Logger= LoggerFactory.getLogger(IPStackServiceImpl.class);

    @Value("${ipstackurl}")
    private String url;

    @Autowired
    private final RestTemplate restTemplate;

    public IPStackServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Object getDetailsOfIpAddress(String address) {

       HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_JSON));

        MultiValueMap<String,String> map=new LinkedMultiValueMap<>();
        map.add("key","9d72b0d7f8fe18bb4f6ee64d64436ad5");
        Logger.info("here"+map);

        System.out.println(map);

        HttpEntity<MultiValueMap<String,String>> request=new HttpEntity<>(map,httpHeaders);

        Logger.info("httpentity"+request);
        String url1=url+"?"+"key="+"39194f3a39a04749bf465716190404"+"&q="+address;
        Logger.info("url is"+url1);

        ResponseEntity<Object> responseEntity=restTemplate.postForEntity(url1,request,Object.class);
        System.out.println(responseEntity);

        return responseEntity;

    }

    @Override
    public void uploadFile(MultipartFile multipartFile) {

    }
}
