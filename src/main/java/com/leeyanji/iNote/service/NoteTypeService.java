package com.leeyanji.iNote.service;

import com.leeyanji.iNote.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteTypeService {
    List<NoteType> findAll();
    NoteType findById(Long id);
    NoteType save(NoteType noteType);
    void delete(Long id);
}
