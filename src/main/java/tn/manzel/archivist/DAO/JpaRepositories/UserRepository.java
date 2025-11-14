package tn.manzel.archivist.DAO.JpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.manzel.archivist.DAO.Entities.User;



public interface UserRepository  extends JpaRepository<User, Long> {
}
