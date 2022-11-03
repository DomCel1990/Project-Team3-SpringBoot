package projectSpringBoot.projectTeam3SpringBoot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "or_fk", referencedColumnName = "id")
    private List<Product> productList;

}
