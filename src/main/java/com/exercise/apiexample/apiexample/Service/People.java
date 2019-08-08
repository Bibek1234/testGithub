package com.exercise.apiexample.apiexample.Service;

public class People extends Person {

    private int a;

    public People(int id,String name,double salary){
        super(id,name,salary);
        a=34;

    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
