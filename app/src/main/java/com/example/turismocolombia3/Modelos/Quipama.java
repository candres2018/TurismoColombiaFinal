package com.example.turismocolombia3.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quipama {

    @SerializedName("nombre_sitio")
    @Expose
    private String nombre_sitio;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("lugar")
    @Expose
    private String lugar;
    @SerializedName("imagen")
    @Expose
    private String imagen;


    public Quipama(String nombre_del_sitio_turistico,
                   String descripcion,
                   String lugar,
                   String imagen)

    {
        super();
        this.nombre_sitio=nombre_sitio;
        this.descripcion=descripcion;
        this.lugar=lugar;
        this.imagen=imagen;
    }

    public String getNombre_sitio() {
        return nombre_sitio;
    }

    public void setNombre_sitio(String nombre_sitio) {
        this.nombre_sitio = nombre_sitio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
