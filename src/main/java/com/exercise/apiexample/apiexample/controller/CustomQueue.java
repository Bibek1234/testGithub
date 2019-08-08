package com.exercise.apiexample.apiexample.controller;

import com.exercise.apiexample.apiexample.Service.Customer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;

public class CustomQueue {

    public static void main(String[] args) {

        BlockingQueue<Customer> blockingQueue = new ArrayBlockingQueue<>(12);

        final Runnable producer = () -> {
            while (true) {
                try {
                    blockingQueue.put(new Customer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();




    }

}