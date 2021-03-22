package de.geist5000.sort_examples.algorithms.bubble;

import de.geist5000.sort_examples.interfaces.Sorter;
import de.geist5000.sort_examples.interfaces.SorterFactory;

import java.util.Comparator;

public class BubbleFactory extends SorterFactory {
    @Override
    public <T> Sorter<T> createSorter(T[] data, Comparator<T> comparator) {
        return new BubbleSorter<>(data,comparator);
    }
}
