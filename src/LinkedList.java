package com.mycompany.filmmanagement;



    public class LinkedList<T> {
    private Node<T> head; 

    public LinkedList() {
        this.head = null;
    }

    // 1. Eleman Ekleme 
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode; 
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next; 
            }
            current.next = newNode; 
        }
    }

    // 2. Eleman Silme
    public void delete(T data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data.equals(data)) {
            head = head.next; 
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("data is not found");
        } else {
            current.next = current.next.next; 
        }
    }

    // 3. Eleman Arama
    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; 
            }
            current = current.next;
        }
        return false; 
    }

    // 4. Listeyi YazdÄ±rma
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
