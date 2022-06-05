package com.beaconfire.asynchronous.AsyncRestApp.controller;

import com.beaconfire.asynchronous.AsyncRestApp.service.AsyncService;
import com.beaconfire.asynchronous.AsyncRestApp.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("content")
public class AsyncController {

    private NormalService normalService;
    private AsyncService asyncService;

    @Autowired
    public void setNormalService(NormalService normalService) {
        this.normalService = normalService;
    }

    @Autowired
    public void setAsyncService(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("nonAsync")
    public ResponseEntity<String> getInfoNonAsync(){
        String result = normalService.getAllInfoNonAsync();

        return ResponseEntity.ok(result);
    }

    @GetMapping("async")
    public ResponseEntity<String> getInfoAsync(){
        String result = asyncService.getAllInfoAsync();
        return ResponseEntity.ok(result);
    }
}
