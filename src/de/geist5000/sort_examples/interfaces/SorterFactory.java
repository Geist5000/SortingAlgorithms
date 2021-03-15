package de.geist5000.sort_examples.interfaces;

import java.util.Comparator;

public interface SorterFactory {


    <T> Sorter<T> createSorter(T[] data);
    <T> Sorter<T> createSorter(T[] data, Comparator<T> comparator);
}
