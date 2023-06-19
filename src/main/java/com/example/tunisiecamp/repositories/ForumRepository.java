package com.example.tunisiecamp.repositories;

import com.example.tunisiecamp.entites.Forum;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Forum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {}
