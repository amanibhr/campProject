package com.example.tunisiecamp.services;

import com.example.tunisiecamp.entites.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> retrieveAllFeedback();

    Feedback addFeedback(Feedback f);

    Feedback updateFeedback(Feedback feedback, Long idFeedback);

    Feedback retrieveFeedback (Long idFeedback);

    void deleteFeedback(Long idFeedback);
}

