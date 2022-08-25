package com.example.asynchronous.data;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.*;

@Entity
@Table(name="TASK")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EnableAsync
public class Task {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="BASE")
    private int base;
    @Column(name="EXPONENT")
    private int exponent;
    @Column(name="STATUS")
    private float status;
    @Column(name="RESULT")
    private long result;

    public long getId() {return this.id;}

    public int getBase() {return this.base;}

    public int getExponent() {return this.exponent;}

    public float getStatus() {return this.status;}

    public long getResult() {return this.result;}

    public void setStatus(float status) {
        this.status = status;
    }

    public void setResult(long result) {
        this.result = result;
    }

    @Async
    public void calculateResult() throws InterruptedException {
        long currentResult = 1;
        for (int i = 1; i <= this.exponent; i++){
            Thread.sleep(1000);
            this.status = ( (float) i / this.exponent) * 100;
            currentResult = this.base * currentResult;
        }
        this.result = currentResult;
    }



}
