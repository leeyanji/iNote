package com.leeyanji.iNote.controller;

import com.leeyanji.iNote.model.Note;
import com.leeyanji.iNote.model.NoteType;
import com.leeyanji.iNote.service.NoteService;
import com.leeyanji.iNote.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/noteType")
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;
    @Autowired
    private NoteService noteService;

    @GetMapping
    public String index(Model model){
        List<NoteType> noteTypes = noteTypeService.findAll();
        model.addAttribute("noteTypes", noteTypes);
        return "noteType";
    }

    @GetMapping("/{id}")
    public String findAllByNoteType(Model model, @PathVariable long id){
        NoteType noteType = noteTypeService.findById(id);
        List<Note> notesByNoteType = noteService.findAllByNoteType(noteType);
        model.addAttribute("notesByNoteType", notesByNoteType);
        return "noteType";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<NoteType> add(@ModelAttribute NoteType noteType){
        NoteType newNoteType = noteTypeService.save(noteType);
        return new ResponseEntity<>(newNoteType, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteType> update(@PathVariable long id, @ModelAttribute NoteType noteType){
        NoteType currentNoteType = noteTypeService.findById(id);
        if (currentNoteType != null){
            noteTypeService.save(noteType);
            return new ResponseEntity<NoteType>(noteType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> remove(@PathVariable long id, Model model){
        NoteType noteType = noteTypeService.findById(id);
        int countNoteInNoteType = noteService.countAllByNoteType(noteType);
        if (countNoteInNoteType == 0){
            noteTypeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
