package com.mycompany.filmmanagement;


public class Film {
private String filmName;
    private String filmID;
    private LinkedList<String> actors;
    private String genre;
    private int releaseYear;
    private double totalRevenue;
    private HistoricalRevenue historicalRevenue;
    private FilmNode head;
    private FilmScreening filmScreening;
    private double averageRating;
    double popularityScore;
    private ReviewLinkedList reviews;

    public Film(String filmName, String filmID, String genre, int releaseYear, double totalRevenue) {
        this.filmName = filmName;
        this.filmID = filmID;
        this.actors = new LinkedList<>();
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.totalRevenue = totalRevenue;
        this.averageRating = 0.0;
        this.popularityScore = 0.0;
        this.reviews = new ReviewLinkedList();
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmID() {
        return filmID;
    }

    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public LinkedList<String> getActors() {
        return actors;
    }

    public void setActors(LinkedList<String> actors) {
        this.actors = actors;
    }
    
    public double getAverageRating() {
        return averageRating;
    }
    
    public void setAvearageRating(double averageRating){
        this.averageRating = averageRating;
    }

    public ReviewLinkedList getReviews() {
        return reviews;
    }

    public void setReviews(ReviewLinkedList reviews) {
        this.reviews = reviews;
    }

    public HistoricalRevenue getHistoricalRevenue() {
        return historicalRevenue;
    }

    public void setHistoricalRevenue(HistoricalRevenue historicalRevenue) {
        this.historicalRevenue = historicalRevenue;
    }

    public void addActor(String actorName) {
        actors.add(actorName);
    }

    public void printActors() {
        System.out.println("Actors:");
        actors.printList();
    }
    
    public void addFilm(Film film){
    FilmNode newNode = new FilmNode(film);
    if(head==null){
    head=newNode;
    }
    else{
     
        FilmNode current = this.head;
        while(current.getNext()!= null){  
            current = current.getNext();
        }
        
        current.setNext(newNode);
        }
    
    }
  
  
    public void deleteFilm(String filmID){
      if(head==null){
          System.out.println("List is empty ! ");
      }
      else if(head.getFilm().getFilmID().equals(filmID)){ 
      head=head.getNext();
          System.out.println("Film with ID : " + filmID + "removed.");
      }
      
      else{
        FilmNode current = head;
        while(current.getNext()!= null){
            if(current.getNext().getFilm().equals(filmID)){
             current.setNext(current.getNext().getNext());
                System.out.println("Film with ID : " + filmID + "removed.");
            }
            current= current.getNext();
        }
        
        System.out.println("Film with ID: " + filmID + " not found."); 
      }
    }

    
    public void addReview(int rating, String comment, String reviewerName) {
    Review review = new Review(rating, comment, reviewerName);
    reviews.addReview(review);
    
    } 
    
    public void deleteReview(String reviewerName) {
    reviews.deleteReview(reviewerName);
    
    }
    
    public void printReviews() {
    System.out.println("Reviews for the film " + filmName + ":");
    reviews.printReviews();
    }



    public void addRevenue(double viewership, double ticketPrice) {
        if (historicalRevenue == null) {
            historicalRevenue = new HistoricalRevenue();
        }
        historicalRevenue.push(viewership, ticketPrice);
        updateTotalRevenue();
    }

    private void updateTotalRevenue() {
        double total = 0;
        RevenueNode current = historicalRevenue.top;

        while (current != null) {
            total += current.totalRevenue;
            current = current.next;
        }
        this.totalRevenue = total;
    }
    
    public void addImdb(double imdb) {
    if (filmScreening == null) {
        filmScreening = new FilmScreening();
    }
    filmScreening.enqueue((double) imdb);
    
}
  
  
  
  public void printBestFilm(){
      if(filmScreening == null || filmScreening.isEmpty()){
          System.out.println("no imdb data");
          return;
      }
      
      double maxImdb = Double.MIN_VALUE;
      FilmScreening temp = new FilmScreening();
      
      while(!filmScreening.isEmpty()){
          double imdb = filmScreening.dequeue();
          
          if (imdb > maxImdb) {
            maxImdb = imdb; 
        }
          temp.enqueue(imdb);
      }
      while (!temp.isEmpty()) {
          
        filmScreening.enqueue(temp.dequeue());
        
      }
      System.out.print("The best film is : " + filmName);
      System.out.println("  and film's imdb : " + maxImdb);
  }
      
  
}
