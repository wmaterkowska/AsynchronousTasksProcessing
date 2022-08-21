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
@EnableAsync
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int base;
    private int exponent;

    private float status;

    private long result;

    public Task(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public Long getId() {return this.id;}

    public int getBase() {return this.base;}

    public int getExponent() {return this.exponent;}

    public float getStatus() {return this.status;}

    public long getResult() {return this.result;}

    @Async
    public void calculateResult() throws InterruptedException {
        this.result = base;
        for (int i = 1; i <= exponent; i++){
            this.status = ( (float) i / exponent) * 100;
            this.result = base * this.result;
            Thread.sleep(1000);
        }
    }


}
