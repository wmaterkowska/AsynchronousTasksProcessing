package com.example.asynchronous.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public void setStatus(float status) {this.status = status;}

    public void setResult(long result) {this.result = result;}
}
