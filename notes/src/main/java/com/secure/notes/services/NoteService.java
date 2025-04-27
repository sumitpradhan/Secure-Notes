package com.secure.notes.services;

import com.secure.notes.models.Notes;

import java.util.List;

public interface NoteService {
    Notes createNote(String username, String content);
    Notes updateNote(Long noteId,String username, String content);
    void  deleteNote(Long noteId, String username);
    List<Notes> getNotesForUser(String username);
}
