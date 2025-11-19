package tn.manzel.archivist.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.manzel.archivist.DAO.Entities.Document;
import tn.manzel.archivist.Endpoints.ApiConstants;
import tn.manzel.archivist.Services.DocumentService;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.api+ApiConstants.DocumentsApis.documents)
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> create(@RequestBody Document document) {
        Document saved = documentService.save(document);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getById(@PathVariable Long id) {
        Document doc = documentService.findById(id);
        if (doc == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doc);
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAll() {
        List<Document> list = documentService.findAll();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean deleted = documentService.deleteById(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
