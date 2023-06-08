package dev.asheep.charitymanagementapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "donor")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private LocalDate birthday;
    @Column(columnDefinition = "TEXT")
    private String photo;
    private String email;
    private String address;
    private Integer score;
    private LocalDate joinDate;
    @Column(columnDefinition = "TEXT")
    private String slogan;
    private String username;
    @JsonIgnore
    private String password;
//    private Integer eventQuantity;
    private Double totalTransferAmount;
    private Double totalItemAmount;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @JsonIgnore
    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    private Set<Donation> donations = new HashSet<>();

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "donation",
//            joinColumns =  @JoinColumn(name = "donor_id"),
//            inverseJoinColumns = @JoinColumn(name = "event_id"))
//    private Set<Event> joinedEvents = new HashSet<>();

    public Donor() {
        this.joinDate = LocalDate.now();
        this.score = 0;
//        this.eventQuantity = 0;
        this.totalItemAmount = 0D;
        this.totalTransferAmount = 0D;
        this.role = Role.USER;
    }

    public void addDonation(Donation donation) {
        this.donations.add(donation);
    }

//    public void addJoinedEvent(Event event) {
//        this.joinedEvents.add(event);
//    }

//    Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Donation> getDonations() {
        return donations;
    }

    public void setDonations(Set<Donation> donations) {
        this.donations = donations;
    }

//    public Set<Event> getJoinedEvents() {
//        return joinedEvents;
//    }
//
//    public void setJoinedEvents(Set<Event> joinedEvents) {
//        this.joinedEvents = joinedEvents;
//    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Integer getEventQuantity() {
//        return eventQuantity;
//    }
//
//    public void setEventQuantity(Integer eventQuantity) {
//        this.eventQuantity = eventQuantity;
//    }

    public Double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public void setTotalTransferAmount(Double totalTransferAmount) {
        this.totalTransferAmount = totalTransferAmount;
    }

    public Double getTotalItemAmount() {
        return totalItemAmount;
    }

    public void setTotalItemAmount(Double totalItemAmount) {
        this.totalItemAmount = totalItemAmount;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
