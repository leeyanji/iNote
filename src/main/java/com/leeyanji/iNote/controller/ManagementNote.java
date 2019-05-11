package com.leeyanji.iNote.controller;

import com.leeyanji.iNote.model.Note;
import com.leeyanji.iNote.model.NoteType;
import com.leeyanji.iNote.service.NoteService;
import com.leeyanji.iNote.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ManagementNote {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteTypeService noteTypeService;
    @ModelAttribute("allTypeNote")
    public List<NoteType> allNoteType(){
        return noteTypeService.findAll();
    }

    @GetMapping("/")
    public String index(Model model){
        List<Note> notes = noteService.findAll();
        List<NoteType> noteTypes = noteTypeService.findAll();
        model.addAttribute("noteTypes", noteTypes
        );
        model.addAttribute("notes", notes);
        return "index";
    }
}
