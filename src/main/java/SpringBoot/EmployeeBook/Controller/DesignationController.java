package SpringBoot.EmployeeBook.Controller;

import SpringBoot.EmployeeBook.Dto.EmployeeDTO;
import SpringBoot.EmployeeBook.Entity.Designation;
import SpringBoot.EmployeeBook.Entity.Employee;
import SpringBoot.EmployeeBook.Services.DesignationService;
import SpringBoot.EmployeeBook.Services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseEntity<Designation> addDesignation(@RequestBody Designation designation) {
        Designation addedDesignation = designationService.addDesignation(designation);
        return new ResponseEntity<>(addedDesignation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Designation> getDesignation(@PathVariable Long id) {
        Designation designation = designationService.getDesignation(id);
        if (designation != null) {
            return new ResponseEntity<>(designation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Designation>> getAllDesignations() {
        List<Designation> designations = designationService.getAllDesignations();
        return new ResponseEntity<>(designations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Designation> updateDesignation(@PathVariable Long id, @RequestBody Designation designation) {
        Designation updatedDesignation = designationService.updateDesignation(id, designation);
        if (updatedDesignation != null) {
            return new ResponseEntity<>(updatedDesignation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Long id) {
        if (designationService.deleteDesignation(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


