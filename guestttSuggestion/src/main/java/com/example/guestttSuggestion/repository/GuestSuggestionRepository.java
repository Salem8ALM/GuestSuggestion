package com.example.guestttSuggestion.repository;

import com.example.guestttSuggestion.entity.GuestSuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity, Long> {



}
