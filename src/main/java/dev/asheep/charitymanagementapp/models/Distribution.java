package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

@Entity
public class Distribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
