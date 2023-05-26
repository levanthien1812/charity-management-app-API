package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String Unit;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Donation> donations;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Distribution> distributions;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<ItemFrom> itemFroms;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<ItemTo> itemTos;

    public Category() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }
}
