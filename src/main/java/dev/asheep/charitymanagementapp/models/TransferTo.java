package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class TransferTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long amount;
    private String bankTo;
    private String accountTo;
    private LocalDateTime time;
    private String content;

    public TransferTo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getBankTo() {
        return bankTo;
    }

    public void setBankTo(String bankTo) {
        this.bankTo = bankTo;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
