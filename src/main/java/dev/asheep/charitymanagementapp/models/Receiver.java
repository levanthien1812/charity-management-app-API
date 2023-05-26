package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@Entity
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer gender;
    private String phone;
    private LocalDate birthday;
    private String photo;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Collection<Distribution> distributions;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Collection<TransferTo> transfers;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Collection<ItemTo> itemTos;

    public Receiver() {
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public Collection<Distribution> getDistributions() {
        return distributions;
    }

    public void setDistributions(Collection<Distribution> distributions) {
        this.distributions = distributions;
    }
}
