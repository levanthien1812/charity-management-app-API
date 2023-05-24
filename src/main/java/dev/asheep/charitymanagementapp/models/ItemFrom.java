package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ItemFrom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne()
    @JoinColumn(name = "donor_id")
    private Donor donor;

    private Number Amount;
    private Date Time;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
