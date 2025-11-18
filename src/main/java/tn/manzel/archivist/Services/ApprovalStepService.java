package tn.manzel.archivist.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.manzel.archivist.DAO.Entities.ApprovalStep;
import tn.manzel.archivist.DAO.JpaRepositories.ApprovalStepRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalStepService implements IService<ApprovalStep, Long> {
    final ApprovalStepRepository repository;
    @Override
    public ApprovalStep save(ApprovalStep entity) {
        return repository.save(entity);
    }

    @Override
    public ApprovalStep findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if( !repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<ApprovalStep> findAll() {
        return repository.findAll();
    }
}
