package de.geist5000.sort_examples.algorithms.bogo;

import de.geist5000.sort_examples.interfaces.SorterFactory;
import de.geist5000.sort_examples.utils.ListenableSorter;

import java.util.Comparator;

public class BogoFactory extends SorterFactory {
    @Override
    public <T> ListenableSorter<T> createSorter(T[] data, Comparator<T> comparator) {
        return new BogoSorter<>(data, comparator);
    }
}
