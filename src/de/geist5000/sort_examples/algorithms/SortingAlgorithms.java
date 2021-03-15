package de.geist5000.sort_examples.algorithms;

import de.geist5000.sort_examples.algorithms.bubble.BubbleFactory;
import de.geist5000.sort_examples.algorithms.insertion.InsertionFactory;
import de.geist5000.sort_examples.algorithms.merge.MergeFactory;
import de.geist5000.sort_examples.algorithms.selection.SelectionFactory;
import de.geist5000.sort_examples.interfaces.SorterFactory;

public enum SortingAlgorithms {

    BUBBLE("Bubblesort", new BubbleFactory()), SELECTION("Selectionsort", new SelectionFactory()), INSERTION("Insertionsort", new InsertionFactory()),
    MERGE("Mergesort", new MergeFactory());

    SortingAlgorithms(String name, SorterFactory factory) {
        this.name = name;
        this.factory = factory;
    }

    private String name;
    private SorterFactory factory;

    public String getDisplayName() {
        return name;
    }
    public SorterFactory getFactory(){
        return factory;
    }
}
