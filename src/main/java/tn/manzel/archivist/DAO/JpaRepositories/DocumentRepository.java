package tn.manzel.archivist.DAO.JpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.manzel.archivist.DAO.Entities.Document;

public interface DocumentRepository  extends JpaRepository<Document, Long> {
}
