package com.mary;

import com.mary.list.SimpleHashMap;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleHashMapTest {

    @Test
    public void test_put() {
        SimpleHashMap simpleHashMap = new SimpleHashMap();

        simpleHashMap.put("Mary", "Nazaretyan");
        simpleHashMap.put("Mary", "NazaretyanUpdate");
        simpleHashMap.put("Vahe", "Harutyunyan");
        assertEquals(2, simpleHashMap.getSize());
        System.out.println("Test");

    }

    @Test
    public void should_get_by_key() {
        SimpleHashMap simpleHashMap = new SimpleHashMap();

        String mary = "Mary";
        String nazaretyan = "Nazaretyan";
        simpleHashMap.put(mary, nazaretyan);

        String harutyunyan = "Harutyunyan";
        String harutyunyanUpdate = "HarutyunyanUpdate";
        String vahe = "Vahe";

        simpleHashMap.put(vahe, harutyunyan);
        simpleHashMap.put(vahe, harutyunyanUpdate);


        assertEquals(harutyunyanUpdate, simpleHashMap.get(vahe));
        assertEquals(nazaretyan, simpleHashMap.get(mary));

        assertEquals(2, simpleHashMap.getSize());
    }

    @Test
    public void test_resize(){
        SimpleHashMap simpleHashMap = new SimpleHashMap();

        simpleHashMap.put("vahe", "harutyunyan");
        simpleHashMap.put("karen", "khondkaryan");
        simpleHashMap.put("vahagn", "khachatryan");
        simpleHashMap.put("anahit", "poghosyan");
        simpleHashMap.put("mari", "harutyunyan");
        simpleHashMap.put("hrant", "vardanyan");
        simpleHashMap.put("mary", "nazaretyan");
        simpleHashMap.put("aghasi", "qerobyan");
        simpleHashMap.put("shushan", "nazaretyan");
        simpleHashMap.put("anush", "nazaretyan");
        simpleHashMap.put("lia", "harutyunyan");
        simpleHashMap.put("narek", "harutyunyan");
        simpleHashMap.put("aram", "harutyunyan");
        simpleHashMap.put("john", "harutyunyan");
        simpleHashMap.put("sam", "harutyunyan");
        simpleHashMap.put("kate", "harutyunyan");
        simpleHashMap.put("smith", "harutyunyan");
        simpleHashMap.put("gary", "harutyunyan");
        simpleHashMap.put("jane", "harutyunyan");
        simpleHashMap.put("hayk", "harutyunyan");
        simpleHashMap.put("david", "karapetyan");
//
        assertEquals(21, simpleHashMap.getSize());

        assertEquals("karapetyan", simpleHashMap.get("david"));

    }
}
