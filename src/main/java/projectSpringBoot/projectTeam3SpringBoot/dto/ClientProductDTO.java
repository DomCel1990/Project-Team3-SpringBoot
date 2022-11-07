package projectSpringBoot.projectTeam3SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientProductDTO {
    private String type;
    private String description;
    private double price;


}
