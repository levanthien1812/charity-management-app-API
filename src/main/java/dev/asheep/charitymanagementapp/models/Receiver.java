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

    public Receiver() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getGender() {
        return Gender;
    }

    public void setGender(Integer gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
