package SpringBoot.EmployeeBook.Entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

