package com.example.guestttSuggestion.controller;

import com.example.guestttSuggestion.entity.GuestSuggestionEntity;
import com.example.guestttSuggestion.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuggestionStatusController {

    @Autowired
    private GuestSuggestionService guestSuggestionService;

    @GetMapping("/suggestions/created")
    public List<GuestSuggestionEntity> getAllCreatedSuggestions() {
        return guestSuggestionService.findAllCreatedSuggestions();
    }

    @GetMapping("/suggestions/removed")
    public List<GuestSuggestionEntity> getAllRemovedSuggestions() {
        return guestSuggestionService.findAllRemovedSuggestions();
    }
}
