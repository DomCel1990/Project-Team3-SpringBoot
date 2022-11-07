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

    @PostMapping("/create")
    @ApiOperation(value = "Product Creation", notes = "Takes a product as input and saves it")
    public Product product(@RequestBody Product product) {
        Product product1 = productRepository.save(product);
        return product1;
    }

    @PostMapping("/creates")
    @ApiOperation(value = "Products Creation", notes = "Takes as input a list of products and saves them")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return productService.createProducts(products);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Find Products", notes = "Find all products and insert them into a layout sorting them by ID")
    public Page<Product> getAllProduct(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return productService.getAllProduct(page, size);
    }

    @GetMapping("get/{id}")
    @ApiOperation(value = "Find Product", notes = "Find product by ID")
    public Optional<Product> getOneProduct(@PathVariable Long id) throws Exception {
        return productService.getProduct(id);
    }

    @GetMapping("/repo/{id}")
    public ProductOrderDTO getProductOrder(@PathVariable Long id) {
        return productService.getProductOrder(id);
    }

    @GetMapping("/filter")
    @ApiOperation(value = "Find product whit filters", notes = "Find all the products that we have a higher price than the one selected either by type or through the description")
    public List<Product> findByFilter(@RequestParam(required = false) Double salePrice, @RequestParam(required = false) String type, @RequestParam(required = false) String description) {
        return productService.findByPrice(salePrice, type, description);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Product update", notes = "Edit a product by calling it through the ID")
    public Product putProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
        return productService.putProduct(id, product);
    }

    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "Products delete", notes = "Delete all products")
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Product delete", notes = "Delete a product by calling it through the ID")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}