package de.geist5000.sort_examples.utils;

import java.util.Comparator;

public class CompareHelper<T> {

    private Comparator<T> comparator;

    public CompareHelper(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public int compare(T first, T second) {
        if (comparator != null) {
            return comparator.compare(first, second);
        } else if (first instanceof Comparable && second instanceof Comparable) {
            return ((Comparable) first).compareTo(second);
        } else {
            throw new IllegalStateException("Type isn't comparable and no comparator is given");
        }
    }
}
