package com.example.turismocolombia3.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GranadaResponse {
    @SerializedName("Granada")
    @Expose
    private List<Granada> granadas = null;

    public List<Granada> getGranadas() {
        return granadas;
    }

    public void setGranadas(List<Granada> granadas) {
        this.granadas = granadas;
    }
}
