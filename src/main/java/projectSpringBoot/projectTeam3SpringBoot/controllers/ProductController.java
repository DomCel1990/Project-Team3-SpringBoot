package projectSpringBoot.projectTeam3SpringBoot.controllers;

import io.swagger.annotations.ApiOperation;
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

    @PostMapping
    @ApiOperation(value = "Products Creation", notes = "Takes as input a list of products and saves them")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return productService.createProducts(products);
    }

    @GetMapping
    @ApiOperation(value = "Find products", notes = "Finds all the products and inserts them into a layout, sorting them by ID")
    public Page<Product> getAllProduct(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return productService.getAllProduct(page, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a product", notes = "Finds a product by ID")
    public Optional<Product> getOneProduct(@PathVariable Long id) throws Exception {
        return productService.getProduct(id);
    }

    @PutMapping
    @ApiOperation(value = "Product update", notes = "Edits a product by calling it through the ID")
    public Product putProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
        return productService.putProduct(id, product);
    }
    @DeleteMapping
    @ApiOperation(value = "Products delete", notes = "Deletes all the products")
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Product delete", notes = "Deletes a product by calling it through the ID")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}