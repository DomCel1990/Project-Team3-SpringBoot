package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/post")
    public Product product(@RequestBody Product product){
        Product product1 = productRepository.save(product);
        return product1;
    }

    @GetMapping ("/getAll")
    public List<Product> getProduct(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable Long id){
        Product product = productRepository.getById(id);
        return product;
    }

    @PutMapping("/put")
    public Product putProduct(@PathVariable Long id, @RequestBody Product product) throws Exception{
        if(productRepository.existsById(id)){
            product.setId(id);
            Product product1 = productRepository.save(product);
            return product1;
        }else
            throw new Exception("Element not found");
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        productRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}