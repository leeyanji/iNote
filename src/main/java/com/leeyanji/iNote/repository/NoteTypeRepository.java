package com.leeyanji.iNote.repository;

import com.leeyanji.iNote.model.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTypeRepository extends JpaRepository<NoteType, Long> {

}
