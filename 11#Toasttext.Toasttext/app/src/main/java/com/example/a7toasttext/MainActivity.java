package com.example.a7toasttext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1;
        TextView T1;
        b1=(Button) findViewById(R.id.b1);
        T1=(TextView) findViewById(R.id.e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st=T1.getText().toString();
               Toast.makeText(MainActivity.this,"welcome"+" "+st +" to my class", Toast.LENGTH_SHORT).show();
            }
        });
    }
}