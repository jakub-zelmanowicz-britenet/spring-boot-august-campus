package pl.britenet.springbootaugustcampus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.model.Product;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;

@SpringBootTest
class SpringBootAugustCampusApplicationTests {

    @Test
    void testGetProductSuccessfully() {
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);

        Optional<Product> oProduct = productService.getProduct(1);

        Assertions.assertTrue(oProduct.isPresent());
        Assertions.assertEquals("Motor", oProduct.get().getName());
    }

    @Test
    void testGetProductNone() {
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);

        Optional<Product> oProduct = productService.getProduct(100);

        Assertions.assertFalse(oProduct.isPresent());
    }

}
