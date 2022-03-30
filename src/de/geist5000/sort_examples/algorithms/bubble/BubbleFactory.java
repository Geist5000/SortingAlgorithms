package de.geist5000.sort_examples.algorithms.bubble;

import de.geist5000.sort_examples.interfaces.Sorter;
import de.geist5000.sort_examples.interfaces.SorterFactory;
import de.geist5000.sort_examples.utils.ListenableSorter;

import java.util.Comparator;

public class BubbleFactory extends SorterFactory {
    @Override
    public <T> ListenableSorter<T> createSorter(T[] data, Comparator<T> comparator) {
        return new BubbleSorter<>(data,comparator);
    }
}
