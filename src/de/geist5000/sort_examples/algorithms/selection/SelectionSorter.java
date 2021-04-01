package de.geist5000.sort_examples.algorithms.selection;

import de.geist5000.sort_examples.utils.CompareHelper;
import de.geist5000.sort_examples.utils.DataSource;
import de.geist5000.sort_examples.utils.ListenableSorter;
import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;

public class SelectionSorter<T> extends PreparedSorter<T> {


    public SelectionSorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }

    public SelectionSorter(T[] data){
        super(data,null);
    }

    @Override
    public void sort() {
        for (int start = 0; start < data.size() - 1; start++) {

            int min = start;
            for (int current = start + 1; current < data.size(); current++) {
                delayOperation();
                // min is bigger than current
                if (comparator.compare(data.get(min), data.get(current)) >= 0) {
                    min = current;
                }
            }
            swapEntries(start, min);
        }
    }
}
