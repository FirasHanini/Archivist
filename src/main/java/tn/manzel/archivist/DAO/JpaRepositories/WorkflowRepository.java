package tn.manzel.archivist.DAO.JpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.manzel.archivist.DAO.Entities.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
}
