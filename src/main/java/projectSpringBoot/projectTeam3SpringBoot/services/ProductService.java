package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import projectSpringBoot.projectTeam3SpringBoot.dto.ProductOrderDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;
import projectSpringBoot.projectTeam3SpringBoot.repositories.OrderRepository;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    public List<Product> createProducts(List<Product> products) {
        List<Product> productList = productRepository.saveAllAndFlush(products);
        return productList;
    }

    public Page<Product> getAllProduct(Optional<Integer> page, Optional<Integer> size) {
        Pageable pageable = null;
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
            pageable = PageRequest.of(page.get(), size.get(), sort);
            Page<Product> productGet = productRepository.findAll(pageable);
            return productGet;
        } else {
            Page<Product> pageProduct = Page.empty();
            return pageProduct;
        }
    }

    public ProductOrderDTO getProductOrder(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        ProductOrderDTO dto = new ProductOrderDTO();
        dto.setOrder(order.get());
        return dto;
    }

    public List<Product> findByPrice(Double salePrice, String type, String description) {
        return productRepository.findByPrice(salePrice, type, description);
    }

    public Optional<Product> getProduct(Long id) throws Exception {
        if (productRepository.existsById(id)) {
            Optional<Product> product = productRepository.findById(id);
            return product;
        } else
            throw new Exception("The product with id: " + id + ", doesn't exist");
    }

    public Product putProduct(Long id, Product product) throws Exception {
        if (productRepository.existsById(id)) {
            product.setIdProduct(id);
            Product product1 = productRepository.save(product);
            return product1;
        } else
            throw new Exception("Element not found");
    }
}
