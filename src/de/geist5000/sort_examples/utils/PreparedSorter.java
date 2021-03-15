package de.geist5000.sort_examples.utils;

import java.util.Comparator;

public abstract class PreparedSorter<T> extends ListenableSorter<T> {
    protected DataSource<T> data;
    protected CompareHelper<T> comparator;

    public PreparedSorter(T[] data, Comparator<T> comparator) {
        this.data = new DataSource<>(data);
        this.comparator = new CompareHelper<>(comparator);
    }

    @Override
    public void setComparator(Comparator<T> comparator) {
        this.comparator.setComparator(comparator);
    }

    @Override
    public T[] getCurrent() {
        return data.getRaw();
    }

    protected void swapEntries(int first, int second){
        data.swapEntries(first,second);
        callDataChanged(getCurrent());
    }
}
