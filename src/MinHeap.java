package com.mycompany.filmmanagement;


public class MinHeap {

    private final int maxSize;
    private final Film[] heap;
    private int currentSize;

    public MinHeap(int maxSize) {
        this.heap = new Film[maxSize];
        this.currentSize = -1;
        this.maxSize = maxSize;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

   public void insert(Film film) {
    if (currentSize == maxSize - 1) {
        System.out.println("The heap is full. Cannot insert");
        return;
    }

    currentSize++;
    heap[currentSize] = film;

    int currentIndex = currentSize;

    while (currentIndex > 0 && heap[parent(currentIndex)].popularityScore > heap[currentIndex].popularityScore) {
        Film temp = heap[currentIndex];
        heap[currentIndex] = heap[parent(currentIndex)];
        heap[parent(currentIndex)] = temp;

        currentIndex = parent(currentIndex);
    }
}


    public Film extractMin() {
        if (currentSize < 0) {
            System.out.println("Heap is empty.");
            return null;
        }

        Film minFilm = heap[0];
        heap[0] = heap[currentSize];
        currentSize--;
        minHeapify(0);
        return minFilm;
    }

    private void minHeapify(int i) {
    int left = leftChild(i);
    int right = rightChild(i);
    int smallest = i;

    if (left <= currentSize && heap[left].popularityScore < heap[smallest].popularityScore) {
        smallest = left;
    }
    if (right <= currentSize && heap[right].popularityScore < heap[smallest].popularityScore) {
        smallest = right;
    }
    if (smallest != i) {
        Film temp = heap[i];  
        heap[i] = heap[smallest];
        heap[smallest] = temp;
        minHeapify(smallest);
    }
}



    public void printHeap() {
        for (int i = 0; i <= currentSize; i++) {
            System.out.println(heap[i]);
        }
    }
}
