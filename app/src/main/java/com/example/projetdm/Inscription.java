package com.example.projetdm;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Inscription extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextConfirmPassword;
    Spinner citySpinner;
    Button buttonCreateAccount;
    DataBaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        citySpinner = findViewById(R.id.city_spinner);
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);
        String[] villes = {"Agadir","Casablanca", "Rabat", "Fès", "Marrakech", "Tanger"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, villes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner.setAdapter(adapter);

        databaseHelper = new DataBaseHelper(this);

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmPassword = editTextConfirmPassword.getText().toString().trim();
                String city = citySpinner.getSelectedItem().toString().trim();

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(Inscription.this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || city.isEmpty()) {
                    Toast.makeText(Inscription.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                long result = databaseHelper.insertUser(email, password, city);

                if (result != -1) {
                    Toast.makeText(Inscription.this, "Compte créé avec succès", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Inscription.this, "Erreur lors de la création du compte", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
