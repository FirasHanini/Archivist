package tn.manzel.archivist.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.manzel.archivist.DAO.Entities.Template;
import tn.manzel.archivist.Endpoints.ApiConstants;
import tn.manzel.archivist.Services.TemplateService;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.api+ApiConstants.TemplateApis.templates)
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping
    public ResponseEntity<Template> create(@RequestBody Template template) {
        Template saved = templateService.save(template);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> getById(@PathVariable Long id) {
        Template template = templateService.findById(id);
        if (template == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(template);
    }

    @GetMapping
    public ResponseEntity<List<Template>> getAll() {
        return ResponseEntity.ok(templateService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = templateService.deleteById(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
