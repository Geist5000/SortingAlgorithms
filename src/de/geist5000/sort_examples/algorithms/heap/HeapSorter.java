package de.geist5000.sort_examples.algorithms.heap;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;

/**
 * builds a min heap
 * @param <T> the type which will get sorted
 */
public class HeapSorter<T> extends PreparedSorter<T> {

    public HeapSorter(T[] data, Comparator<T> comparator) {
        super(data, comparator);
    }
    // 0|1|2|3|4|5|6

    @Override
    public void sort() {

        // create a min heap
        for(int i = data.size()/2;i<data.size();i++){
            heapify(i);
        }
        for (int i = data.size()-1; i > 0; i--) {
            swapEntries(0,i);
            heapify(0);
        }
    }


    /**
     * repair given heap which has max 1 wrong element in it
     * @param root the index of the root from the given subtree
     */
    private void heapify(int root){
        while(root > data.size()/2){
            T rootElement = data.get(root);
            int leftChild = getLeftChild(root);
            T leftChildElement = data.get(leftChild);

            if(comparator.compare(rootElement,leftChildElement)>0){
                swapEntries(leftChild,root);
                root = leftChild;
            }else{
                int rightChild = getRightChild(root);
                T rightChildElement = data.get(rightChild);

                if(comparator.compare(rootElement, rightChildElement)>0){
                    swapEntries(root,rightChild);
                    root = rightChild;
                }else{
                    break;
                }
            }
        }
    }


    private int getLeftChild(int root){
        return root*2+1;
    }

    private int getRightChild(int root){
        return root*2+2;
    }

    private int getParent(int child){
        return (child-1)/2;
    }
}
