package projectSpringBoot.projectTeam3SpringBoot.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idShop;
    private String nameShop;
    private String addressShop;
    private String numberToContact;
    private String webSite;
    @OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "se_fk", referencedColumnName = "idShop")
    private List<Employee> employees;
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "sP_fk", referencedColumnName = "idShop")
    private List<Product> productsShop;
    @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_fk",referencedColumnName = "idShop")
    private List<Order> orderShop;


    public Shop() {
    }

    public Shop(String nameShop, String addressShop, String numberToContact, String webSite, List<Employee> employees, List<Product> productsShop,List<Order> orderShop) {
        this.nameShop = nameShop;
        this.addressShop = addressShop;
        this.numberToContact = numberToContact;
        this.webSite = webSite;
        this.employees=employees;
        this.productsShop = productsShop;
        this.setOrderShop(orderShop);
    }

    public double costProduct(){
        double costProduct=0;
        for (int i = 0; i <productsShop.size() ; i++) {
            costProduct+= getProductsShop().get(i).getPrice();
        }
        return costProduct;
    }
    public double costEmployees(){
        double costEmployees=0;
        for (int i = 0; i < getEmployees().size() ; i++) {
            costEmployees+= getEmployees().get(i).calculatorSalary();
        }
        return costEmployees;
    }
    public String managementCost(){
        Double totalCost= costEmployees()+costProduct();
        String managementCost= nameShop +" in the address, "+ addressShop+ " has this cost management: "+totalCost;
        return managementCost;
    }
    public double entryForOrder(){
        double sum=0;
        for(int i =0; i<getOrderShop().size();i++){
           sum+= orderShop.get(i).getTotalSalePrice();
        }
        return sum;
    }
    public String getName() {
        return nameShop;
    }

    public void setName(String name) {
        this.nameShop = name;
    }

    public String getAddress() {
        return addressShop;
    }

    public void setAddress(String address) {
        this.addressShop = address;
    }

    public String getNumberToContact() {
        return numberToContact;
    }

    public void setNumberToContact(String numberToContact) {
        this.numberToContact = numberToContact;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getId() {
        return idShop;
    }

    public void setId(Long id) {
        this.idShop = id;
    }

    public List<Product> getProductsShop() {
        return productsShop;
    }

    public void setProductsShop(List<Product> productsShop) {
        this.productsShop = productsShop;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Order> getOrderShop() {
        return orderShop;
    }

    public void setOrderShop(List<Order> orderShop) {
        this.orderShop = orderShop;
    }
}

