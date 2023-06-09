package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "distribution")
public class Distribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

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

    private String status;

    public Distribution() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TransferTo getTransfer() {
        return transfer;
    }

    public void setTransfer(TransferTo transfer) {
        this.transfer = transfer;
    }

    public ItemTo getItem() {
        return item;
    }

    public void setItem(ItemTo item) {
        this.item = item;
    }
}
