package com.mycompany.filmmanagement;


public class FilmScreening {
    ImdbNode front;
    ImdbNode rear;
    
    public FilmScreening(){
        this.front = null;
        this.rear = null;
    }
    
    public void enqueue (double imdb){
        ImdbNode newNode = new ImdbNode (imdb);
        if(rear == null){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
    }
    
    public Double dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        double imdb = front.imdb;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return imdb;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
