package dev.asheep.charitymanagementapp.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class TransferFrom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long amount;
    private String bankFrom;
    private String accountFrom;
    private LocalDateTime time;
    private String content;

    public TransferFrom() {
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

    public String getBankFrom() {
        return bankFrom;
    }

    public void setBankFrom(String bankFrom) {
        this.bankFrom = bankFrom;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
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
