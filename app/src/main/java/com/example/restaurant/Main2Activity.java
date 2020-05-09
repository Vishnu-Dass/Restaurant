package com.example.restaurant;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;


import com.example.restaurant.ui.Note;
import com.example.restaurant.ui.NoteAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.Query;


import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Main2Activity extends AppCompatActivity {

    private  FirebaseFirestore db = FirebaseFirestore.getInstance();
    private  CollectionReference notebookRef = db.collection("Restaurant");
    private NoteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setUpRecyclerView();


    }
    private  void setUpRecyclerView(){


        Query query = notebookRef.orderBy("title" , Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Note> options = new  FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class)

                .build();

        adapter = new NoteAdapter(options);




     RecyclerView recyclerView = findViewById(R.id.recyclerView);

     recyclerView.setHasFixedSize(true);
     recyclerView.setLayoutManager(new LinearLayoutManager(this));
     recyclerView.setAdapter(adapter);
    }





    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void clickAccount(View view) {
        Intent myIntent = new Intent(this, Settings.class);
        startActivity(myIntent);
    }

    public void clickSort(View view) {
        Intent myIntent = new Intent(this, Sorting.class);
        startActivity(myIntent);


    }


}

