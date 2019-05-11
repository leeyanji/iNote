package com.leeyanji.iNote.service;

import com.leeyanji.iNote.model.Note;
import com.leeyanji.iNote.model.NoteType;
import com.leeyanji.iNote.repository.NoteRepository;
import com.leeyanji.iNote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.getOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> findAllByNoteType(NoteType noteType) {
        return noteRepository.findAllByNoteType(noteType);
    }

    @Override
    public List<Note> findAllByTitleContaining(String search) {
        return noteRepository.findAllByTitleContaining(search);
    }

    @Override
    public int countAllByNoteType(NoteType noteType) {
        return noteRepository.countAllByNoteType(noteType);
    }
}
