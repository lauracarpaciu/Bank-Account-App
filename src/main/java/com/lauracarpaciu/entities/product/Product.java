package com.lauracarpaciu.entities.product;

import com.lauracarpaciu.entities.catalog.Category;
import com.lauracarpaciu.entities.data.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @NotEmpty
    @Size(min = 4, max = 15)
    private String designation;
    private String description;
    private double unitPrice;
    private boolean selected;
    private String photo;
    private int quantity;
    private Boolean inStock;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {
        super();

    }

    public Product(Long createdAt, Long lastModified, String designation, String description, double unitPrice, boolean selected, String photo, int quantity) {
        super(createdAt, lastModified);
        this.designation = designation;
        this.description = description;
        this.unitPrice = unitPrice;
        this.selected = selected;
        this.photo = photo;
        this.quantity = quantity;
    }

    public Product(String designation, String description, double unitPrice, boolean selected, String photo, int quantity, Category category) {
        this.designation = designation;
        this.description = description;
        this.unitPrice = unitPrice;
        this.selected = selected;
        this.photo = photo;
        this.quantity = quantity;
        this.category = category;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + designation + '\'' +
                ", productId='" + productId + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}