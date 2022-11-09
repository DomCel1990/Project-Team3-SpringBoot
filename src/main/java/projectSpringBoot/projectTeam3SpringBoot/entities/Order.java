package projectSpringBoot.projectTeam3SpringBoot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long idOrder;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "or_fk", referencedColumnName = "id")
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name = "shop_id_shop")
    private Shop shop;

    public double getTotalSalePrice() {
        double sum = 0;
        for (int i = 0; i < productList.size(); i++) {
            sum += productList.get(i).getSalePrice();
        }
        return sum;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (int i = 0; i < productList.size(); i++) {
            sum += productList.get(i).getPrice();
        }
        return sum;
    }

    public double getProfit() {
        double profit = getTotalSalePrice() - getTotalPrice();
        return profit;
    }

}
