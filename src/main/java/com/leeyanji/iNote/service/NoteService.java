package com.leeyanji.iNote.service;

import com.leeyanji.iNote.model.Note;
import com.leeyanji.iNote.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    List<Note> findAll();
    Note findById(Long id);
    void save(Note note);
    void delete(Long id);
    List<Note> findAllByNoteType(NoteType noteType);
    List<Note> findAllByTitleContaining(String search);
    int countAllByNoteType(NoteType noteType);
}
