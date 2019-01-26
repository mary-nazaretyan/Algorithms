package com.mary.list;


public class SimpleHashMap {

    private int size = 0;
    private SimpleHashMap.Entry[] data;

    public SimpleHashMap() {
        data = new SimpleHashMap.Entry[10];
    }

    public int getSize() {
        return this.size;
    }

    public void put(String key, String value) {
        if ((double) this.size / (double) data.length > 0.75) {
            resize();
        }
        SimpleHashMap.Entry newEntry = new SimpleHashMap.Entry(key, value);
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % this.data.length);
        if (data[index] == null) {
            data[index] = newEntry;
            this.size++;
        } else {
            addOrUpdate(data[index], key, value);
        }
    }

    private void resize() {
        SimpleHashMap.Entry[] dataCopy = this.data;
        this.size = 0;
        this.data = new SimpleHashMap.Entry[this.data.length * 2];
        for (SimpleHashMap.Entry t : dataCopy) {
            SimpleHashMap.Entry current = t;
            if (current == null) {
                continue;
            }
            do {
                this.put(current.getKey(), current.getValue());
                current = current.getNext();
            } while (current != null);
        }

    }

    private void addOrUpdate(Entry entry, String key, String value) {
        Entry current = entry;

        if (current.getKey().equals(key)) {
            current.setValue(value);
            return;
        }
        while (current.getNext() != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }


        Entry newEntry = new Entry(key, value);
        current.setNext(newEntry);
        this.size++;

    }

    public String get(String key) {

        int index = key.hashCode() % this.data.length;
        if (data[index] == null) {
            return null;
        }
        Entry current = data[index];
        do {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        } while (current != null);

        return null;
    }

    private static class Entry {

        private String key;
        private String value;
        private Entry next;

        public Entry() {

        }

        public Entry(String key, String value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Entry getNext() {
            return next;
        }
    }
}
