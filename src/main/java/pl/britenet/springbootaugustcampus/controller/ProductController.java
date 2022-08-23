package pl.britenet.springbootaugustcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.model.Product;
import pl.britenet.campus.service.ProductService;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/v1/product/1 - PathParam
    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {
        return this.productService.getProduct(productId);
    }

    @GetMapping
    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        // this.productService.createProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        // this.productService.createProduct(product);
    }

    // DELETE /api/v1/product/1 - PathParam
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        // this.productService.createProduct(product);
    }
}
