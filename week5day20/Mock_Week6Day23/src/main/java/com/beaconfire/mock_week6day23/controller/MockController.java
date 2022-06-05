package com.beaconfire.mock_week6day23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("users")
public class MockController {
    private RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> mockGetUserId(@PathVariable String id){
        String requestURL = "https://jsonplaceholder.typicode.com/users/"+id;
        try{
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    requestURL, HttpMethod.GET, null, String.class
            );
            return ResponseEntity.ok(responseEntity.getBody());
        } catch (HttpClientErrorException e){
            return ResponseEntity.badRequest().build();
        }

    }
}
