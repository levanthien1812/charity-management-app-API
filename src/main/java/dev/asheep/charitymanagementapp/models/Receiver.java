package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;
import jdk.jfr.consumer.RecordedEvent;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "receiver")
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer gender;
    private String phone;
    private LocalDate birthday;
    private String photo;

    private String description;

    private String address;

    private String district;

    private String cityprovince;

    private String country;
    private String docId;

    private String bankName;

    private String bankNumber;

    @ManyToOne()
    @JoinColumn(name = "receiverType_id")
    private ReceiverType receiverType;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private Collection<Distribution> distributions;

    public String getBankName() {
        return bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public Receiver(Integer id, String name, Integer gender, String phone, LocalDate birthday, String photo, String description, String address, String district, String cityprovince, String country, String docId, String bankName, String bankNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.photo = photo;
        this.description = description;
        this.address = address;
        this.district = district;
        this.cityprovince = cityprovince;
        this.country = country;
        this.docId = docId;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
    }

    public String getDocId() {
        return docId;
    }

    public ReceiverType getReceiverType() {
        return receiverType;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public void setReceiverType(ReceiverType receiverType) {
        this.receiverType = receiverType;
    }

    public Receiver() {
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCityprovince() {
        return cityprovince;
    }

    public String getCountry() {
        return country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCityprovince(String cityprovince) {
        this.cityprovince = cityprovince;
    }

    public void setCountry(String country) {
        this.country = country;
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
