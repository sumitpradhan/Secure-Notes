package com.secure.notes.controller;

import com.secure.notes.models.Notes;
import com.secure.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Notes createNote(@RequestBody String content ,
                            @AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();
        System.out.println(content);
        return noteService.createNote(username,content);
    }

    @GetMapping
    public List<Notes> getUserNotes( @AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();
        return noteService.getNotesForUser(username);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable long noteId,
                           @AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();
         noteService.deleteNote(noteId,username);
    }

    @PutMapping("/{noteId}")
    public Notes updateNote(@PathVariable long noteId,
                           @RequestBody String content,
                           @AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();
        return noteService.updateNote(noteId,username,content);
    }
}
