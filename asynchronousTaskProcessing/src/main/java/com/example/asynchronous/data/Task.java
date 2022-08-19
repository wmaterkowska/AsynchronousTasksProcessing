package com.example.asynchronous.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.Future;

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
    private int exponent;
    private int base;

    public String result(){

        Long result = (long) this.base ^ this.exponent;
        return result.toString();
    }

    @Async
    public Future<String> resultOfTask(){
        System.out.println("test" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            return new AsyncResult<String>("test2" + result()) ;
        } catch (InterruptedException e) {
        }
        return null;
    }




}
