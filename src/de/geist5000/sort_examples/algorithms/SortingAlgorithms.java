package de.geist5000.sort_examples.algorithms;

import de.geist5000.sort_examples.algorithms.binary.BinaryFactory;
import de.geist5000.sort_examples.algorithms.bubble.BubbleFactory;
import de.geist5000.sort_examples.algorithms.insertion.InsertionFactory;
import de.geist5000.sort_examples.algorithms.merge.MergeFactory;
import de.geist5000.sort_examples.algorithms.selection.SelectionFactory;
import de.geist5000.sort_examples.interfaces.SorterFactory;

public enum SortingAlgorithms {

    BUBBLE("Bubble sort", new BubbleFactory()), SELECTION("Selection sort", new SelectionFactory()), INSERTION("Insertion sort", new InsertionFactory()),
    BINARY("Binary insertion sort", new BinaryFactory()), MERGE("Merge sort", new MergeFactory());

    SortingAlgorithms(String name, SorterFactory factory) {
        this.name = name;
        this.factory = factory;
    }

    private String name;
    private SorterFactory factory;

    public String getDisplayName() {
        return name;
    }

    public SorterFactory getFactory() {
        return factory;
    }
}
