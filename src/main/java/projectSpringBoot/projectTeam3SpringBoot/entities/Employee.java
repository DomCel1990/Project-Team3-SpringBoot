package projectSpringBoot.projectTeam3SpringBoot.entities;
import projectSpringBoot.projectTeam3SpringBoot.enu.Permission;
import projectSpringBoot.projectTeam3SpringBoot.enu.Role;

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
    private String email;
    private int age;
    private int hoursWorked;
    private boolean hasChildren;
    private LocalDate dateAssumption;
    private Role role;

    public Employee(){}

    public Employee(String name, String surname, String email, int age, int hoursWorked, boolean hasChildren, LocalDate dateAssumption, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.hoursWorked = hoursWorked;
        this.hasChildren = hasChildren;
        this.dateAssumption = dateAssumption;
        this.role=role;
    }

    public boolean hasPermission(Permission permission) {
        if (role.hasPermission(permission)) {
            return true;
        }
        return false;
    }

    public double calculateTfr() {
        double tfr = 0;
        double rivalutation = 0;
        double salaryCalcolate = 0;
        for (int i = 0; i < LocalDate.now().getYear() - dateAssumption.getYear(); i++) {
            tfr = salaryCalcolate + calculatorSalary();

            rivalutation += calculatorSalary() * (0.0225 * (0.015 + 0.0075 * (0.01 * 0.75)));
            salaryCalcolate += calculatorSalary() + rivalutation;
        }
        return tfr;
    }

    public double calculateBasicSalary() {
        double salaryBasic = 1;
        switch (getRole()) {
            case OWNER, MANAGER, CASHIER, SALESCLERK, DEPARTMENTHEAD, WAREHOUSEWORKER -> {
                salaryBasic = getRole().getSalaryHour() * getRole().getHourWork();
            }
        }
        return salaryBasic;
    }

    public double calculateExtraordinarySalary() {
        double salaryExtraordinary = hoursWorked - getRole().getHourWork();
        if (salaryExtraordinary > 0)
            salaryExtraordinary = salaryExtraordinary * getRole().getSalaryExtraordinaryHour();
        return salaryExtraordinary;
    }

    public double calculateSenioritySalary() {
        double senioritySalary = 0;
        if (LocalDate.now().getYear() - dateAssumption.getYear() <= 5)
            senioritySalary += 0;
        else if (LocalDate.now().getYear() - dateAssumption.getYear() > 5 && LocalDate.now().getYear() - dateAssumption.getYear() <= 10)
            senioritySalary += 100;
        else if (LocalDate.now().getYear() - dateAssumption.getYear() > 10 && LocalDate.now().getYear() - dateAssumption.getYear() <= 15)
            senioritySalary += 200;
        else if (LocalDate.now().getYear() - dateAssumption.getYear() > 15)
            senioritySalary += 300;
        return senioritySalary;
    }
    public double hasCheckFamily() {
        double familyAllowance;
        if (hasChildren == true)
            return familyAllowance = +200;
        else
            return familyAllowance = +0;
    }

    public double calculatorSalary() {
        double totalsalary = hasCheckFamily() + calculateSenioritySalary() + calculateBasicSalary() + calculateExtraordinarySalary();
        return totalsalary;
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
