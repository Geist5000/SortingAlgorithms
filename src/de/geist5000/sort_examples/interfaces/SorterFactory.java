package de.geist5000.sort_examples.interfaces;

import java.util.Comparator;

public abstract class SorterFactory {


    public <T> Sorter<T> createSorter(T[] data) {
        return createSorter(data, null);
    }

    public abstract <T> Sorter<T> createSorter(T[] data, Comparator<T> comparator);
}
