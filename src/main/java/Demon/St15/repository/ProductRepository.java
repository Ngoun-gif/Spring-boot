package Demon.St15.repository;

import Demon.St15.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Custom query methods
    List<ProductEntity> findByIsActiveTrue();

    List<ProductEntity> findByPriceGreaterThan(Double price);

    List<ProductEntity> findByNameEnContainingIgnoreCase(String name);

    List<ProductEntity> findByNameKhContainingIgnoreCase(String name);

    
}