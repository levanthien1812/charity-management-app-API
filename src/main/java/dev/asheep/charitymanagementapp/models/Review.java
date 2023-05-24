package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_id")
    private Donor donor;

    private String Content;
}
