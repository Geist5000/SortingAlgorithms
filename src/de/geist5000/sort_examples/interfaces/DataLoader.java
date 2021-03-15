package de.geist5000.sort_examples.interfaces;

import java.io.File;
import java.io.FileNotFoundException;

public interface DataLoader<T> {

    T[] loadData(File f) throws FileNotFoundException;

    String dumpData(T[] data);
}