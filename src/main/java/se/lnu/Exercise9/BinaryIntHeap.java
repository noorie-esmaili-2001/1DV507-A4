package se.lnu.Exercise9;

import java.util.NoSuchElementException;

public class BinaryIntHeap {
    private int[] heap;
    private int size;

    public void init() {
        size = 0;
        heap = new int[10];
    }

    public BinaryIntHeap() {
        init();
    }

    public void insert(int n) {
        if (size == 0) {
            heap[1] = n;
            size++;
        } else {
            if (size + 2 > heap.length) {
                resize();
            }

            heap[size + 1] = n;
            size++;

            check(size);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    private void check(int index) {
        while (index > 1 && heap[index] > heap[index / 2]) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void swap(int index1, int index2) {
        int swap = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = swap;
    }

    private void resize() {
        int[] newArray = new int[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            newArray[i] = heap[i];
        }
        heap = newArray;
    }

    public int pullHighest() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int highest = heap[1];
        int newest = heap[size];

        heap[1] = newest;
        heap[size] = 0;

        int index = 1;
        int swapIndex = heap[2 * index] > heap[2 * index + 1] ? 2 * index : 2 * index + 1;

        while (heap[index] < heap[swapIndex]) {
            swap(index, swapIndex);
            index = swapIndex;

            if (2 * index + 1 <= size) {
                swapIndex = heap[2 * index] > heap[2 * index + 1] ? 2 * index : 2 * index + 1;
            } else if (2 * index <= size) {
                swapIndex = 2 * index;
            }
        }

        size--;

        return highest;
    }

    public String toString() {
        String str = "";
        for (int i = 1; i <= size; i++) {
            str = str + heap[i] + ",";
        }

        return str;
    }


}