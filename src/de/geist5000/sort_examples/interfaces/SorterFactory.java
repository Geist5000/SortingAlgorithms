package de.geist5000.sort_examples.interfaces;

import de.geist5000.sort_examples.utils.ListenableSorter;

import java.util.Comparator;

public abstract class SorterFactory {


    public <T> ListenableSorter<T> createSorter(T[] data) {
        return createSorter(data, null);
    }

    public abstract <T> ListenableSorter<T> createSorter(T[] data, Comparator<T> comparator);
}
