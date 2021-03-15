package de.geist5000.sort_examples.interfaces;

import java.util.Comparator;

public interface Sorter<T> {


    void sort();
    void setComparator(Comparator<T> comparator);
    T[] getCurrent();

}
