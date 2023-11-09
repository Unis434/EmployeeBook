package SpringBoot.EmployeeBook.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "designation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees;
}

