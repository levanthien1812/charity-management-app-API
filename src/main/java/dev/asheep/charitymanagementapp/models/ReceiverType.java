package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "receiver_type")
public class ReceiverType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public ReceiverType() {
    }

    public ReceiverType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
