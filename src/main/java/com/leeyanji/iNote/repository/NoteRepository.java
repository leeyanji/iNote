package com.leeyanji.iNote.repository;

import com.leeyanji.iNote.model.Note;
import com.leeyanji.iNote.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByNoteType(NoteType noteType);
    List<Note> findAllByTitleContaining(String search);
    int countAllByNoteType(NoteType noteType);
}
