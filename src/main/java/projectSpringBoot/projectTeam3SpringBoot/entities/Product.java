package projectSpringBoot.projectTeam3SpringBoot.entities;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    private String description;
    private double price;
    private double salePrice;
    private String type;
    private String serialCode;
    
    public Product(){}

    public Product(Long idProduct, String description, double price, double salePrice, String type, String serialCode) {
        this.idProduct = idProduct;
        this.description = description;
        this.price = price;
        this.salePrice = salePrice;
        this.type = type;
        this.serialCode = serialCode;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }
}
