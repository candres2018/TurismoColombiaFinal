package com.example.turismocolombia3.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuipamaResponse {
    @SerializedName("Quipama")
    @Expose
    private List<Quipama> quipamas = null;

    public List<Quipama> getQuipamas() {
        return quipamas;
    }

    public void setQuipamas(List<Quipama> quipamas) {
        this.quipamas = quipamas;
    }
}
