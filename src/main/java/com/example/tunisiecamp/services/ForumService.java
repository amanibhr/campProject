package com.example.tunisiecamp.services;

import com.example.tunisiecamp.entites.Feedback;
import com.example.tunisiecamp.entites.Forum;

import java.util.List;

public interface ForumService {
    List<Forum> retrieveAllForums();

    Forum addForum(Forum f);

    Forum updateForum(Forum forum, Long idForum);

    Forum retrieveForum (Long idForum);

    void deleteForum(Long idForum);

    void assignFeedbackToForum(Long idForm,Long idFeedback);

}

