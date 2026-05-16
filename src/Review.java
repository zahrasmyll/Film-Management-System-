package com.mycompany.filmmanagement;


public class Review {
    
    private int rating;
    private String comment;
    private String reviewerName;

    public Review(int rating, String comment, String reviewerName) {
        this.rating = rating;
        this.comment = comment;
        this.reviewerName = reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return reviewerName + " (" + rating + "): " + comment;
    }
}
