package de.geist5000.sort_examples.utils;

import de.geist5000.sort_examples.interfaces.SortListener;
import de.geist5000.sort_examples.interfaces.Sorter;

import java.util.ArrayList;
import java.util.List;

public abstract class ListenableSorter<T> implements Sorter<T> {

    private List<SortListener<T>> listeners;


    public ListenableSorter() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(SortListener<T> listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public void removeListener(SortListener<T> listener) {
        listeners.remove(listener);
    }

    protected void callDataChanged(T[] data) {
        for (SortListener<T> l : listeners) {
            l.onDataChanged(data);
        }
    }
}
