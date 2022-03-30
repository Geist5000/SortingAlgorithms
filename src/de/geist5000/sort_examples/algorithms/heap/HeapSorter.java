package de.geist5000.sort_examples.algorithms.heap;

import de.geist5000.sort_examples.utils.PreparedSorter;

import java.util.Comparator;

/**
 * builds a max heap
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
        for(int i = data.size()/2-1;i>=0;i--){
            delayOperation();
            heapify(i,data.size());
        }
        for (int i = data.size()-1; i > 0; i--) {
            delayOperation();
            swapEntries(0,i);
            heapify(0,i);
        }
    }


    /**
     * repair given heap which has max 1 wrong element in it
     * @param root the index of the root from the given subtree
     */
    private void heapify(int root,int last){

        while(root < data.size()/2){
            T rootElement = data.get(root);
            int leftChild = getLeftChild(root);
            int rightChild = getRightChild(root);

            int maxChild;
            T maxElement;
            if(leftChild>=last){
                break;
            }
            if(rightChild<last){
                T leftElement = data.get(leftChild);
                T rightElement = data.get(rightChild);
                if(comparator.compare(leftElement,rightElement)<0){
                    maxChild = rightChild;
                    maxElement = rightElement;
                }else{
                    maxChild = leftChild;
                    maxElement = leftElement;
                }

            }else{
                maxChild = leftChild;
                maxElement = data.get(maxChild);
            }


            if(comparator.compare(rootElement,maxElement)<0){
                swapEntries(maxChild,root);
                root = maxChild;
            }else{
                break;
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
