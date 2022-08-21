package com.example.asynchronous.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private int base;
    private int exponent;

    private int status;

    private long result;

    public Task(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public Long getId() {return id;}

    public int getBase() {
        return base;
    }

    public int getExponent() {
        return exponent;
    }

    @Autowired
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Autowired
    public long getResult() {
        return this.result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    @Autowired
    public void calculateResult() throws InterruptedException {
        this.result = base;
        for (int i = 1; i <= exponent; i++){
            this.status = i / exponent * 100;
            setStatus(this.status);
            Thread.sleep(1000);
            this.result = base * this.result;
            setResult(this.result);
        }
    }


}
