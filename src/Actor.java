package com.mycompany.filmmanagement;


public class Actor {
    private String  actorName;
    private String actorID;
    private LinkedList <String> filmsParticipated;
    private ActorNode head;

    public Actor(String actorName, String actorID, LinkedList<String> filmsParticipated) {
        this.actorName = actorName;
        this.actorID = actorID;
        this.filmsParticipated = filmsParticipated;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorID() {
        return actorID;
    }

    public void setActorID(String actorID) {
        this.actorID = actorID;
    }

    public LinkedList<String> getFilmsParticipated() {
        return filmsParticipated;
    }

    public void setFilmsParticipated(LinkedList<String> filmsParticipated) {
        this.filmsParticipated = filmsParticipated;
    }
    
    
   
  public void addActor(Actor actor){
  ActorNode newNode = new ActorNode(actor);
  if(head==null){
      head = newNode;
  }
  
  else{
    ActorNode current = head;  
    while(current.getNext() != null){
    current= current.getNext();
    }
   current.setNext(newNode);
  }
 
  }  
  
  
  public void deleteActor(String actorID){
  if(head==null){
      System.out.println("List is empty !");
  }
  
  else if(head.getActor().getActorID().equals(actorID)){
     head=head.getNext();
      System.out.println("Actor with ID : " + actorID + "removed."); 
  }
  
  else{
      ActorNode current = head;
      while(head.getNext() != null){
          if(current.getActor().getActorID().equals(actorID)){
          current.setNext(current.getNext().getNext());
          System.out.println("Actor with ID: " + actorID + " removed.");;;
          }
          
      }
      current=current.getNext();
  }
     
    System.out.println("Actor with ID: " +actorID + " not found.");
    
  }   
}
