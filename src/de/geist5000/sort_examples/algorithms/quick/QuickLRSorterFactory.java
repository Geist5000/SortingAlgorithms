package de.geist5000.sort_examples.algorithms.quick;

import de.geist5000.sort_examples.interfaces.Sorter;
import de.geist5000.sort_examples.interfaces.SorterFactory;
import de.geist5000.sort_examples.utils.ListenableSorter;

import java.util.Comparator;

public class QuickLRSorterFactory extends SorterFactory {

    @Override
    public <T> ListenableSorter<T> createSorter(T[] data, Comparator<T> comparator) {
        return new QuickLRSorter<>(data, comparator);
    }
}
