package projectSpringBoot.projectTeam3SpringBoot.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table
public class Client {
    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameClient;
    private String surnameClient;
    @Column(unique = true)
    private String emailClient;
    private String address;
    private int age;
    private boolean hasLoyaltyCard;
    public Client(){}
    public Client(String nameClient, String surnameClient, String emailClient, String address, int age, boolean hasLoyaltyCard) {
        this.nameClient = nameClient;
        this.surnameClient = surnameClient;
        this.emailClient = emailClient;
        this.address = address;
        this.age = age;
        this.hasLoyaltyCard = hasLoyaltyCard;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasLoyaltyCard() {
        return hasLoyaltyCard;
    }

    public void setHasLoyaltyCard(boolean hasLoyaltyCard) {
        this.hasLoyaltyCard = hasLoyaltyCard;
    }
}
