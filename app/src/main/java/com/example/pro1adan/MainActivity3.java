package com.example.pro1adan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.OnFailureListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    FirebaseFirestore db;
    EditText name,add,phoneNum,age;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn=findViewById(R.id.addbtn);
        name=findViewById(R.id.na);
        add=findViewById(R.id.addr);
        phoneNum=findViewById(R.id.phoneNum);
        age=findViewById(R.id.ageEd);
        db = FirebaseFirestore.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> client = new HashMap<>();
                client.put("Name", "Ahmad");
                client.put("Age", 25);
                client.put("Address", "Tamra");
                client.put("Phone", "0526485956");

                db.collection("Clients")
                        .add(client)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                            }
                        });
            }
        });

    }
}
