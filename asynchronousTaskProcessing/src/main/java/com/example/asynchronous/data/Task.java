package com.example.asynchronous.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@EnableAsync
public class Task {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int base;
    @Column
    private int exponent;
    @Column
    private float status;
    @Column
    private long result;

    public long getId() {return this.id;}

    public int getBase() {return this.base;}

    public int getExponent() {return this.exponent;}

    public float getStatus() {return this.status;}

    public long getResult() {return this.result;}


    //@Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void calculateResult(final TaskRepository taskRepository) throws InterruptedException {
        long currentResult = 1;
        for (int i = 1; i <= this.exponent; i++){
            Thread.sleep(1000);
            this.status = ( (float) i / this.exponent) * 100;
            currentResult = this.base * currentResult;
            taskRepository.save(this);
        }
        this.result = currentResult;
        taskRepository.save(this);
    }



}
