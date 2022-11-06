package projectSpringBoot.projectTeam3SpringBoot.dto;

import lombok.Data;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private double salary;
}
