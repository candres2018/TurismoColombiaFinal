package com.example.turismocolombia3.Interfaces;

import com.example.turismocolombia3.Modelos.Quipama;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface QuipamaApi {
    @GET
    Call<List<Quipama>> getQuipamaList(@Url String url);
}
