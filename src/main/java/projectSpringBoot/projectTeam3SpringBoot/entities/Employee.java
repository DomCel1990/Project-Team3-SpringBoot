package projectSpringBoot.projectTeam3SpringBoot.entities;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private int age;
    private int hoursWorked;
    private boolean hasChildren;
    private LocalDate dateAssumption;
    private Role role;
    
    public Employee(){}

    public Employee(Long id, String name, String surname, String email, int age, int hoursWorked, boolean hasChildren, LocalDate dateAssumption, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.hoursWorked = hoursWorked;
        this.hasChildren = hasChildren;
        this.dateAssumption = dateAssumption;
        this.setRole(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public LocalDate getDateAssumption() {
        return dateAssumption;
    }

    public void setDateAssumption(LocalDate dateAssumption) {
        this.dateAssumption = dateAssumption;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
