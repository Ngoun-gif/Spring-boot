package Demon.St15.controller;

import Demon.St15.entity.ProductEntity;
import Demon.St15.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ✅ Get all products
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // ✅ Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    // ✅ Create multiple products
    @PostMapping("/bulk")
    public ResponseEntity<List<ProductEntity>> createProducts(@Valid @RequestBody List<ProductEntity> products) {
        return ResponseEntity.ok(productService.addProducts(products));
    }

    // ✅ Update product
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductEntity productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    // ✅ Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}