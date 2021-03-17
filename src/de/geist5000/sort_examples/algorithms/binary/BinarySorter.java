package de.geist5000.sort_examples.algorithms.binary;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;

public class BinarySorter<T> extends PreparedSorter<T> {
    public BinarySorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }

    public BinarySorter(T[] data) {
        super(data, null);
    }

    @Override
    public void sort() {
        for (int i = 1; i < data.size(); i++) {
            insertBinary(i, 0, i);
        }
    }


    /**
     * inserts the given value inside the sorted array located between the start and end index ( end excluded)
     *
     * @param value the index of the value which will get inserted
     * @param start the start index of the sorted array (included)
     * @param end   the last index of the sorted array (excluded)
     */
    private void insertBinary(int value, int start, int end) {
        T item = data.get(value);
        int index = findIndex(item, start, end);
        insertValue(value, index);
    }


    private void insertValue(int value, int index) {
        while (value > index) {
            data.swapEntries(value, --value);
        }
    }


    private int findIndex(T value, int start, int end) {
        int index = -1;

        while (index == -1) {
            int current = start + (end - start) / 2;
            int diff = comparator.compare(value, data.get(current));
            if (end - start <= 1) {
                if(diff<0){
                    index = start;
                }else{
                    index = end;
                }
            } else {
                if (diff < 0) {
                    // current is bigger than value
                    end = current;
                } else if (diff == 0) {
                    // current is the same as value
                    index = current;
                } else {
                    //current is smaller than value
                    start = current + 1;
                }
            }
        }

        return index;
    }
}
