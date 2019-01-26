package com.mary;


import com.mary.list.GenericArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GenericArrayListTest {

    private GenericArrayList<String> arrayList = new GenericArrayList<>();
    private GenericArrayList<Integer> arrayListInteger = new GenericArrayList<>();


    @Test
    public void test_init() {

        assertEquals(0, arrayList.size());
        assertEquals(0, arrayListInteger.size());

    }

    @Test
    public void should_add() {
        GenericArrayList<String> arrayList = new GenericArrayList();
        GenericArrayList<Integer> arrayListInteger = new GenericArrayList();
        String first = "firstElement";
        String second = "secondElement";

        arrayList.add(first);
        arrayList.add(second);

        assertEquals(2, arrayList.size());

        assertEquals(first, arrayList.get(0));
        assertEquals(second, arrayList.get(1));

        arrayListInteger.add(10);
        arrayListInteger.add(20);
        assertEquals(2, arrayListInteger.size());
        assertEquals(10, arrayListInteger.get(0));
        assertEquals(20, arrayListInteger.get(1));


    }

    @Test
    public void should_add_in_case_of_resize() {
        GenericArrayList<String> arrayList = new GenericArrayList<>();
        String[] testData = {"A", "B", "C", "D", "E", "F", "H", "G", "L", "M", "N", "Q"};

        for (String cur : testData) {
            arrayList.add(cur);
        }

        assertEquals(testData.length, arrayList.size());
        for (int i = 0; i < testData.length; i++) {
            assertEquals(testData[i], arrayList.get(i));
        }


        GenericArrayList<Integer> arrayListInteger = new GenericArrayList<>();
        Integer[] testDataInteger = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};

        for (Integer cur : testDataInteger) {
            arrayListInteger.add(cur);
        }

        assertEquals(testDataInteger.length, arrayListInteger.size());
        for (int i = 0; i < testDataInteger.length; i++) {
            assertEquals(testDataInteger[i], arrayListInteger.get(i));
        }
    }

    @Test
    public void test_isEmpty() {
        GenericArrayList<String> arrayList = new GenericArrayList<>();

        assertEquals(true, arrayList.isEmpty());

        arrayList.add("First");

        assertEquals(false, arrayList.isEmpty());

        arrayList.clear();

        assertEquals(true, arrayList.isEmpty());

///////////
        GenericArrayList<Integer> arrayListInt = new GenericArrayList<>();

        assertEquals(true, arrayListInt.isEmpty());

        arrayListInt.add(10);

        assertEquals(false, arrayListInt.isEmpty());

        arrayListInt.clear();

        assertEquals(true, arrayListInt.isEmpty());
    }

    @Test
    public void should_remove_by_index() {
        GenericArrayList<String> arrayList = new GenericArrayList<>();
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
////////////////
        GenericArrayList<Integer> arrayListInt = new GenericArrayList<>();
        Integer[] testDataInt = {10, 20, 30, 40};
        Integer[] updatedTestDataInt = {20, 30, 40};

        for (Integer cur : testDataInt) {
            arrayListInt.add(cur);
        }

        arrayListInt.remove(0);

        assertEquals(updatedTestDataInt.length, arrayListInt.size());
        for (int i = 0; i < updatedTestDataInt.length; i++) {
            assertEquals(updatedTestDataInt[i], arrayListInt.get(i));
        }
    }

    @Test
    public void should_clear() {
        GenericArrayList<String> arrayList = new GenericArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.clear();
        assertEquals(true, arrayList.isEmpty());
        assertEquals(0, arrayList.size());

        /////////////////
        GenericArrayList<Integer> arrayListInt = new GenericArrayList<>();
        arrayListInt.add(10);
        arrayListInt.add(20);
        arrayListInt.clear();
        assertEquals(true, arrayListInt.isEmpty());
        assertEquals(0, arrayListInt.size());
    }

    @Test//(expected = IndexOutOfBoundsException.class)
    public void should_throw_exception_in_case_of_out_range_index() {
        GenericArrayList<String> arrayList = new GenericArrayList<>();
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
