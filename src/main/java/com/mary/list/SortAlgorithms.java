package com.mary.list;


public class SortAlgorithms {

    //O(n^2)
    public static void bubbleSort(String[] array) {

        for (int j = 0; j < array.length - 2; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    String temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}
