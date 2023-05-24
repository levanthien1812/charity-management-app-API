package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class TransferFrom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne()
    @JoinColumn(name = "donor_id")
    private Donor donor;

    private Number Amount;
    private String BankFrom;
    private String AccountFrom;
    private Date Time;
    private String Content;
}
