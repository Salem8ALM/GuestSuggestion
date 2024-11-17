package com.example.guestttSuggestion.service;

import com.example.guestttSuggestion.entity.GuestSuggestionEntity;
import com.example.guestttSuggestion.repository.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestSuggestionService {

    @Autowired
    private GuestSuggestionRepository guestSuggestionRepository;

    SuggestionProcessor suggestionProcessor = (suggestion, rate) -> {
        GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
        suggestionEntity.setSuggestion(suggestion);
        suggestionEntity.setRate(rate);
        guestSuggestionRepository.save(suggestionEntity);


    };

    public String processSuggestion(String text, double rate){
        suggestionProcessor.suggestion(text,rate);
        return " message received successfurry ";
    }
}
