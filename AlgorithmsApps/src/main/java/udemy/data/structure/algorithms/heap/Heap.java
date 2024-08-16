package udemy.data.structure.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * java Built-in class for max Heap is priorityQueue
 * PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
 */

/*
 * Complexity : O(log n) -> [insert, remove]
 * Heap is the best implementation for priority Queue which select the priority based on weights
 * Heap has max value in the top node of heap tree
 * each row in the tree should be inserted first in the heap array list
 * left child and right child nodes should be less than  parent node
 * left child and right child nodes position index in heap list should be [ (2 * parent's index) + 1 and (2 * parent's index) +2 ]
 * parent's index = [ (child's index -1)/2 ]
 */
public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * reorder heap to have max node in the tree in the top and its two children are less than top
     * 
     */
    
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }
 // remove first item -> swap first item with last item -> sink down to reorder tree to have max item in the top 
    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }

    
    

}














