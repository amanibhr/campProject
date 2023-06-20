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
public class ForumServiceImpl implements ForumService{
    ForumRepository forumRepository;
    FeedbackRepository feedbackRepository;

    @Override
    public List<Forum> retrieveAllForums(){
        return (List<Forum>) forumRepository.findAll();
    }

    @Override
    public  Forum addForum(Forum e) {
        e.setDate(new Date());
        Forum forum= forumRepository.save(e);
        return forum;

    }

    @Override
    public Forum updateForum(Forum forum, Long idForum) {
        Forum forum1 = forumRepository.findById(idForum).get();

        //forum1.setNameForum(forum.getNameForum());
        return forumRepository.save(forum1);
    }

    @Override
    public Forum retrieveForum(Long idForum) {
        return forumRepository.findById(idForum).get();
    }

    @Override
    public void deleteForum(Long idForum) {

        forumRepository.deleteById(idForum);

    }

    @Override
    public void assignFeedbackToForum(Long idForm, Long idFeedback) {
        Forum forum=forumRepository.findById(idForm).get();
        Feedback feedback=feedbackRepository.findById(idFeedback).get();

        forum.getFeedbacks().add(feedback);
        //feedback.setForum(forum);
        forumRepository.save(forum);

    }

    @Override
    public Long addLikesForum(Long idForm) {
        Forum forum=forumRepository.findById(idForm).get();
        Long likes=forum.getLikes()+1;
        return likes;
    }

    @Override
    public Long addDisLikesForum(Long idForm) {
        Forum forum=forumRepository.findById(idForm).get();
        Long likes=forum.getDislikes()+1;
        return likes;
    }


}
