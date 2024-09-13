package com.code.problemset.problem_146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> cache = new HashMap<>();

    private int size;

    private int capacity;

    private Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 移动至头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            // 添加至map
            cache.put(key, newNode);
            addToHead(newNode);
            this.size++;
            if (this.size > this.capacity) {
                // 如果超出容量，则删除尾节点
                Node tail = removeTail();
                cache.remove(tail.key);
                this.size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

}

class Node {

    int key;

    int value;

    Node prev;

    Node next;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


