package tn.manzel.archivist.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.manzel.archivist.DAO.Entities.Role;
import tn.manzel.archivist.DAO.JpaRepositories.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements IService<Role, Long> {
    final RoleRepository repository;
    @Override
    public Role save(Role entity) {
        return repository.save(entity);
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
        return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }
}
