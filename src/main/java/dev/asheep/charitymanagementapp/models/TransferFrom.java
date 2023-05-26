package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class TransferFrom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne()
    @JoinColumn(name = "donor_id")
    private Donor donor;

    private Number Amount;
    private String BankFrom;
    private String AccountFrom;
    private Date Time;
    private String Content;

    public TransferFrom() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Number getAmount() {
        return Amount;
    }

    public void setAmount(Number amount) {
        Amount = amount;
    }

    public String getBankFrom() {
        return BankFrom;
    }

    public void setBankFrom(String bankFrom) {
        BankFrom = bankFrom;
    }

    public String getAccountFrom() {
        return AccountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        AccountFrom = accountFrom;
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
