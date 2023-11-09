package SpringBoot.EmployeeBook.Entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeId;

    private String employeeName;
    private String department;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    private LocalDate dateOfJoining;
    private LocalDate dateOfBirth;
    private boolean married;
    private LocalDate dateOfMarriage;
}

