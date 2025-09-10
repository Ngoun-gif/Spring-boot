package Demon.St15.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Khmer name is required")
    @Size(max = 50, message = "Khmer name cannot exceed 50 characters")
    @Column(name = "name_kh")
    private String nameKh;

    @NotBlank(message = "English name is required")
    @Size(max = 50, message = "English name cannot exceed 50 characters")
    @Column(name = "name_en")
    private String nameEn;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "isActive is required")
    @Column(name = "is_active")
    private Boolean isActive;

    @NotNull(message = "Created date is required")
    @Column(name = "created_date")
    private LocalDate createdDate;

    // Default constructor (required by JPA)
    public ProductEntity() {
    }

    // Parameterized constructor
    public ProductEntity(String nameKh, String nameEn, Double price, Boolean isActive, LocalDate createdDate) {
        this.nameKh = nameKh;
        this.nameEn = nameEn;
        this.price = price;
        this.isActive = isActive;
        this.createdDate = createdDate;
    }

    // Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameKh() {
        return nameKh;
    }

    public void setNameKh(String nameKh) {
        this.nameKh = nameKh;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", nameKh='" + nameKh + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", price=" + price +
                ", isActive=" + isActive +
                ", createdDate=" + createdDate +
                '}';
    }
}