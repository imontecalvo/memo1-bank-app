package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private Long cbuAccount;

    private Double sum;

    public Transaction() {
    }

    public Transaction(Long cbuAccount, Double sum) {
        this.cbuAccount = cbuAccount;
        this.sum = sum;
    }

    public String getType(){
        return this.type;
    }

    public Double getSum(){
        return this.sum;
    }

    public Long getCbuAccount(){
        return this.cbuAccount;
    }
}