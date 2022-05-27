package com.bfs.testingdemo;

public class Counter {
    private int num = 0;

    public int increment() {
        return ++num;
    }

    public int decrement() {
        return --num;
    }

    public int getCurrentValue() {
        return num;
    }
}
