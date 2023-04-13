package com.example.apptrochuyenv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    private EditText edtName, edtEmail;
    private Button btnRegister;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://apptrochuyen-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                if (name.isEmpty() || email.isEmpty()) {
                    edtName.setError("Please enter your name");
                    edtEmail.setError("Please enter your email");
                } else {
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.child("Users").child(email).exists()) {
                                Toast.makeText(Register.this, "Email already exists!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("Users").child(email).child("name").setValue(name);
                                databaseReference.child("Users").child(email).child("email").setValue(email);
                                Toast.makeText(Register.this, "Register successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, MainActivity.class);
                                intent.putExtra("email", email);
                                intent.putExtra("name", name);
                                startActivity(intent);
                                finish();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                }
            }

        });
    }
}