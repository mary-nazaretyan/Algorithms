package com.mary;

import com.mary.list.SortAlgorithms;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import static com.mary.list.SortAlgorithms.bubbleSort;
import static com.mary.list.SortAlgorithms.mergeSort;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@Ignore
public class SortAlgorithmsTest {

    @Test
    public void should_bubbleSort() {
        String[] array = {"bird", "art", "cat", "donkey", "zzz"};

        bubbleSort(array);

        assertEquals("art", array[0]);
        assertEquals("bird", array[1]);
        assertEquals("cat", array[2]);
        assertEquals("donkey", array[3]);
        assertEquals("zzz", array[4]);
    }

    @Test
    public void should_mergeSort() {
        String[] array = {"bird"};

        mergeSort(array);

        assertEquals("art", array[0]);
        assertEquals("bird", array[1]);
        assertEquals("cat", array[2]);
        assertEquals("donkey", array[3]);
        assertEquals("yyy", array[4]);
        assertEquals("zzz", array[5]);
    }

    @Test
    @Ignore
    public void test_merge() {

        String[] first = {"a", "c", "d"};
        String[] seoncd = {"b", "y", "z"};

        String[] merge = SortAlgorithms.merge(first, seoncd);
        assertArrayEquals(new String[]{"a", "b", "c", "d", "y", "z"}, merge);
    }
}
