package projectSpringBoot.projectTeam3SpringBoot.entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private int age;
    private int hoursWorked;
    private boolean hasChildren;
    private LocalDate dateAssumption;
}
