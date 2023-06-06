package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "item_from")
public class ItemFrom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double amount;
    private LocalTime time;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public ItemFrom() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
