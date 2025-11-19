package tn.manzel.archivist.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.manzel.archivist.DAO.Entities.Role;
import tn.manzel.archivist.Endpoints.ApiConstants;
import tn.manzel.archivist.Services.RoleService;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.api+ApiConstants.RoleApis.role)
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role) {
        Role saved = roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable Long id) {
        Role role = roleService.findById(id);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        List<Role> list = roleService.findAll();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean deleted = roleService.deleteById(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
