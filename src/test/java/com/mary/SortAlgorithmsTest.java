package com.mary;

import org.junit.Test;

import static com.mary.list.SortAlgorithms.bubbleSort;
import static org.junit.Assert.assertEquals;

public class SortAlgorithmsTest {

    @Test
    public void should_bubbleSort(){
        String[] array = {"bird", "art", "cat", "donkey", "zzz"};

        bubbleSort(array);

        assertEquals("art", array[0]);
        assertEquals("bird", array[1]);
        assertEquals("cat", array[2]);
        assertEquals("donkey", array[3]);
        assertEquals("zzz", array[4]);
    }
}
