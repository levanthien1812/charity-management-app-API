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
}
