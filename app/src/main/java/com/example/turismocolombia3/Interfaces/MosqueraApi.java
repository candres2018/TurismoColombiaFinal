package com.example.turismocolombia3.Interfaces;
import com.example.turismocolombia3.Modelos.Mosquera;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface MosqueraApi {
    @GET
    Call<List<Mosquera>> getMosqueraList(@Url String url);
}
