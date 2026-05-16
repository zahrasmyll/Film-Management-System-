package com.mycompany.filmmanagement;


public class RevenueNode {
    RevenueNode next;
    double ticketPrice;
    double viewership;
    double totalRevenue;
    
    
    public RevenueNode (double viewership , double ticketPrice){
        
        this.ticketPrice = ticketPrice;
        this.viewership = viewership;
        this.totalRevenue = ticketPrice * viewership;
        next = null;
        
    }

}
