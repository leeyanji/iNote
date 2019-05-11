package com.leeyanji.iNote.service;

import com.leeyanji.iNote.model.NoteType;
import com.leeyanji.iNote.repository.NoteTypeRepository;
import com.leeyanji.iNote.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;
    @Override
    public List<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType findById(Long id) {
        return noteTypeRepository.getOne(id);
    }

    @Override
    public NoteType save(NoteType noteType) {
        return noteTypeRepository.save(noteType);
    }

    @Override
    public void delete(Long id) {
        noteTypeRepository.deleteById(id);
    }
}
