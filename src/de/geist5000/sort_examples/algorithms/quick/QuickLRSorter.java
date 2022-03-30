package de.geist5000.sort_examples.algorithms.quick;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;

public class QuickLRSorter<T> extends PreparedSorter<T> {
    public QuickLRSorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }

    public QuickLRSorter(T[] data) {
        this(data, null);
    }

    @Override
    public void sort() {
        sort(0, data.size());
    }


    private void sort(int start, int end) {
        T pivot = data.get(getPivot(start, end));
        int lPointer = start;
        int rPointer = end - 1;
        while (lPointer != rPointer) {
            delayOperation();
            if (comparator.compare(data.get(lPointer), pivot) < 0) {
                lPointer++;
            } else if (comparator.compare(data.get(rPointer), pivot) >= 0) {
                rPointer--;
            } else {
                swapEntries(lPointer, rPointer);
            }
        }
        int middle;
        if (comparator.compare(data.get(rPointer), pivot) < 0) {
            middle = rPointer + 1;
        } else {
            middle = rPointer;
        }

        if(middle == end){
            middle--;
        }
        if(middle == start){
            middle++;
        }

        if (middle - start > 1) {
            sort(start, middle);
        }
        if (end - middle > 1) {
            sort(middle, end);
        }


    }

    private int getPivot(int start, int end) {
        return start;
    }
}
