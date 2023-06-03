package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalTime;

@Entity
public class ItemTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long plannedQuantity;

    private Long actualQuantity;
    private LocalTime time;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public ItemTo() {
    }

    public Long getPlannedQuantity() {
        return plannedQuantity;
    }

    public void setPlannedQuantity(Long plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public Long getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Long actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
