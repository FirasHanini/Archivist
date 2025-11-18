package tn.manzel.archivist.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.manzel.archivist.DAO.Entities.Document;
import tn.manzel.archivist.DAO.JpaRepositories.DocumentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService implements IService <Document, Long> {

    final DocumentRepository repository;


    public Document save(Document entity) {
        return repository.save(entity);
    }


    public Document findById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public boolean deleteById(Long id) {
        if( !repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }


    public List<Document> findAll() {
        return repository.findAll();
    }
}
