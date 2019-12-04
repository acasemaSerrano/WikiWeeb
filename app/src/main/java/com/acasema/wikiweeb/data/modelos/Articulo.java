package com.acasema.wikiweeb.data.modelos;

import androidx.annotation.NonNull;

import java.util.List;

public class Articulo {

    private String nombre;
    private Tipo tipo;
    private String sinopsis;
    private List<Etiqueta> etiqueta;

    //region constructores
    public Articulo(String nombre, Tipo tipo, String sinopsis, List<Etiqueta> etiqueta) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.sinopsis = sinopsis;
        this.etiqueta = etiqueta;
    }

    public  Articulo(){}
    //endregion
    //region set-get
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<Etiqueta> getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(List<Etiqueta> etiqueta) {
        this.etiqueta = etiqueta;
    }
    //endregion


    @NonNull
    @Override
    public String toString() {
        return nombre + " " + tipo.toString();
    }
}
