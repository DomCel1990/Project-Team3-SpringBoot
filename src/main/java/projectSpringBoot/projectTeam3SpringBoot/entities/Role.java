package projectSpringBoot.projectTeam3SpringBoot.entities;

import java.util.List;
import java.util.Random;

public enum Role {
    OWNER(0.0,0,0.0, List.of(Permission.ADMIN, Permission.MANAGE_EMPLOYEE, Permission.MANAGE_STORE, Permission.SELL)),
    MANAGER(9.375,160,11, List.of(Permission.MANAGE_EMPLOYEE, Permission.MANAGE_STORE, Permission.SELL)),
    DEPARTMENTHEAD(5.625,160,7, List.of(Permission.MANAGE_EMPLOYEE, Permission.SELL)),
    SALESCLERK(3.125,160,5, List.of(Permission.SELL)),
    WAREHOUSEWORKER(5,160, 8,List.of(Permission.MANAGE_STORE)),
    CASHIER(5,160,8, List.of(Permission.SELL));

    private final double salaryHour;
    private final double salaryExtraordinaryHour;
    private final int hourWork;
    private List<Permission> permissions;

    Role(double salaryHour, int hourWork, double salaryExtraordinaryHour, List<Permission> permissions){
        this.salaryHour = salaryHour;
        this.hourWork = hourWork;
        this.salaryExtraordinaryHour=salaryExtraordinaryHour;
        this.permissions = permissions;
    }
    public boolean hasPermission(Permission permission){
        return permissions.contains(permission);
    }



    public double getSalaryHour() {
        return salaryHour;
    }

    public int getHourWork() {
        return hourWork;
    }

    public double getSalaryExtraordinaryHour() {
        return salaryExtraordinaryHour;
    }
    public static Role getRandomRoles(){
        Random r = new Random();
        return values()[r.nextInt(values().length)];
    }
}
