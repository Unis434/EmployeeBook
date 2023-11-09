package SpringBoot.EmployeeBook.Dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDTO {
    @NotEmpty(message = "Employee ID is required")
    private String employeeId;

    @NotEmpty(message = "Employee Name is required")
    private String employeeName;

    @NotEmpty(message = "Department is required")
    private String department;

    private Long designationId;

    @NotEmpty(message = "Date of Joining is required")
    private LocalDate dateOfJoining;

    @NotEmpty(message = "Date of Birth is required")
    private LocalDate dateOfBirth;

    private boolean married;

    // If married is true, dateOfMarriage is required
    private LocalDate dateOfMarriage;



}





