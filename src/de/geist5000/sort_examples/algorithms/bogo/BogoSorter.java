package de.geist5000.sort_examples.algorithms.bogo;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class BogoSorter<T> extends PreparedSorter<T> {

    private Random random = new Random();

    public BogoSorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }

    public BogoSorter(T[] data) {
        super(data, null);
    }

    @Override
    public void sort() {
        while (!isSorted()){
            this.delayOperation();
            shuffle();
        }

    }


    private void shuffle() {
        for (int i = this.data.size(); i > 1; i--)
            swapEntries(i - 1, random.nextInt(i));
    }

    private boolean isSorted() {
        T[] current = getCurrent();
        for (int i = 1; i < current.length; i++) {
            if (comparator.compare(current[i - 1], current[i]) > 0) {
                return false;
            }
        }

        return true;
    }


}
