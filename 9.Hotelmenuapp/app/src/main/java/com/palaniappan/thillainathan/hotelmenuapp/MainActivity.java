package com.palaniappan.thillainathan.hotelmenuapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    CheckBox pizza,burger,fries,role;
    TextView tv1,tv2;
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
        pizza=(CheckBox) findViewById(R.id.C1);
        burger=(CheckBox) findViewById(R.id.C2);
        fries=(CheckBox) findViewById(R.id.C3);
        role=(CheckBox) findViewById(R.id.C4);
        tv1=(TextView) findViewById(R.id.T1);
        tv2=(TextView) findViewById(R.id.T2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder s= new StringBuilder();
                s.append("The following items are order\n");
                int sum=0;
                if(pizza.isChecked()){
                    sum=sum+100;
                    s.append("The pizza : Rs 100\n");
                }
                if(burger.isChecked()){
                    sum=sum+120;
                    s.append("The Burger : Rs 120\n");
                }
                if(fries.isChecked()){
                    sum=sum+60;
                    s.append("The Fries : Rs60\n");
                }
                if(role.isChecked()){
                    sum=sum+130;
                    s.append("The Chicken Roles : Rs 130\n");
                }
                s.append("The total cost of the bill is "+sum);
                tv2.setText(s);
            }
        });
    }
}