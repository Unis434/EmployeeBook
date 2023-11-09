package SpringBoot.EmployeeBook.Dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TaskDTO {
    @NotEmpty(message = "Task Name is required")
    private String taskName;

    private Long employeeId;


}

