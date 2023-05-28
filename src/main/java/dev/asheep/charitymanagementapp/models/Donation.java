package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "donor_id")
    private Donor donor;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

//    used for category money
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "transfer_id")
    private TransferFrom transfer;

//    used for category item
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_id")
    private ItemFrom item;

    public Donation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TransferFrom getTransfer() {
        return transfer;
    }

    public void setTransfer(TransferFrom transfer) {
        this.transfer = transfer;
    }

    public ItemFrom getItem() {
        return item;
    }

    public void setItem(ItemFrom item) {
        this.item = item;
    }
}
