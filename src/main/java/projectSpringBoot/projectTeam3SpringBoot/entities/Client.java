package projectSpringBoot.projectTeam3SpringBoot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email; //email unica
    private String address;
    private int age;
    private boolean hasLoyaltyCard;
    //private LoyaltyCard card;
}