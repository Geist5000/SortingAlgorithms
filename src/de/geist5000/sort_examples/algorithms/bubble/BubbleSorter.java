package de.geist5000.sort_examples.algorithms.bubble;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;

public class BubbleSorter<T> extends PreparedSorter<T> {


    public BubbleSorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }
    public BubbleSorter(T[] data){
        super(data,null);
    }

    @Override
    public void sort() {
        if (data != null && data.size() > 1) {
            for (int i = 0; i < data.size()- 1; i++) {
                int last = 0;
                for (int j = 1; j < data.size() - i; j++) {
                    delayOperation();
                    int comp = comparator.compare(data.get(last), data.get(j));
                    // last entry is bigger than the current one
                    if (comp > 0) {
                        swapEntries(last, j);
                    }
                    last = j;
                }
            }
        }

    }
}
