package com.secure.notes.services;

import com.secure.notes.models.AuditLog;
import com.secure.notes.models.Notes;

import java.util.List;

public interface AuditLogService {
    //Audits creation of note
    void logNoteCreation(String username, Notes note);
  //Audits updation of note
    void logNoteUpdate(String username, Notes note);
   // Audits deletion of note
    void logNoteDeletion(String username, Long noteId);

    List<AuditLog> getAllAuditLogs();

    List<AuditLog> getAuditLogsForNoteId(Long id);
}
