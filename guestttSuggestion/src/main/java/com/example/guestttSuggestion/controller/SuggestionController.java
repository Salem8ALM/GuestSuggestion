package com.example.guestttSuggestion.controller;

import com.example.guestttSuggestion.bo.CreateSuggestionRequest;
import com.example.guestttSuggestion.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuggestionController {

    @Autowired // inject
    GuestSuggestionService guestSuggestionService;

    @PostMapping("/api/suggestions")
    public ResponseEntity<String> newSuggestion(@RequestBody CreateSuggestionRequest request) {
        String response = guestSuggestionService.processSuggestion(request.getSuggestion(), request.getRate());
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }}
