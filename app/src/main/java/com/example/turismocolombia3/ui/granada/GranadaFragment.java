package com.example.turismocolombia3.ui.granada;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.turismocolombia3.Interfaces.GranadaApi;
import com.example.turismocolombia3.MapFragment;
import com.example.turismocolombia3.Modelos.Granada;
import com.example.turismocolombia3.R;
import com.example.turismocolombia3.GranadaAdapter;

public class GranadaFragment extends Fragment {

    private Retrofit retrofit;
    private final  String logs = "---| ";

    private View root;
    private Bundle bundle;

    private RecyclerView recycler_granada;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_granada, container, false);
        bundle = savedInstanceState;

        // Enlazar el layout de mapa (contenedor) con un nuevo MapFragment
        getFragmentManager().beginTransaction().replace(R.id.map_container,
                new MapFragment(), "Map Fragment").commit();

        recycler_granada = root.findViewById(R.id.recycler_granada);
        recycler_granada.setHasFixedSize(true);

        LinearLayoutManager linear = new LinearLayoutManager(root.getContext());
        recycler_granada.setLayoutManager(linear);


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory
                        .create()).build();

        getData();


        return root;
    }
    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }

    private void getData() {
        try{

            GranadaApi service = retrofit.create(GranadaApi.class);

            Call<List<Granada>> GranadaResponseCall = service.getGranadaList("duek-cx94.json");

            GranadaResponseCall.enqueue(new Callback<List<Granada>>() {
                @Override
                public void onResponse(Call<List<Granada>> call, Response<List<Granada>> response) {
                    if(response.isSuccessful()){
                        List<Granada> granadas = response.body();
                        GranadaAdapter adapter = new GranadaAdapter(granadas);
                        recycler_granada.setAdapter(adapter);
                    } else {
                        Log.e(logs, "onResponse: "+response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<Granada>> call, Throwable t) {
                    Log.e(logs," onFailure: "+t.getStackTrace());
                }
            });

        }catch (Exception e){
            Log.e(logs, "onFailure: " + e);
        }

    }

}