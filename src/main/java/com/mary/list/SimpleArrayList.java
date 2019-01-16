package com.mary.list;

import java.util.Arrays;

public class SimpleArrayList {
    private String[] dataArray;
    private int size = 0;

    public SimpleArrayList() {
        this.dataArray = new String[10];
    }

    public SimpleArrayList(int size) {
        this.dataArray = new String[size];

    }

    //O(1) , constant time
    public void add(String element) {
        if (dataArray.length == size) {
            String[] tempArray = new String[dataArray.length * 2];
            System.arraycopy(this.dataArray, 0, tempArray, 0, this.dataArray.length);

            this.dataArray = tempArray;
        }
        this.dataArray[size] = element;
        this.size++;
    }

    //O(1) , constant time
    public String get(int index) {

        if (index >= this.size || index < 0) {
            String message = String.format("Index %s is out of bound, list size is %s",
                    index, this.size);
            throw new IndexOutOfBoundsException(message);
        }

        return this.dataArray[index];
    }

    //O(1) , constant time
    public int size() {
        return this.size;
    }


    //O(n),
    public void remove(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(this.dataArray, index + 1, this.dataArray, index,
                numMoved);
        this.dataArray[size - 1] = null;
        this.size--;
    }

    //O(1) , constant time
    public boolean isEmpty() {
        return this.size == 0;
    }

    //O(n)
    public void clear() {
        Arrays.fill(this.dataArray, null);
        this.size = 0;
    }


}
