package de.geist5000.sort_examples.algorithms.heap;

import de.geist5000.sort_examples.interfaces.Sorter;
import de.geist5000.sort_examples.interfaces.SorterFactory;

import java.util.Comparator;

public class HeapFactory extends SorterFactory {

    @Override
    public <T> Sorter<T> createSorter(T[] data, Comparator<T> comparator) {
        return new HeapSorter<>(data, comparator);
    }
}
