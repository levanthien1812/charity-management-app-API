package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class TransferTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne()
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    private Number Amount;
    private String BankTo;
    private String AccountTo;
    private Date Time;
    private String Content;
}
