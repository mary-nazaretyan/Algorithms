package com.mary.list;

public class SimpleLinkedList {
    private SimpleLinkedList.Node first;
    private SimpleLinkedList.Node last;
    private int size = 0;

    public SimpleLinkedList() {
        this.first = new Node();
        this.last = this.first;
        this.size = 0;
    }

    //O(1) constant time
    public void add(String element) {
        SimpleLinkedList.Node newNode = new SimpleLinkedList.Node(element);
        if (this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        }

        if (this.size >= 1) {
            this.last.setNext(newNode);
            this.last = newNode;
        }

        this.size++;
    }

    // O(1) constant time
    public void addAtFirst(String element){
        SimpleLinkedList.Node newNode = new SimpleLinkedList.Node(element);

        if (this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        }

        if (this.size >= 1) {
            newNode.setNext(this.first);
            this.first = newNode;
        }

        this.size++;
    }

    //O(1) constant time
    public int size() {
        return this.size;
    }

    //o(n)
    public String get(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %s is out of bound, list size is %s",
                    index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
        int current = 0;
        SimpleLinkedList.Node currentNode = first;
        while (current < index) {
            current++;
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();//
    }

    //O(n)
    public void remove(int index) {
        if (index == 0) {
            this.first = this.first.getNext();
        } else {
            int currIndex = 0;
            Node current = this.first;
            while (currIndex < index - 1) {
                current = current.getNext();
                currIndex++;
            }

            current.setNext(current.getNext().getNext());
        }
        this.size--;

    }

    //O(1)
    public boolean isEmpty() {
        return this.size == 0;
    }

    //O(1)
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    private static class Node {
        private String value;
        private Node next;

        public Node(String v, Node next) {
            this.value = v;
            this.next = next;
        }

        public Node(String v) {
            this.value = v;
            this.next = null;
        }

        public Node() {
            this.value = "";
            this.next = null;
        }

        public String getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
