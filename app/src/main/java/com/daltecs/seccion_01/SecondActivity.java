package com.daltecs.seccion_01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {


    private TextView textView;
    private Button ButtonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_activity);

        textView = (TextView) findViewById(R.id.textViewMain);
        ButtonNext = (Button) findViewById(R.id.buttonGoSharing);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getString("greeter" )!=null){
            String greeter = bundle.getString("greeter");
            Toast.makeText(SecondActivity.this, greeter,Toast.LENGTH_LONG).show();
            textView.setText(greeter);
        }
        else{
            Toast.makeText(SecondActivity.this,"It is empty!", Toast.LENGTH_LONG ).show();
        }

        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}