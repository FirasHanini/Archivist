package tn.manzel.archivist.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.manzel.archivist.DAO.Entities.Workflow;
import tn.manzel.archivist.Endpoints.ApiConstants;
import tn.manzel.archivist.Services.WorkflowService;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.api+ApiConstants.WorkflowApis.workflows)
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkflowService workflowService;

    @PostMapping
    public ResponseEntity<Workflow> create(@RequestBody Workflow workflow) {
        Workflow saved = workflowService.save(workflow);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workflow> getById(@PathVariable Long id) {
        Workflow workflow = workflowService.findById(id);
        if (workflow == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workflow);
    }

    @GetMapping
    public ResponseEntity<List<Workflow>> getAll() {
        return ResponseEntity.ok(workflowService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!workflowService.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
