package com.mary.list;


import java.util.Arrays;

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

    public static void mergeSort(String[] array) {
        if (array.length == 1) {
            return;
        }
        //else {
        String[] first = new String[array.length / 2];
        String[] second = new String[array.length / 2];
        System.arraycopy(array, 0, first, 0, array.length / 2);
        System.arraycopy(array, array.length / 2 + 1, second, 0, array.length / 2);
        mergeSort(first);
        mergeSort(second);
        array = merge(first, second);
//        }
    }


    //4 7 9
    // 1 2 3
    // 4 5 6
    // O(n)
    public static String[] merge(String[] first, String[] second) {
        String[] array = new String[first.length + second.length];
        int i = 0, j = 0;
        while (i < first.length -1  && j < second.length - 1) {
            if (first[i].compareTo(second[j]) < 0) {
                array[i + j] = first[i];
                i++;
            } else {
                array[i + j] = second[j];
                j++;
            }
        }
        return array;
    }

}
