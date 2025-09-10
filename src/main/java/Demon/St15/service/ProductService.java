package Demon.St15.service;

import Demon.St15.entity.ProductEntity;
import Demon.St15.exception.ResourceNotFoundException;
import Demon.St15.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ Get all records
    public List<ProductEntity> getAllProducts() {
        // Temporary workaround - get all then set createdDate to null
        List<ProductEntity> products = productRepository.findAll();
        products.forEach(p -> p.setCreatedDate(null));
        return products;
    }

    // ✅ Get record by ID
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    // ✅ Add one record
    public ProductEntity addProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    // ✅ Add multiple records
    public List<ProductEntity> addProducts(List<ProductEntity> products) {
        return productRepository.saveAll(products);
    }

    // ✅ Update record by ID
    public ProductEntity updateProduct(Long id, ProductEntity productDetails) {
        ProductEntity product = getProductById(id);

        // Only update fields that should be updated (don't update createdDate on
        // update)
        product.setNameKh(productDetails.getNameKh());
        product.setNameEn(productDetails.getNameEn());
        product.setPrice(productDetails.getPrice());
        product.setIsActive(productDetails.getIsActive());
        // Note: createdDate should not be updated once set

        return productRepository.save(product);
    }

    // ✅ Delete record by ID
    public void deleteProduct(Long id) {
        ProductEntity product = getProductById(id);
        productRepository.delete(product);
    }


    public List<ProductEntity> getProductsByPriceGreaterThan(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }
}