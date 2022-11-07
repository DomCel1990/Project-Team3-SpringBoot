package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.dto.ProductOrderDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ProductRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/create")
    public Product product(@RequestBody Product product) {
        Product product1 = productRepository.save(product);
        return product1;
    }

    @PostMapping("/creates")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return productService.createProducts(products);
    }

    @GetMapping("/gets")
    public Page<Product> getAllProduct(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return productService.getAllProduct(page, size);
    }

    @GetMapping("get/{id}")
    public Optional<Product> getOneProduct(@PathVariable Long id) throws Exception {
        return productService.getProduct(id);
    }
    @GetMapping("/repo/{id}")
    public ProductOrderDTO getProductOrder(@PathVariable Long id){
        Optional<Order> order = orderRepository.findById(id);
        ProductOrderDTO dto= new ProductOrderDTO();
        dto.setOrder(order.get());
        return dto;
    }

    @PutMapping("/update")
    public Product putProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
        return productService.putProduct(id, product);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}