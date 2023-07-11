package com.example.adriaticadventures.ui.forumcres;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adriaticadventures.R;
import com.example.adriaticadventures.ui.forumkrk.ForumKrk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ForumCres extends Fragment {

    private EditText reviewEditText;
    private TextView reviewTextView;
    private Button submitButton;

    private FirebaseFirestore db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicijalizacija referenci na Firebase Firestore bazu podataka
        db = FirebaseFirestore.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_cres, container, false);

        // Inicijalizacija UI elemenata
        reviewEditText = view.findViewById(R.id.reviewEditText);
        reviewTextView = view.findViewById(R.id.reviewTextView);
        submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitReview();
            }
        });

        // Prikaz podataka iz Firestore baze podataka
        displayData();

        return view;
    }

    private void submitReview() {
        String reviewText = reviewEditText.getText().toString().trim();

        // Provjera da li je recenzija unesena
        if (!reviewText.isEmpty()) {
            // Spremanje recenzije u Firebase Firestore bazu podataka
            db.collection("recenzijecres")
                    .add(new ForumKrk.Review(reviewText))
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            // Resetiranje polja za unos recenzije
                            reviewEditText.setText("");

                            // Prikaz poruke o uspješnom spremanju recenzije
                            Toast.makeText(getActivity(), "Recenzija je uspješno spremljena.", Toast.LENGTH_SHORT).show();

                            // Ponovno prikazivanje podataka
                            displayData();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Greška prilikom spremanja recenzije
                            Toast.makeText(getActivity(), "Greška pri spremanju recenzije.", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void displayData() {
        // Dohvaćanje podataka iz Firestore baze podataka
        db.collection("recenzijecres")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            StringBuilder reviewTextBuilder = new StringBuilder();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String reviewText = document.getString("text");
                                reviewTextBuilder.append("• ").append(reviewText).append("\n");
                            }

                            // Prikaz podataka u TextView elementu
                            reviewTextView.setText(reviewTextBuilder.toString());
                        } else {
                            // Greška prilikom dohvaćanja podataka
                            reviewTextView.setText("Greška prilikom dohvaćanja podataka");
                        }
                    }
                });
    }


    private static class Review {
        private String text;

        public Review(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
