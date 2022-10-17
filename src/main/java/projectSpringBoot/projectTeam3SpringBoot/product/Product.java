package projectSpringBoot.projectTeam3SpringBoot.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

        private String description;
        private double price;
        private double salePrice;
        private String type;
        private String serialCode;



    }
