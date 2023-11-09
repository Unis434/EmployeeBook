package SpringBoot.EmployeeBook.Dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DesignationDTO {
    @NotEmpty(message = "Designation name is required")
    private String name;


}
