package projectSpringBoot.projectTeam3SpringBoot.dto;

import lombok.Data;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;

import java.util.List;

@Data
public class ProductOrderDTO {
    private Order order;
}
