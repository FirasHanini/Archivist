package tn.manzel.archivist.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.manzel.archivist.DAO.Entities.Workflow;
import tn.manzel.archivist.DAO.JpaRepositories.WorkflowRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkflowService implements IService<Workflow,Long> {
    final WorkflowRepository repository;

    @Override
    public Workflow save(Workflow entity) {
        return repository.save(entity);
    }

    @Override
    public Workflow findById(Long id) {
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
    public List<Workflow> findAll() {
        return repository.findAll();
    }
}
