package com.example.turismocolombia3.ui.acerca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.turismocolombia3.R;
import com.squareup.picasso.Picasso;

public class AcercaFragment extends Fragment {


    private AcercaViewModel galleryViewModel;
    private Button btn_volver;
    private ImageView foto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(AcercaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_acerca, container, false);

        btn_volver = root.findViewById(R.id.btn_volver);

        foto = root.findViewById(R.id.img_andres);
        String url = "https://narino.info/wp-content/uploads/2018/02/turismo.jpg";

        Picasso.get()
                .load(url)
                .into(foto);

        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                Class fragmentclass=AcercaFragment.class;
                try{
                    fragment = (Fragment) fragmentclass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });

        return root;
}
}