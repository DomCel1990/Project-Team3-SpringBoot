package projectSpringBoot.projectTeam3SpringBoot.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Shop {

    private String name;
    private String address;
    private String numberToContact;
    private String webSite;
    private List<Employee> employee;
    //private Day day;


    public Shop(String name, String address, String numberToContact, String webSite, List<Employee> employee) {
        this.name = name;
        this.address = address;
        this.numberToContact = numberToContact;
        this.webSite = webSite;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberToContact() {
        return numberToContact;
    }

    public void setNumberToContact(String numberToContact) {
        this.numberToContact = numberToContact;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}

