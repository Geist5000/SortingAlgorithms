package de.geist5000.sort_examples.algorithms.merge;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeSorter<T> extends PreparedSorter<T> {
    public MergeSorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }

    public MergeSorter(T[] data) {
        super(data, null);
    }

    @Override
    public void sort() {
        List<T> items = sort(0, data.size());
        int i = 0;
        for (T item : items) {
            data.set(i, item);
            i++;
        }
    }


    private List<T> sort(int start, int end) {
        int length = end - start;

        if (length > 1) {
            int middle = start + length / 2;

            List<T> first = sort(start, middle);
            List<T> second = sort(middle, end);

            Iterator<T> firstIterator = first.iterator();
            Iterator<T> secondIterator = second.iterator();
            T firstCurrent = firstIterator.next();
            T secondCurrent = secondIterator.next();

            List<T> list = new LinkedList<>();

            for (int i = 0; i < length; i++) {

                if (secondCurrent == null) {
                    list.add(firstCurrent);
                    firstCurrent = firstIterator.hasNext() ? firstIterator.next() : null;
                } else if (firstCurrent == null) {
                    list.add(secondCurrent);
                    secondCurrent = secondIterator.hasNext() ? secondIterator.next() : null;
                } else if (comparator.compare(firstCurrent, secondCurrent) > 0) {
                    list.add(secondCurrent);
                    secondCurrent = secondIterator.hasNext() ? secondIterator.next() : null;
                } else {
                    list.add(firstCurrent);
                    firstCurrent = firstIterator.hasNext() ? firstIterator.next() : null;
                }
            }

            return list;
        } else if (length == 1) {
            List<T> list = new LinkedList<>();
            list.add(data.get(start));
            return list;
        } else {
            throw new IllegalArgumentException("Needs minimum 1 items to process");
        }
    }
}
