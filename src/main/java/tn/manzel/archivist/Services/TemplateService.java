package tn.manzel.archivist.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.manzel.archivist.DAO.Entities.Template;
import tn.manzel.archivist.DAO.JpaRepositories.TemplateRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TemplateService implements IService<Template, Long> {
    final private TemplateRepository repository;

    @Override
    public Template save(Template entity) {
        return repository.save(entity);
    }

    @Override
    public Template findById(Long id) {
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
    public List<Template> findAll() {
        return repository.findAll();
    }
}
