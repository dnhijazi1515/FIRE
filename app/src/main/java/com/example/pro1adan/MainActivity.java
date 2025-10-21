package com.example.pro1adan;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText em,pass;

    Button btnsign,btnlog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                if (!android.util.Patterns.){
                    Toast.makeText(MainActivity.this,"fillout the info" ,Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }
}