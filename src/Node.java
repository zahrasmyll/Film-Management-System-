package com.mycompany.filmmanagement;



    public class Node<T> {
    T data; // DÃ¼ÄŸÃ¼mde saklanan veri
    Node<T> next; // Bir sonraki dÃ¼ÄŸÃ¼m

    // YapÄ±cÄ± (Constructor)
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
