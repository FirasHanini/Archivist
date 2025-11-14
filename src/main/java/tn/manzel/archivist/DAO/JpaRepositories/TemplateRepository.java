package tn.manzel.archivist.DAO.JpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.manzel.archivist.DAO.Entities.Template;

public interface TemplateRepository  extends JpaRepository<Template, Long> {
}
