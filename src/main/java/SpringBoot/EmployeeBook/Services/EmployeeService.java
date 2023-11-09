package SpringBoot.EmployeeBook.Services;

import SpringBoot.EmployeeBook.Dto.EmployeeDTO;
import SpringBoot.EmployeeBook.Entity.Designation;
import SpringBoot.EmployeeBook.Entity.Employee;
import SpringBoot.EmployeeBook.Exception.APIException;
import SpringBoot.EmployeeBook.Repository.DesignationRepository;
import SpringBoot.EmployeeBook.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DesignationRepository designationRepository;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        if (!employeeDTO.isMarried()) {
            throw new APIException("Employee must be married to add date of marriage."); // 400 for Bad Request
        }

        // Retrieve the Designation entity based on the provided designationId
        Designation designation = designationRepository.findById(employeeDTO.getDesignationId())
                .orElseThrow();

        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setDesignation(designation);
        employee.setDateOfJoining(employeeDTO.getDateOfJoining());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setMarried(employeeDTO.isMarried());
        employee.setDateOfMarriage(employeeDTO.getDateOfMarriage());

        return employeeRepository.save(employee);
    }

    public Employee getEmployeeByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findByEmployeeId(employeeId)
                .orElseThrow();

        if (!existingEmployee.isMarried() && employeeDTO.isMarried()) {
            throw new APIException("Cannot update date of marriage for an unmarried employee."); // 400 for Bad Request
        }


        // Retrieve the Designation entity based on the provided designationId
        Designation designation = designationRepository.findById(employeeDTO.getDesignationId())
                .orElseThrow();

        existingEmployee.setEmployeeName(employeeDTO.getEmployeeName());
        existingEmployee.setDepartment(employeeDTO.getDepartment());
        existingEmployee.setDesignation(designation);
        existingEmployee.setDateOfJoining(employeeDTO.getDateOfJoining());
        existingEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        existingEmployee.setMarried(employeeDTO.isMarried());
        existingEmployee.setDateOfMarriage(employeeDTO.getDateOfMarriage());

        return employeeRepository.save(existingEmployee);
    }

    public boolean deleteEmployee(String employeeId) {
        Employee existingEmployee = employeeRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new APIException("Employee not found.")); // 404 for Not Found


        employeeRepository.delete(existingEmployee);
        return true;
    }
}

