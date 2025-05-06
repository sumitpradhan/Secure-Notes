package com.secure.notes.services.impl;

import com.secure.notes.models.AuditLog;
import com.secure.notes.models.Notes;
import com.secure.notes.repository.AuditLogRepository;
import com.secure.notes.services.AuditLogService;
import com.secure.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    @Autowired
    AuditLogRepository auditLogRepository;
    @Override
    public void logNoteCreation(String username, Notes note) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("Creation");
        auditLog.setNoteId(note.getId());
        auditLog.setNoteContent(note.getContent());
        auditLog.setUsername(username);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(auditLog);
    }

    @Override
    public void logNoteUpdate(String username, Notes note) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("Updation");
        auditLog.setNoteId(note.getId());
        auditLog.setNoteContent(note.getContent());
        auditLog.setUsername(username);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(auditLog);
    }

    @Override
    public void logNoteDeletion(String username, Long noteId) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("Deletion");
        auditLog.setNoteId(noteId);
        auditLog.setUsername(username);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(auditLog);
    }

    @Override
    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    @Override
    public List<AuditLog> getAuditLogsForNoteId(Long id) {
        return auditLogRepository.findByNoteId(id);
    }
}
