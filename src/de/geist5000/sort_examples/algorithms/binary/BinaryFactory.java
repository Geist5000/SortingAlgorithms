package de.geist5000.sort_examples.algorithms.binary;

import de.geist5000.sort_examples.interfaces.Sorter;
import de.geist5000.sort_examples.interfaces.SorterFactory;

import java.util.Comparator;

public class BinaryFactory implements SorterFactory {
    @Override
    public <T> Sorter<T> createSorter(T[] data) {
        return createSorter(data, null);
    }

    @Override
    public <T> Sorter<T> createSorter(T[] data, Comparator<T> comparator) {
        return new BinarySorter<>(data, comparator);
    }
}
