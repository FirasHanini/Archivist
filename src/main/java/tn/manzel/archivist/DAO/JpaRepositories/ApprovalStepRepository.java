package tn.manzel.archivist.DAO.JpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.manzel.archivist.DAO.Entities.ApprovalStep;

public interface ApprovalStepRepository extends JpaRepository<ApprovalStep, Long> {
}
