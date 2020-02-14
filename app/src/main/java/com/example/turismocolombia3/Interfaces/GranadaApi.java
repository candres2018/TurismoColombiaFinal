package com.example.turismocolombia3.Interfaces;

import com.example.turismocolombia3.Modelos.Granada;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GranadaApi {
    @GET
    Call<List<Granada>> getGranadaList(@Url String url);
}
