package com.acasema.wikiweeb.data.modelos;


import java.io.Serializable;

public class Review implements Serializable, Items {
    public static final String TAG = "review";

    private Articulo articulo;
    private Usuario usuario;
    private int puntuacion;
    private String opinion;

    //region get-set
    public Articulo getArticulo() {
        return articulo;
    }
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getopinion() {
        return opinion;
    }
    public void setopinion(String descripcion) {
        this.opinion = descripcion;
    }
    //endregion
    //region constructor
    public Review(Articulo articulo, Usuario usuario, int puntuacion, String descripcion) {
        this.articulo = articulo;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.opinion = descripcion;
    }
    public Review() {}
    //endregion
    //region Items interface
    @Override
    public String getTitulo() {
        return articulo.toString();
    }

    @Override
    public String getPreview(int lagoMaxsimo) {
        if(opinion.length()<= lagoMaxsimo )
            return  opinion;
        return opinion.substring(0, lagoMaxsimo)+" ...";
    }

    @Override
    public String getLetraPk() {
        return usuario.getNombre() + " . puntuacion "+ puntuacion;
    }
    //endregion

}
