package com.example.apptrochuyenv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView MessagesRecyclerView;
    private String email, name;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://apptrochuyen-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get intent data from Register
        email = getIntent().getStringExtra("email");
        name = getIntent().getStringExtra("name");
        //init view
        MessagesRecyclerView = findViewById(R.id.MessagesRecyclerView);
        MessagesRecyclerView.setHasFixedSize(true);
        MessagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //get profile pic from firebase
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String profilePic = snapshot.child("Users").child(email).child("profilePic").getValue(String.class);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}