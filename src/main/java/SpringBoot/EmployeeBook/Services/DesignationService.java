package SpringBoot.EmployeeBook.Services;

import SpringBoot.EmployeeBook.Entity.Designation;
import SpringBoot.EmployeeBook.Repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {
    @Autowired
    private DesignationRepository designationRepository;

    public Designation addDesignation(Designation designation) {
        // Implement validation and business logic if necessary
        return designationRepository.save(designation);
    }

    public Designation getDesignation(Long id) {
        return designationRepository.findById(id)
                .orElseThrow();
    }

    public List<Designation> getAllDesignations() {
        return designationRepository.findAll();
    }

    public Designation updateDesignation(Long id, Designation designation) {
        Designation existingDesignation = designationRepository.findById(id)
                .orElseThrow();

        // Implement logic for updating designation if needed

        return designationRepository.save(existingDesignation);
    }

    public boolean deleteDesignation(Long id) {
        Designation existingDesignation = designationRepository.findById(id)
                .orElseThrow();

        designationRepository.delete(existingDesignation);
        return true;
    }
}
