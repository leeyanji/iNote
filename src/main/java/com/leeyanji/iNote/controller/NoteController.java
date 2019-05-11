package com.leeyanji.iNote.controller;import com.leeyanji.iNote.model.Note;import com.leeyanji.iNote.model.NoteType;import com.leeyanji.iNote.service.NoteService;import com.leeyanji.iNote.service.NoteTypeService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;import org.springframework.data.domain.Pageable;import org.springframework.http.HttpStatus;import org.springframework.http.MediaType;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;import java.util.List;import java.util.Optional;@Controller@RequestMapping("/note")public class NoteController {    @Autowired    private NoteService noteService;    @Autowired    private NoteTypeService noteTypeService;    @ModelAttribute("allTypeNote")    public List<NoteType> allNoteType() {        return noteTypeService.findAll();    }    @GetMapping    public String index(Model model, Optional<Long> noteType_id, Optional<String> search) {        if (search.isPresent()) {            List<Note> notes = noteService.findAllByTitleContaining(search.get());            model.addAttribute("notes", notes);        } else if (noteType_id.isPresent()) {            NoteType noteType = noteTypeService.findById(noteType_id.get());            List<Note> notes = noteService.findAllByNoteType(noteType);            model.addAttribute("notes", notes);        } else {            List<Note> notes = noteService.findAll();            model.addAttribute("notes", notes);        }        return "note";    }    @GetMapping("/formAddNote")    public String addForm() {        return "formAddNote";    }    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)    public ResponseEntity<Void> add(@ModelAttribute Note note) {        if (note.getNoteType() == null) {            return new ResponseEntity<>(HttpStatus.NOT_FOUND);        }        noteService.save(note);        return new ResponseEntity<>(HttpStatus.CREATED);    }    @DeleteMapping("/{id}")    public ResponseEntity<HttpStatus> remove(@PathVariable long id) {        noteService.delete(id);        return new ResponseEntity<>(HttpStatus.NO_CONTENT);    }    @GetMapping("/{id}")    public String formEdit(@PathVariable long id, Model model) {        Note note = noteService.findById(id);        model.addAttribute("note", note);        return "formEditNote";    }    @PutMapping("/{id}")    public ResponseEntity<Void> update(@PathVariable long id, @ModelAttribute Note note) {        Note currentNote = noteService.findById(id);        if (currentNote != null) {            noteService.save(note);            return new ResponseEntity<>(HttpStatus.OK);        }        return new ResponseEntity<>(HttpStatus.NOT_FOUND);    }}