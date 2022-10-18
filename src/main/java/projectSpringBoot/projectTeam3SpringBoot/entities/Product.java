package projectSpringBoot.projectTeam3SpringBoot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Product {

        private Long id;
        private String description;
        private double price;
        private double salePrice;
        private String type;
        private String serialCode;



    }
