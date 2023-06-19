package com.example.tunisiecamp.controllers;

import com.example.tunisiecamp.entites.Forum;
import com.example.tunisiecamp.services.ForumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/forum")
public class ForumRestController {
    ForumService forumService;
    // http://localhost:8089/kaddem/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-forums")
    public List<Forum> getForums() {
        List<Forum> listForums = forumService.retrieveAllForums();
        return listForums;
    }
    // http://localhost:8089/kaddem/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-forum/{forumId}")
    public Forum retrieveForum(@PathVariable("forumId") Long forumId) {
        return forumService.retrieveForum(forumId);
    }
    // http://localhost:8089/kaddem/etudiant/add-etudiant
    @PostMapping("/add-forum")
    public Forum addforum(@RequestBody Forum e) {
        Forum forum = forumService.addForum(e);
        return forum;
    }
    // http://localhost:8089/kaddem/etudiant/update-etudiant
    @PutMapping("/update-forum/{forumId}")
    public Forum updateForum(@RequestBody Forum e, @PathVariable("forumId") Long forumId) {
         return forumService.updateForum(e,forumId);

    }


    // http://localhost:8089/kaddem/etudiant/delete-etudiant
    @DeleteMapping("/delete-forum/{forumId}")
    public void deleteForum(@PathVariable("forumId") Long forumId) {
        forumService.deleteForum(forumId);
    }
    // http://localhost:8089/TunisieCamp/assign-Feedback-To-Forum/{forumId}/{idFeedback}
    @PostMapping("/assign-Feedback-To-Forum/{forumId}/{idFeedback}")
    public void assignFeedbackToForum(@PathVariable("forumId") Long forumId,@PathVariable("idFeedback") Long idFeedback) {
         forumService.assignFeedbackToForum( forumId,  idFeedback);
    }


    }


