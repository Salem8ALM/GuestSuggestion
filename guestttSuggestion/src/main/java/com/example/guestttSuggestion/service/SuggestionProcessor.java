package com.example.guestttSuggestion.service;

@FunctionalInterface
public interface SuggestionProcessor {
    void suggestion (String suggestion, double rate);
}
