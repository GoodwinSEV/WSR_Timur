package com.example.wsr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieActivity extends AppCompatActivity {
    TextView text_plus;
    ImageView btn_back_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);

        text_plus = findViewById(R.id.text_plus);
        switch (text_plus.getText().toString()){
            case "18+":
                text_plus.setTextColor(getColor(R.color.plus_18));
                break;
            case "16+":
                text_plus.setTextColor(getColor(R.color.plus_16));
                break;
            case "12+":
                text_plus.setTextColor(getColor(R.color.plus_12));
                break;
            case "6+":
                text_plus.setTextColor(getColor(R.color.plus_6));
                break;
            case "0+":
                text_plus.setTextColor(getColor(R.color.plus_0));
                break;
        }

        btn_back_main = findViewById(R.id.btn_back_main);
        btn_back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
