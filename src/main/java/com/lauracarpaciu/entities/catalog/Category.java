package com.lauracarpaciu.entities.catalog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lauracarpaciu.entities.data.BaseEntity;
import com.lauracarpaciu.entities.product.Product;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "categories")
public class Category extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotEmpty
    @Size(min = 4, max = 20)
    private String categoryName;
    @Size(min = 8)
    private String description;
    @Lob
    private byte[] photo;
    private String PhotoName;
    @OneToMany(mappedBy = "categories")
    private Collection<Product> products;

    public Category() {
        super();
    }

    public Category(String categoryName, String description, byte[] photo, String photoName) {
        super();
        this.categoryName = categoryName;
        this.description = description;
        this.photo = photo;
        PhotoName = photoName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return PhotoName;
    }

    public void setPhotoName(String photoName) {
        PhotoName = photoName;
    }

    @JsonIgnore
    @XmlTransient
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}