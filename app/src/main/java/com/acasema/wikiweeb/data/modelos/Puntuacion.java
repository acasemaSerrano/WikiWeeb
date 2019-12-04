package com.acasema.wikiweeb.data.modelos;

public class Puntuacion {
    private Usuario usuario;
    private Review review;
    private int puntuacion;

    public Puntuacion(Usuario usuario, Review resenia, int puntuacion) {
        this.usuario = usuario;
        this.review = resenia;
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Review getReview() {
        return review;
    }
    public void setReview(Review review) {
        this.review = review;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

}
