package tn.manzel.archivist.DAO.JpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.manzel.archivist.DAO.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
