package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class TransferTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne()
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    private Number Amount;
    private String BankTo;
    private String AccountTo;
    private Date Time;
    private String Content;

    public TransferTo() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Number getAmount() {
        return Amount;
    }

    public void setAmount(Number amount) {
        Amount = amount;
    }

    public String getBankTo() {
        return BankTo;
    }

    public void setBankTo(String bankTo) {
        BankTo = bankTo;
    }

    public String getAccountTo() {
        return AccountTo;
    }

    public void setAccountTo(String accountTo) {
        AccountTo = accountTo;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
