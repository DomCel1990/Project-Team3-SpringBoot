package projectSpringBoot.projectTeam3SpringBoot.dto;

import lombok.Data;


@Data
public class ShopDTO {
    private String name;
    private double costEmployee;
    private double costProduct;
    private double entryOrder;


    public String toString(){
        return "- Staff cost: "+ costEmployee+"<br>"+
                "- Product cost: "+ costProduct+"<br>"+
                "- Profit: "+ entryOrder+"<br>";
    }
}

