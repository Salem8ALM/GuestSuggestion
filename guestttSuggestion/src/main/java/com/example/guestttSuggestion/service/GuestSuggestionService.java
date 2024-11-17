package com.example.guestttSuggestion.service;

import com.example.guestttSuggestion.entity.GuestSuggestionEntity;
import com.example.guestttSuggestion.entity.SuggestionStatus;
import com.example.guestttSuggestion.repository.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionService {


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
    public List<GuestSuggestionEntity> findAllCreatedSuggestions() {
        return guestSuggestionRepository.findAll()
                .stream()
                .filter(suggestion -> SuggestionStatus.CREATE.equals(suggestion.getStatus()))
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return guestSuggestionRepository
                .findAll()
                .stream().filter(suggestion -> SuggestionStatus.CREATE.equals(suggestion.getStatus()))
                .collect(Collectors.toList());
    }




}
