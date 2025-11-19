package tn.manzel.archivist.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.manzel.archivist.DAO.Entities.ApprovalStep;
import tn.manzel.archivist.Endpoints.ApiConstants;
import tn.manzel.archivist.Services.ApprovalStepService;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.api+ApiConstants.ApprovalStepApis.approvalStep)
@RequiredArgsConstructor
public class ApprovalStepController {

    private final ApprovalStepService approvalStepService;

    @PostMapping
    public ResponseEntity<ApprovalStep> create(@RequestBody ApprovalStep approvalStep) {
        ApprovalStep saved = approvalStepService.save(approvalStep);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprovalStep> getById(@PathVariable Long id) {
        ApprovalStep step = approvalStepService.findById(id);
        if (step == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(step);
    }

    @GetMapping
    public ResponseEntity<List<ApprovalStep>> getAll() {
        List<ApprovalStep> list = approvalStepService.findAll();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (!approvalStepService.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
