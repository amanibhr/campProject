package com.example.tunisiecamp.services;

import com.example.tunisiecamp.entites.Feedback;
import com.example.tunisiecamp.entites.Forum;
import com.example.tunisiecamp.repositories.FeedbackRepository;
import com.example.tunisiecamp.repositories.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class FeedbackServiceImpl implements FeedbackService{
    FeedbackRepository feedbackRepository;
    ForumRepository forumRepository;
    @Override
    public List<Feedback> retrieveAllFeedback(){

        return (List<Feedback>) feedbackRepository.findAll();
    }

    @Override
    public  Feedback addFeedback(Feedback e) {
        e.setDate(new Date());
        e.setLikes(0L);
        e.setDislikes(0L);
        return feedbackRepository.save(e);
    }

    @Override
    public Feedback updateFeedback(Feedback feedback, Long idFeedback) {
        Feedback feedback1 = feedbackRepository.findById(idFeedback).get();
        feedback1.setCommentaire(feedback.getCommentaire());
        feedback1.setSentiment(feedback.getSentiment());
        return feedbackRepository.save(feedback1);
    }

    @Override
    public Feedback retrieveFeedback(Long idFeedback) {
        return feedbackRepository.findById(idFeedback).get();
    }

    @Override
    public void deleteFeedback(Long idFeedback) {

        feedbackRepository.deleteById(idFeedback);

    }
    @Override
    public Long addLikesFeedback(Long idFeedback) {
        Feedback feedback=feedbackRepository.findById(idFeedback).get();
        Long likes=feedback.getLikes()+1;
        feedback.setLikes(likes);
        feedbackRepository.save(feedback);
        return likes;
    }

    @Override
    public Long addDisLikesFeedback(Long idFeedback) {
        Feedback feedback=feedbackRepository.findById(idFeedback).get();
        Long dislikes=feedback.getDislikes()+1;
        feedback.setDislikes(dislikes);
        feedbackRepository.save(feedback);
        return dislikes;
    }


}
