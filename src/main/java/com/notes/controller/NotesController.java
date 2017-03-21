package com.notes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notes.model.Note;
import com.notes.repository.NotesRepository;

@RestController
@RequestMapping("/note")
public class NotesController {
  
  private NotesRepository notesRepository;
  
  @Autowired
  public void setNotesRepository(NotesRepository notesRepository) {
    this.notesRepository = notesRepository;
  }

  @GetMapping
  public ResponseEntity<List<Note>> getAllNotes() {
    List<Note> allNotes = notesRepository.findAll();
    return new ResponseEntity<List<Note>>(allNotes, HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity<Note> addNote(@RequestBody @Valid Note note) {
    notesRepository.save(note);
    return new ResponseEntity<Note>(note, HttpStatus.OK);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Note> removeNote(@PathVariable("id") Long noteId) {
    notesRepository.delete(noteId);
    return new ResponseEntity<Note>(HttpStatus.OK);
  }
  
  @PutMapping
  public ResponseEntity<List<Note>> updateNotes(@RequestBody List<Note> notes) {
    notesRepository.deleteAll();
    notesRepository.save(notes);
    return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
  }

}
