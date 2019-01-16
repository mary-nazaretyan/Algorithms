package com.mary;


import com.mary.list.SimpleLinkedList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleLinkedListTest {


    @Test
    public void test_init() {

        SimpleLinkedList linkedList = new SimpleLinkedList();

        assertEquals(0, linkedList.size());

    }

    @Test
    public void should_add() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        String first = "firstElement";
        String second = "secondElement";
        String third = "thirdElement";

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        assertEquals(3, linkedList.size());
        assertEquals(first, linkedList.get(0));
        assertEquals(second, linkedList.get(1));
        assertEquals(third, linkedList.get(2));
    }

    @Test
    public void should_addAtFirst() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        String first = "firstElement";
        String second = "secondElement";
        String third = "thirdElement";

        linkedList.addAtFirst(third);
        linkedList.addAtFirst(second);
        linkedList.addAtFirst(first);

        assertEquals(3, linkedList.size());
        assertEquals(first, linkedList.get(0));
        assertEquals(second, linkedList.get(1));
        assertEquals(third, linkedList.get(2));
    }

    @Test
    public void should_add_in_case_of_resize() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        String[] testData = {"A", "B", "C", "D", "E", "F", "H", "G", "L", "M", "N", "Q"};

        for (String cur : testData) {
            linkedList.add(cur);
        }

        assertEquals(testData.length, linkedList.size());
        for (int i = 0; i < testData.length; i++) {
            assertEquals(testData[i], linkedList.get(i));
        }
    }

    @Test
    public void test_isEmpty() {
        SimpleLinkedList linkedList = new SimpleLinkedList();

        assertEquals(true, linkedList.isEmpty());

        linkedList.add("First");

        assertEquals(false, linkedList.isEmpty());

        linkedList.clear();

        assertEquals(true, linkedList.isEmpty());
    }

    @Test
    public void should_remove_by_index() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        String[] testData = {"A", "B", "C", "D"};
//        String[] updatedTestData = {"B", "C", "D"};

        for (String cur : testData) {
            linkedList.add(cur);
        }

        linkedList.remove(1);

        assertEquals("A", linkedList.get(0));
        assertEquals("C", linkedList.get(1));
        assertEquals("D", linkedList.get(2));

        assertEquals(3, linkedList.size());

    }


    @Test
    public void should_remove_first_element() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        String[] testData = {"A", "B", "C", "D"};

        for (String cur : testData) {
            linkedList.add(cur);
        }

        linkedList.remove(0);

        assertEquals("B", linkedList.get(0));
        assertEquals("C", linkedList.get(1));
        assertEquals("D", linkedList.get(2));

        assertEquals(3, linkedList.size());

    }
    @Test
    public void should_remove_last_element() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        String[] testData = {"A", "B", "C", "D"};

        for (String cur : testData) {
            linkedList.add(cur);
        }

        linkedList.remove(linkedList.size() - 1);

        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));

        assertEquals(3, linkedList.size());

    }

    @Test
    public void should_clear() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.clear();
        assertEquals(true, linkedList.isEmpty());
        assertEquals(0, linkedList.size());
    }

    @Test//(expected = IndexOutOfBoundsException.class)
    public void should_throw_exception_in_case_of_out_range_index() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        linkedList.add("Test");
        linkedList.add("Test2");

        try {
            linkedList.get(2);
            Assert.fail("Should failed before");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index 2 is out of bound, list size is 2", e.getMessage());
        }

        try {
            linkedList.get(-1);
            Assert.fail("Should failed before");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index -1 is out of bound, list size is 2", e.getMessage());
        }
    }

}
