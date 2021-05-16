package com.example.cor.controllers;

import com.example.cor.chain.PersonChain;
import com.example.cor.resources.PersonResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController implements PersonResource {

    @Autowired
    private PersonChain personChain;


    @Override
    public ResponseEntity<String> create(@RequestBody String message) {
        personChain.handle(message);
        return ResponseEntity.accepted().body(message);
    }
}
