package projectSpringBoot.projectTeam3SpringBoot.dto;

import lombok.Data;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private Long idOrder;
    private List<ClientProductDTO> products;
    private double totalcost;
}
