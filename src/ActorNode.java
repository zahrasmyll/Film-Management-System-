package com.mycompany.filmmanagement;


public class ActorNode {
    private Actor actor;
private ActorNode next;



    public ActorNode(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public ActorNode getNext() {
        return next;
    }

    public void setNext(ActorNode next) {
        this.next = next;
    }


}
