package com.example.asynchronousTaskProcessing.data;

import org.springframework.stereotype.Component;

@Component
public class Task {

    private long id;
    public int exponent;
    public int base;

    public Task(long id, int exponent, int base) {
        this.id = id;
        this.exponent = exponent;
        this.base = base;
    }


}
