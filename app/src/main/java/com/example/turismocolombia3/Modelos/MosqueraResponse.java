package com.example.turismocolombia3.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MosqueraResponse {
    @SerializedName("Mosquera")
    @Expose
    private List<Mosquera> mosqueras = null;

    public List<Mosquera> getMosqueras() {
        return mosqueras;
    }

    public void setMosqueras(List<Mosquera> mosqueras) {
        this.mosqueras = mosqueras;
    }
}
