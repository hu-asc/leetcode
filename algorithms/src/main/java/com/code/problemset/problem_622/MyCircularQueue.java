package com.code.problemset.problem_622;

/**
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations
 * are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle.
 * It is also called "Ring Buffer".
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new values.
 * Implementation the MyCircularQueue class:
 *
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 */
public class MyCircularQueue {

    private int[] storage;

    private int front = 0;

    private int rear = -1;

    private int length = 0;

    /**
     * 用数组来存储元素，维护头尾指针
     */
    public MyCircularQueue(int k) {
        storage = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % storage.length;
        storage[rear] = value;
        length++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % storage.length;
        length--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : storage[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : storage[rear];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == storage.length;
    }

}
