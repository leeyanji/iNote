package com.leeyanji.iNote.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "text", length = 10000)
    @Type(type = "text")
    private String content;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date created;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "noteType_id")
    private NoteType noteType;
}
