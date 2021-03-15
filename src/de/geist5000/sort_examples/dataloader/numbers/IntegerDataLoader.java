package de.geist5000.sort_examples.dataloader.numbers;

import de.geist5000.sort_examples.interfaces.DataLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IntegerDataLoader implements DataLoader<Integer> {
    @Override
    public Integer[] loadData(File f) throws FileNotFoundException {
        List<Integer> data = new LinkedList<>();
        Scanner sc = new Scanner(f);
        while (sc.hasNextInt()) {
            data.add(sc.nextInt());
        }
        return data.toArray(new Integer[0]);
    }

    @Override
    public String dumpData(Integer[] data) {
        StringBuilder builder = new StringBuilder();
        for (Integer i :
                data) {
            builder.append(i.toString() + "\n");
        }
        return builder.toString();
    }
}
