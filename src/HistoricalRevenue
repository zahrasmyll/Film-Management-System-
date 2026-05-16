package com.mycompany.filmmanagement;


public class HistoricalRevenue {
    int size;
    int count;
    RevenueNode top;
    
    public HistoricalRevenue (){
        size = 1000;
        count = 0;
        top = null;
    }

    public void push(double viewership, double ticketPrice) {
        RevenueNode newNode = new RevenueNode(viewership, ticketPrice);
        if (isFull()) {
            System.out.println("HistoricalRevenue is full.");
        } else {
            newNode.next = top;
            top = newNode;
            count++;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("HistoricalRevenue is empty.");
        } else {
            top = top.next;
            count--;
        }
    }

    boolean isFull() {
        return count == size;
    }

    boolean isEmpty() {
        return count == 0;
    }
}
