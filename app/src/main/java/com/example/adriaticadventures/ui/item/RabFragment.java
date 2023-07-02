package com.example.adriaticadventures.ui.item;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.adriaticadventures.R;
import com.example.adriaticadventures.databinding.FragmentGalleryBinding;
import com.example.adriaticadventures.databinding.FragmentRab2Binding;

import com.example.adriaticadventures.ui.gallery.GalleryViewModel;

public class RabFragment extends Fragment {

    private RabViewModel mViewModel;
    private FragmentRab2Binding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentRab2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRab;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



        // Dodajte kod za gumb ovdje
        Button openBrowserButton = root.findViewById(R.id.btnkrk1);
        openBrowserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://shorturl.at/aejDV";  // Zamijenite s vašom željenom web stranicom

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        Button openBrowserButton2 = root.findViewById(R.id.btnkrk2);
        openBrowserButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.arriva.com.hr/hr-hr/naslovna";  // Zamijenite s vašom željenom web stranicom

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        Button openBrowserButton4 = root.findViewById(R.id.btnkrk4);
        openBrowserButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.jadrolinija.hr/";  // Zamijenite s vašom željenom web stranicom

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RabViewModel.class);
        // TODO: Use the ViewModel
    }

}