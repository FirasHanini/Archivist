package tn.manzel.archivist.DAO.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Workflow workflow; // Relation inverse

    private int stepOrder; // 1, 2, 3…

    @ManyToOne
    private User assignedTo;

    @Enumerated(EnumType.STRING)
    private StepStatus status; // PENDING, APPROVED, REJECTED

    private String comment;

    private LocalDateTime approvedAt; // Date d'approbation ou de rejet
}