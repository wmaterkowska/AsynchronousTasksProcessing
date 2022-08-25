package com.example.asynchronous.data;

import lombok.*;
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

    public long getId() {return id;}

    public int getBase() {return base;}

    public int getExponent() {return exponent;}

    public float getStatus() {return status;}

    public long getResult() {return result;}

    @Async
    public void calculateResult() throws InterruptedException {
        long currentResult = 1;
        for (int i = 1; i <= exponent; i++){
            Thread.sleep(1000);
            this.status = ( (float) i / exponent) * 100;
            currentResult = base * currentResult;
        }
        this.result = currentResult;
    }


}
