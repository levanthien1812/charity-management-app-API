package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String unit;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Event> events;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<ItemFrom> itemFroms;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<ItemTo> itemTos;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
