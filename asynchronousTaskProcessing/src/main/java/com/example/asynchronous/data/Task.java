package com.example.asynchronous.data;

import lombok.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EnableAsync
public class Task {


    private long id;
    private int base;
    private int exponent;

    private float status;

    private long result;

    @Async
    public void calculateResult() throws InterruptedException {
        long currentResult = 1;
        for (int i = 1; i <= exponent; i++){
            this.status = ( (float) i / exponent) * 100;
            currentResult = base * currentResult;
            Thread.sleep(1000);
        }
        this.result = currentResult;
    }


}
