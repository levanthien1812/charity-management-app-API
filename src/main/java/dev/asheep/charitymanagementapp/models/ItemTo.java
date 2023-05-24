package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ItemTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne()
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    private Number Amount;
    private Date Time;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
