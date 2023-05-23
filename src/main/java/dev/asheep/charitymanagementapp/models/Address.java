package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String province;
    private String district;
    private String street;

    public Address(Integer id, String province, String district, String street) {
        this.id = id;
        this.province = province;
        this.district = district;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
