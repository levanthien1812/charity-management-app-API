package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Title;
    private String Image;
    private String Description;
    private String Address;
    private Date DateBegin;
    private Date DateEnd;
    private Number AmountNeeded;
    private Number AmountGot;
    private Number DonorQuantity;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Collection<Donation> donations;

    public Event() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getDateBegin() {
        return DateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        DateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        DateEnd = dateEnd;
    }

    public Number getAmountNeeded() {
        return AmountNeeded;
    }

    public void setAmountNeeded(Number amountNeeded) {
        AmountNeeded = amountNeeded;
    }

    public Number getAmountGot() {
        return AmountGot;
    }

    public void setAmountGot(Number amountGot) {
        AmountGot = amountGot;
    }

    public Number getDonorQuantity() {
        return DonorQuantity;
    }

    public void setDonorQuantity(Number donorQuantity) {
        DonorQuantity = donorQuantity;
    }
}


