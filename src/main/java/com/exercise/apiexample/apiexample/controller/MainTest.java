package com.exercise.apiexample.apiexample.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class MainTest {

    public static void main(String[] args) {

        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(1,"Bibek");
        hashMap.put(2,"sauzan");
        hashMap.put(7,"panthi");
        hashMap.put(3,"subedi");
        hashMap.put(4,"Bidari");

        System.out.println(hashMap);

        Collection<String> collection=hashMap.values();

        for (String c:collection){
            System.out.println(c);
        }

    }

    public static class TestData {

        public static void main(String[] args) {


        }

    }
}