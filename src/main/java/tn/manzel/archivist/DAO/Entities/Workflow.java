package tn.manzel.archivist.DAO.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Document document;

    private int currentStepIndex = 0; // Pour suivre l'étape actuelle

    @Enumerated(EnumType.STRING)
    private WorkflowStatus status; // PENDING, IN_PROGRESS, COMPLETED, REJECTED

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private User createdBy;

    @OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApprovalStep> steps;
}