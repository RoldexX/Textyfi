package com.slava_110.exam;

public class Stack<T> {
    private final T[] arr;
    private int size = 0;

    public Stack(T[] arr) {
        this.arr = arr;
    }

    public boolean push(T element) {


        arr[size++] = element;
    }

    public T pop() {
        T element = arr[size--];

        return element;
    }
}
