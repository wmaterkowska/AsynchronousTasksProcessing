package com.example.asynchronous.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    private Long id;
    private int base;
    private int exponent;
    private int status;
    private long result;

    public Task(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    @Async
    public void calculateResult() throws InterruptedException {
        this.result = base;
        for (int i = 1; i <= exponent; i++){
            this.status = i / exponent * 100;
            Thread.sleep(1000);
            result = base * result;
        }
    }


}
