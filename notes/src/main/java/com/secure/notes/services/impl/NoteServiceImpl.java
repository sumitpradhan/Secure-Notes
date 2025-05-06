package com.secure.notes.services.impl;

import com.secure.notes.models.Notes;
import com.secure.notes.repository.NoteRepository;
import com.secure.notes.services.AuditLogService;
import com.secure.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    AuditLogService auditLogService;
    @Override
    public Notes createNote(String username, String content) {
        Notes note = new Notes();
        note.setContent(content);
        note.setOwnerUsername(username);
        Notes saveNote = noteRepository.save(note);
        auditLogService.logNoteCreation(username,note);
        return saveNote;
    }

    @Override
    public Notes updateNote(Long noteId, String username, String content) {
        Notes note = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note not found!!!"));
        note.setContent(content);
        Notes updatedNode = noteRepository.save(note);
        auditLogService.logNoteUpdate(username,note);
        return updatedNode;
    }

    @Override
    public void deleteNote(Long noteId, String username) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Notes> getNotesForUser(String username) {
        return noteRepository.findByOwnerUsername(username);
    }
}
