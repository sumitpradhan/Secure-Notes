package com.secure.notes.repository;

import com.secure.notes.models.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByOwnerUsername(String ownerUsername);
}
