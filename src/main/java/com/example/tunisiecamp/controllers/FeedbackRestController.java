package com.example.tunisiecamp.controllers;


import com.example.tunisiecamp.entites.Feedback;
import com.example.tunisiecamp.entites.Forum;
import com.example.tunisiecamp.services.FeedbackService;
import com.example.tunisiecamp.services.ForumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Feedback")
public class FeedbackRestController {
    FeedbackService feedbackService;
    ForumService forumService;
    // http://localhost:8089/kaddem/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-feedbacks")
    public List<Feedback> getFeedbacks() {
        List<Feedback> listFeedbacks = feedbackService.retrieveAllFeedback();
        return listFeedbacks;
    }
    // http://localhost:8089/kaddem/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-Feedback/{feedbackId}")
    public Feedback retrieveFeedback(@PathVariable("feedbackId") Long feedbackId) {
        return feedbackService.retrieveFeedback(feedbackId);
    }
    // http://localhost:8089/kaddem/etudiant/add-etudiant
    @PostMapping("/add-Feedback/{ForumId}")
    public Feedback addFeedbackAPI(@RequestBody Feedback e,@PathVariable("ForumId") Long ForumId) {
        Feedback feedback = feedbackService.addFeedback(e);
       forumService.assignFeedbackToForum(ForumId, feedback.getId());
        return feedback;
    }
    // http://localhost:8089/kaddem/etudiant/update-etudiant
    @PutMapping("/update-Feedback/{feedbackId}")
    public Feedback updateEtudiant(@RequestBody Feedback e, @PathVariable Long feedbackId) {
         return feedbackService.updateFeedback(e,feedbackId);

    }

    // http://localhost:8089/kaddem/etudiant/delete-etudiant
    @DeleteMapping("/delete-Feedback/{feedbackId}")
    public void deleteFeedback(@PathVariable("feedbackId") Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }
    @PostMapping("/add-like-Feedback/{feedbackId}")
    public Feedback addLikeFeedbackAPI(@PathVariable("feedbackId") Long feedbackId) {
        Long likes = feedbackService.addLikesFeedback(feedbackId);
        return feedbackService.retrieveFeedback(feedbackId);
    }
    @PostMapping("/add-dislike-Feedback/{feedbackId}")
    public Feedback addDisLikeFeedbackAPI(@PathVariable("feedbackId") Long feedbackId) {
        Long dislikes = feedbackService.addDisLikesFeedback(feedbackId);
        return feedbackService.retrieveFeedback(feedbackId);
    }
    }


