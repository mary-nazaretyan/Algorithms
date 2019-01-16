package com.mary;


import com.mary.list.SimpleArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SimpleArrayListTest {

    private SimpleArrayList arrayList = new SimpleArrayList();


    @Test
    public void test_init() {
        assertEquals(0, arrayList.size());
    }

    @Test
    public void should_add() {
        SimpleArrayList arrayList = new SimpleArrayList();
        String first = "firstElement";
        String second = "secondElement";

        arrayList.add(first);
        arrayList.add(second);

        assertEquals(2, arrayList.size());
        assertEquals(first, arrayList.get(0));
        assertEquals(second, arrayList.get(1));
    }

    @Test
    public void should_add_in_case_of_resize() {
        SimpleArrayList arrayList = new SimpleArrayList();
        String[] testData = {"A", "B", "C", "D", "E", "F", "H", "G", "L", "M", "N", "Q"};

        for (String cur : testData) {
            arrayList.add(cur);
        }

        assertEquals(testData.length, arrayList.size());
        for (int i = 0; i < testData.length; i++) {
            assertEquals(testData[i], arrayList.get(i));
        }
    }

    @Test
    public void test_isEmpty() {
        SimpleArrayList arrayList = new SimpleArrayList();

        assertEquals(true, arrayList.isEmpty());

        arrayList.add("First");

        assertEquals(false, arrayList.isEmpty());

        arrayList.clear();

        assertEquals(true, arrayList.isEmpty());
    }

    @Test
    public void should_remove_by_index() {
        SimpleArrayList arrayList = new SimpleArrayList();
        String[] testData = {"A", "B", "C", "D"};
        String[] updatedTestData = {"B", "C", "D"};

        for (String cur : testData) {
            arrayList.add(cur);
        }

        arrayList.remove(0);

        assertEquals(updatedTestData.length, arrayList.size());
        for (int i = 0; i < updatedTestData.length; i++) {
            assertEquals(updatedTestData[i], arrayList.get(i));
        }
    }

    @Test
    public void should_clear() {
        SimpleArrayList arrayList = new SimpleArrayList();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.clear();
        assertEquals(true, arrayList.isEmpty());
        assertEquals(0, arrayList.size());
    }

    @Test//(expected = IndexOutOfBoundsException.class)
    public void should_throw_exception_in_case_of_out_range_index() {
        SimpleArrayList arrayList = new SimpleArrayList();
        arrayList.add("Test");
        arrayList.add("Test2");

        try {
            arrayList.get(2);
            Assert.fail("Should failed before");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index 2 is out of bound, list size is 2", e.getMessage());
        }

        try {
            arrayList.get(-1);
            Assert.fail("Should failed before");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index -1 is out of bound, list size is 2", e.getMessage());
        }
    }

}
