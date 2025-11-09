package com.example.pro1adan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText em,pass;
    FirebaseAuth auth;
    Button btnsign,btnlog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        em=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        btnlog=findViewById(R.id.log);
        btnsign=findViewById(R.id.sign);
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String email=em.getText().toString().trim();
             String pas=pass.getText().toString().trim();
             if (email.isEmpty()|| pas.isEmpty()){
                 Toast.makeText(MainActivity.this,"fillout the info" ,Toast.LENGTH_SHORT).show();
                 return;
             }
                if (pas.length() < 6){
                    Toast.makeText(MainActivity.this,"password is short (must be longer then 6)" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this,"Invalid email format" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email,pas)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                            public void onComplete(@NonNull Task<AuthResult> task){
                                if(task.isSuccessful()){
                                    Toast.makeText(MainActivity.this,"Signed up successfuly",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Signed up failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=em.getText().toString().trim();
                String pas=pass.getText().toString().trim();
                if (email.isEmpty()|| pas.isEmpty()){
                    Toast.makeText(MainActivity.this,"fillout the info" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pas.length() < 6){
                    Toast.makeText(MainActivity.this,"password is short (must be longer then 6)" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this,"Invalid email format" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,pas)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                            public void onComplete(@NonNull Task<AuthResult> task){
                                if(task.isSuccessful()){
                                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                                    startActivity(intent);
                                    Toast.makeText(MainActivity.this,"Logged in successfuly",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Log in failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}