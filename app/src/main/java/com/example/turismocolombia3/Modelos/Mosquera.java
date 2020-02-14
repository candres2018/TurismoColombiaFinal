package com.example.turismocolombia3.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mosquera {

    @SerializedName("sitios_turisticos")
    @Expose
    private String sitios_turisticos;
    @SerializedName("descripci_n")
    @Expose
    private String descripci_n;
    @SerializedName("ubicacion")
    @Expose
    private String ubicacion;
    @SerializedName("imagen")
    @Expose
    private String imagen;


    public Mosquera(String sitios_turisticos,
                    String descripci_n,
                    String ubicacion,
                    String imagen)

    {
        super();
        this.sitios_turisticos=sitios_turisticos;
        this.descripci_n=descripci_n;
        this.ubicacion=ubicacion;
        this.imagen=imagen;

    }

    public String getSitios_turisticos() {
        return sitios_turisticos;
    }

    public void setSitios_turisticos(String sitios_turisticos) {
        this.sitios_turisticos = sitios_turisticos;
    }

    public String getDescripci_n() {
        return descripci_n;
    }

    public void setDescripci_n(String descripci_n) {
        this.descripci_n = descripci_n;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
