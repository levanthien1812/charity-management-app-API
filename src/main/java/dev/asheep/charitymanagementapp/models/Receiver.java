package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Name;
    private Integer Gender;
    private String Phone;
    private Date Birthday;
    private String Photo;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Collection<Distribution> distributions;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Collection<TransferTo> transfers;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Collection<ItemTo> itemTos;
}
