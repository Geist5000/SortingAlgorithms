package de.geist5000.sort_examples;

import de.geist5000.sort_examples.algorithms.SortingAlgorithm;
import de.geist5000.sort_examples.dataloader.numbers.IntegerDataLoader;
import de.geist5000.sort_examples.interfaces.DataLoader;
import de.geist5000.sort_examples.interfaces.Sorter;
import de.geist5000.sort_examples.interfaces.SorterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the sorting tool.");
        System.out.println("Choose the input file.");
        File inputFile = chooseFile(sc,true);
        System.out.println("Choose the output file.");
        File outputFile = chooseFile(sc,false);
        SorterFactory factory = chooseSortingAlgo(sc);
        System.out.println("Loading data ...");
        try {
            DataLoader<Integer> loader = new IntegerDataLoader();
            Integer[] numbers = loader.loadData(inputFile);

            Sorter<Integer> sorter = factory.createSorter(numbers);
            System.out.println("Sorting...");
            sorter.sort();
            Integer[] sorted = sorter.getCurrent();
            writeDataToFile(outputFile,loader.dumpData(sorted));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while loading the input file: " + e.getMessage());
            System.exit(0);
        }

    }


    private static void writeDataToFile(File outputFile, String data){
        try(FileWriter writer = new FileWriter(outputFile)){
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File chooseFile(Scanner sc, boolean needsToExist) {
        File inputFile = null;
        while (inputFile == null) {
            System.out.println("Where is the file located? (specify a relative or complete path)");
            String inputPath = sc.nextLine();
            File f = new File(inputPath);
            if (f.isFile() || !needsToExist) {
                inputFile = f;
            } else {
                System.out.println("File doesn't exist or isn't a file");
            }
        }
        return inputFile;
    }


    private static SorterFactory chooseSortingAlgo(Scanner sc) {
        SortingAlgorithm sorter = null;
        SortingAlgorithm[] algos = SortingAlgorithm.values();
        while (sorter == null) {

            System.out.println(String.format("What Sorting algorithm do you want to use? (%d-%d)", 1, algos.length));

            for (int i = 0; i < algos.length; i++) {
                System.out.println(String.format("\t%d.\t%s", i + 1, algos[i].getDisplayName()));
            }
            int index = sc.nextInt() - 1;
            try {
                sorter = algos[index];
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Number Out of Bounds, try again!");
            }
        }

        return sorter.getFactory();
    }

}



