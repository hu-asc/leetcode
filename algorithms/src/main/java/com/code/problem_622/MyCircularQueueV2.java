package com.code.problem_622;

public class MyCircularQueueV2 {

    private Node head;

    private Node tail;

    private int capacity = 0;

    private int count = 0;

    public MyCircularQueueV2(int k) {
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        if (this.count == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        this.count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.head = this.head.next;
        this.count--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : head.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == capacity;
    }

    static class Node {

        int val;

        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

    }

}
