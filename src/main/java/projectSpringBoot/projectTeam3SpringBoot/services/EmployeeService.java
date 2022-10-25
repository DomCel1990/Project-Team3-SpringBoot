package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.entities.Permission;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;

import java.time.LocalDate;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    private Employee employee;

    public boolean hasPermission(Permission permission) {
        if (employee.getRole().hasPermission(permission)) {
            return true;
        }
        return false;
    }

    public double calculateTfr() {
        double tfr = 0;
        double rivalutation = 0;
        double salaryCalcolate = 0;
        for (int i = 0; i < LocalDate.now().getYear() - employee.getDateAssumption().getYear(); i++) {
            tfr = salaryCalcolate + calculatorSalary();

            rivalutation += calculatorSalary() * (0.0225 * (0.015 + 0.0075 * (0.01 * 0.75)));
            salaryCalcolate += calculatorSalary() + rivalutation;
        }
        return tfr;
    }

    public double calculateBasicSalary() {
        double salaryBasic = 1;
        switch (employee.getRole()) {
            case OWNER, MANAGER, CASHIER, SALESCLERK, DEPARTMENTHEAD, WAREHOUSEWORKER -> {
                salaryBasic = employee.getRole().getSalaryHour() * employee.getRole().getHourWork();
            }
        }
        return salaryBasic;
    }

    public double calculateExtraordinarySalary() {
        double salaryExtraordinary = employee.getHoursWorked() - employee.getRole().getHourWork();
        if (salaryExtraordinary > 0)
            salaryExtraordinary = salaryExtraordinary * employee.getRole().getSalaryExtraordinaryHour();
        return salaryExtraordinary;
    }

    public double calculateSenioritySalary() {
        double senioritySalary = 0;
        if (LocalDate.now().getYear() - employee.getDateAssumption().getYear() <= 5)
            senioritySalary += 0;
        else if (LocalDate.now().getYear() - employee.getDateAssumption().getYear() > 5 && LocalDate.now().getYear() - employee.getDateAssumption().getYear() <= 10)
            senioritySalary += 100;
        else if (LocalDate.now().getYear() - employee.getDateAssumption().getYear() > 10 && LocalDate.now().getYear() - employee.getDateAssumption().getYear() <= 15)
            senioritySalary += 200;
        else if (LocalDate.now().getYear() - employee.getDateAssumption().getYear() > 15)
            senioritySalary += 300;
        return senioritySalary;
    }

    public double hasCheckFamily() {
        double familyAllowance;
        if (employee.isHasChildren() == true)
            return familyAllowance = +200;
        else
            return familyAllowance = +0;
    }

    public double calculatorSalary() {
        double totalsalary = hasCheckFamily() + calculateSenioritySalary() + calculateBasicSalary() + calculateExtraordinarySalary();
        return totalsalary;
    }
}
