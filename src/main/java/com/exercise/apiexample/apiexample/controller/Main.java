package com.exercise.apiexample.apiexample.controller;

import java.util.*;

public class Main {

    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void test(String a,String b){
        if (a==b){
            System.out.println("they are equal");
        }
        else {
            System.out.println("they are false");
        }
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Main)) return false;
        Main main = (Main) o;
        return b == main.b &&
                Objects.equals(a, main.a);
    }*/

  /*  @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }*/
}
