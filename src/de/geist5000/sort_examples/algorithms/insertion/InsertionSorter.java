package de.geist5000.sort_examples.algorithms.insertion;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;

public class InsertionSorter<T> extends PreparedSorter<T> {
    public InsertionSorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }

    public InsertionSorter(T[] data) {
        super(data, null);
    }

    @Override
    public void sort() {
        for (int start = 1; start < data.size(); start++) {
            int current = start;
            while (current > 0 && comparator.compare(data.get(current), data.get(current - 1)) < 0) {
                swapEntries(current, current - 1);
                current -= 1;
            }
        }
    }
}
