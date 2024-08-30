package com.palaniappan.thillainathan.sumftwnumbers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
   EditText ET1,ET2;
   Button btn;
   TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn=(Button) findViewById(R.id.B1);
        tv=(TextView) findViewById(R.id.T1);
        ET1=(EditText) findViewById(R.id.E1);
        ET2=(EditText) findViewById(R.id.E2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=ET1.getText().toString();
                String b=ET2.getText().toString();
                int i=Integer.parseInt(a);
                int j=Integer.parseInt(b);
                int sum=i+j;
                tv.setText(""+sum);
            }
        });
    }
}