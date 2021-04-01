package de.geist5000.sort_examples.utils;

import de.geist5000.sort_examples.interfaces.SortListener;
import de.geist5000.sort_examples.ui.SortingVisualisation;

public class DataVisualisationManager implements SortListener<Integer> {


    private SortingVisualisation<Integer> visualiser;

    public void setupWIthVisualiser(SortingVisualisation<Integer> visualiser){
        this.visualiser = visualiser;
    }

    public void setupSorter(ListenableSorter<Integer> sorter){
        sorter.addListener(this);
    }

    @Override
    public void onDataChanged(Integer[] data) {
        visualiser.setData(data);
    }

    @Override
    public void delaySortingOperation() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
