package com.example.turismocolombia3.ui.mosquera;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.turismocolombia3.Interfaces.MosqueraApi;
import com.example.turismocolombia3.MapFragment;
import com.example.turismocolombia3.Modelos.Mosquera;
import com.example.turismocolombia3.MosqueraAdapter;
import com.example.turismocolombia3.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MosqueraFragment extends Fragment {

    private Retrofit retrofit;
    private final  String logs = "---| ";

    private View root;
    private Bundle bundle;

    private RecyclerView recycler;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_mosquera, container, false);
        bundle = savedInstanceState;

        // Enlazar el layout de mapa (contenedor) con un nuevo MapFragment
        getFragmentManager().beginTransaction().replace(R.id.map_container,
                new MapFragment(), "Map Fragment").commit();

        recycler = root.findViewById(R.id.recycler_mosquera);
        recycler.setHasFixedSize(true);

        LinearLayoutManager linear = new LinearLayoutManager(root.getContext());
        recycler.setLayoutManager(linear);

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

            MosqueraApi service = retrofit.create(MosqueraApi.class);
            Call<List<Mosquera>> MosqueraTResponseCall = service.getMosqueraList("yf8m-7cq5.json");

            MosqueraTResponseCall.enqueue(new Callback<List<Mosquera>>() {
                @Override
                public void onResponse(Call<List<Mosquera>> call, Response<List<Mosquera>> response) {
                    if(response.isSuccessful()){
                        List<Mosquera> mosqueras = response.body();
                        MosqueraAdapter adapter = new MosqueraAdapter(mosqueras);
                        recycler.setAdapter(adapter);
                    } else {
                        Log.e(logs, "onResponse: "+response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<Mosquera>> call, Throwable t) {
                    Log.e(logs," onFailure: "+t.getStackTrace());
                }
            });

        }catch (Exception e){
            Log.e(logs, "onFailure: " + e);
        }

    }
}