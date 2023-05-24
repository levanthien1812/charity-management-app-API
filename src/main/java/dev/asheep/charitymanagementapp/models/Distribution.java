package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

@Entity
public class Distribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne()
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

//    used for category money
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transfer_id")
    private TransferTo transfer;

//    used for category items
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private ItemTo item;
}
