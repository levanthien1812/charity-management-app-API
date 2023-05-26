package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image;
    private String description;
    private String address;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Number amountNeeded;
    private Number amountGot;
    private Number donorQuantity;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Collection<Donation> donations;

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Number getAmountNeeded() {
        return amountNeeded;
    }

    public void setAmountNeeded(Number amountNeeded) {
        this.amountNeeded = amountNeeded;
    }

    public Number getAmountGot() {
        return amountGot;
    }

    public void setAmountGot(Number amountGot) {
        this.amountGot = amountGot;
    }

    public Number getDonorQuantity() {
        return donorQuantity;
    }

    public void setDonorQuantity(Number donorQuantity) {
        this.donorQuantity = donorQuantity;
    }
}


