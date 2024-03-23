package com.example.projetdm;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_message);

        Intent intent = getIntent();
        String ville = intent.getStringExtra("ville");


        TextView textViewMessage = findViewById(R.id.message_text);
        textViewMessage.setText("Il y'a actuellement 20 sur " + ville);
    }
}
