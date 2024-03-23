package com.example.projetdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.equals("hamzaerr.03ham@gmail.com") && password.equals("abcdefg1234")) {

                    Intent intent = new Intent(MainActivity.this, AnnonceActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, Inscription.class);
        startActivity(intent);
    }

}
