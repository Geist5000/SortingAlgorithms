package de.geist5000.sort_examples.utils;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class DataSource<T> {
    T[] data;

    public DataSource(T[] data) {
        this.data = Arrays.copyOf(data,data.length);
    }

    public T get(int index){
        return data[index];
    }

    public T set(int index, T value){
        return data[index] = value;
    }

    public void swapEntries(int first, int second) {
        T tmp = this.get(first);
        this.set(first,this.get(second));
        this.set(second,tmp);
    }

    public int size(){
        return data.length;
    }


    public T[] getRaw(){
        return data;
    }
}
