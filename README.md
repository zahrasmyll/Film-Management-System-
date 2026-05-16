# 🎬 Film Management System (Custom Data Structures Implementation)

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Course](https://img.shields.io/badge/Course-Data%20Structures-green.svg)](#)

This project is a comprehensive Movie and Actor Management System built completely from scratch in Java without utilizing the built-in Java Collections Framework. It serves as a practical implementation of fundamental **Data Structures** concepts to handle complex entity relationships, system metrics, and search operations.

---

## 📌 Project Overview

The system allows managing a network of movies, actors, historical financial data, and reviews through interconnected custom data structures.

### Key Features
* **Movie & Actor Management:** Create, update, and link actors with the films they participated in.
* **Historical Revenue Tracking:** Keeps track of box office performance and ticket sales over time.
* **Rating & Queue System:** Manages IMDb scores and processing queues for film screenings.
* **Review System:** Dedicated structures to handle user comments and rating calculations.

---

## 🛠️ Data Structures Applied

To maximize performance and mimic database behaviors, the following custom data structures were developed:

| Data Structure | Implementation Class | System Component / Use Case |
| :--- | :--- | :--- |
| **Generic Singly Linked List** | `LinkedList<T>` | Managing actors inside films and arbitrary collection storage. |
| **Custom Stack (LIFO)** | `HistoricalRevenue` | Pushing and popping seasonal ticket/viewership revenue updates. |
| **Custom Queue (FIFO)** | `FilmScreening` / `ImdbNode` | Enqueuing and dequeuing IMDb ratings to compute historical benchmarks. |
| **Binary Search Tree (BST)** | `BSTnode` | Designed for fast $O(\log n)$ lookup of movies and actors by their unique names or IDs. |

---

## 💻 Architectural Overview & Core Logic

### 1. Movie & Actor Association
The system uses a custom `LinkedList` representation where each `Film` object maintains a list of participating actors, and each `Actor` links back to their filmography.

### 2. Custom Stack Behavior (`HistoricalRevenue.java`)
Financial updates are stored in a stack structure to ensure that the most recent box office logs can be reviewed or reverted easily:
```java
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
```

### 3. Custom Queue Processing (FilmScreening.java)
IMDb scores are safely queued in a First-In-First-Out manner to maintain chronological ratings analysis:

```java
public void enqueue (double imdb){
    ImdbNode newNode = new ImdbNode (imdb);
    if(rear == null){
        front = rear = newNode;
    } else {
        rear.next = newNode;
        rear = newNode;
    }
}
```
