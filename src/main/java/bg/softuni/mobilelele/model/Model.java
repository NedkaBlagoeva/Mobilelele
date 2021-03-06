package bg.softuni.mobilelele.model;


import bg.softuni.mobilelele.model.enums.VehicleCategory;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private VehicleCategory category;

    private String imageUrl;

    private int startYear;

    private int endYear;

    private LocalDateTime created;

    private LocalDateTime modified;

    @ManyToOne
    private Brand brand;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleCategory getCategory() {
        return category;
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
