package com.harrisonparks.week_12;

import java.util.ArrayList;
import java.util.List;

class QueueEmptyException extends Exception {}
class QueueFullException extends Exception {}

class Queue<E> {
    List<E> elements = new ArrayList<>();
    int size;

    Queue(int size) {
        this.size = size;
    }

    public void enqueue(E element) throws QueueFullException {
        if (elements.size() >= size) {
            throw new QueueFullException();
        }
        elements.add(element);
    }

    public E dequeue() throws QueueEmptyException {
        if (elements.size() == 0 ) {
            throw new QueueEmptyException();
        }
        return elements.remove(0);
    }
}

public class Main {

    public static void main(String[] args) {
        Queue<String> names = new Queue<>(3);
        try {
            names.enqueue("123");
            names.enqueue("456");
            System.out.println(names.dequeue());
            System.out.println(names.dequeue());
        }
        catch (QueueEmptyException | QueueFullException e) {
            e.printStackTrace();
        }
    }
}