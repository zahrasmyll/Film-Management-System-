package com.mycompany.filmmanagement;


public class FilmNode {
    private Film film; 
private FilmNode next;

    public FilmNode(Film film) {
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmNode getNext() {
        return next;
    }

    public void setNext(FilmNode next) {
        this.next = next;
    }

}
