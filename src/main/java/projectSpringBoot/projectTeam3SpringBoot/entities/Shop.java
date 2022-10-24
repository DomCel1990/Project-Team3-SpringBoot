package projectSpringBoot.projectTeam3SpringBoot.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String numberToContact;
    private String webSite;
   // private List<Employee> employee;
    //private Day day;


    public Shop() {
    }

    public Shop(Long id,String name, String address, String numberToContact, String webSite) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberToContact = numberToContact;
        this.webSite = webSite;
        //this.employee = employee;
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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}

