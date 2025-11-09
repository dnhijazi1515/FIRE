package com.example.pro1adan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
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
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main3);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        btn=findViewById(R.id.addbtn);
        name=findViewById(R.id.na);
        add=findViewById(R.id.addr);
        phoneNum=findViewById(R.id.phoneNum);
        age=findViewById(R.id.ageEd);
        db = FirebaseFirestore.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String age1=age.getText().toString();
                String address=add.getText().toString();
                String phone=phoneNum.getText().toString();
                Map<String, Object> client = new HashMap<>();
                client.put("Name", name1);
                client.put("Age", age1);
                client.put("Address", address);
                client.put("Phone", phone);

                db.collection("Clients")
                        .add(client)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(MainActivity3.this, "success", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity3.this, "not success", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}
