package dev.asheep.charitymanagementapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image;
    private String description;
    private String address;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private Long amountNeeded;
    private Long amountGot;
    private Integer donorQuantity;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Collection<Donation> donations;

    @ManyToMany(mappedBy = "joinedEvents")
    private Set<Donor> joinedDonors;

    public Event() {
        this.donorQuantity = 0;
        this.amountGot = 0L;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Long getAmountNeeded() {
        return amountNeeded;
    }

    public void setAmountNeeded(Long amountNeeded) {
        this.amountNeeded = amountNeeded;
    }

    public Long getAmountGot() {
        return amountGot;
    }

    public void setAmountGot(Long amountGot) {
        this.amountGot = amountGot;
    }

    public Integer getDonorQuantity() {
        return donorQuantity;
    }

    public void setDonorQuantity(Integer donorQuantity) {
        this.donorQuantity = donorQuantity;
    }
}


