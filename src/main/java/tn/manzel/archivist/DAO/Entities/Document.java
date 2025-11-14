package tn.manzel.archivist.DAO.Entities;

// src/main/java/com/example/workflow/entities/Document.java

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String originalFileName;
    private String storagePath;

    @Enumerated(EnumType.STRING)
    private DocumentType type; // PDF, WORD, IMAGE

    @Enumerated(EnumType.STRING)
    private DocumentStatus status; // NEW, IN_REVIEW, APPROVED, REJECTED

    @ManyToOne
    private User uploadedBy;

    @CreationTimestamp
    private LocalDateTime uploadedAt;

    @ManyToOne
    private Template templateUsed; // nullable
}