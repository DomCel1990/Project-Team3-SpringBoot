package projectSpringBoot.projectTeam3SpringBoot.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.dto.ClientDTO;
import projectSpringBoot.projectTeam3SpringBoot.dto.EmployeeDTO;
import projectSpringBoot.projectTeam3SpringBoot.dto.ProductOrderDTO;
import projectSpringBoot.projectTeam3SpringBoot.dto.ShopDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;
import projectSpringBoot.projectTeam3SpringBoot.enu.Role;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.ClientService;
import projectSpringBoot.projectTeam3SpringBoot.services.EmployeeService;
import projectSpringBoot.projectTeam3SpringBoot.services.ProductService;
import projectSpringBoot.projectTeam3SpringBoot.services.ShopService;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShopService shopService;

    @GetMapping("/client-order/{id}")
    @ApiOperation(value = "Find the client's details", notes = "Finds a client by the his details")
    public ClientDTO getDetailsOrderClient(@PathVariable Long id) {
        return clientService.getInformatioOrder(id);
    }

    @GetMapping("/employee-salary/{id}")
    @ApiOperation(value = "Find an employee", notes = "Finds an employee by the salary")
    public EmployeeDTO getEmployeeSalary(@PathVariable Long id) {
        return employeeService.getEmployeeSalary(id);
    }

    @GetMapping("/employee-filter")
    @ApiOperation(value = "Find the employees", notes = "Finds an employee by his name and surname")
    public List<Employee> findByNameOrSurname(@RequestParam(required = false) String name, @RequestParam(required = false) String surname, @RequestParam(required = false) Role role, @RequestParam(required = false) String email) {
        return employeeRepository.findByNameORDepartment(name, surname, role, email);
    }

    @GetMapping("/product-orders/{id}")
    @ApiOperation(value = "Get the product ordered", notes = "Gets a product ordered by its id")
    public ProductOrderDTO getProductOrder(@PathVariable Long id) {
        return productService.getProductOrder(id);
    }

    @GetMapping("/product-filter")
    @ApiOperation(value = "Find products whit filters", notes = "Finds all the products that have higher prices than the one selected either by type or through the description")
    public List<Product> findByFilter(@RequestParam(required = false) Double salePrice, @RequestParam(required = false) String type, @RequestParam(required = false) String description) {
        return productService.findByPrice(salePrice, type, description);
    }
    @GetMapping("/shop-balance/{id}")
    public ShopDTO getBalance(@PathVariable Long id){
        return shopService.getDetails(id);
    }
}
