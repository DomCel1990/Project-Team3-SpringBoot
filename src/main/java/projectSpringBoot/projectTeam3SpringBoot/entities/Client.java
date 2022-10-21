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
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String address;
    private int age;
    private boolean hasLoyaltyCard;
    //private LoyaltyCard card;
}
