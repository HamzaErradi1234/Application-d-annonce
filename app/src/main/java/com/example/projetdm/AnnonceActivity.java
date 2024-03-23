package com.example.projetdm;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AnnonceActivity extends AppCompatActivity {

    EditText editTextTitre, editTextTypeContrat, editTextDescription;
    Spinner spinnerCategorie, spinnerSecteur, spinnerVille;
    Button buttonSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialisation des vues
        editTextTitre = findViewById(R.id.editTextTitre);
        editTextTypeContrat = findViewById(R.id.editTextTypeContrat);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerCategorie = findViewById(R.id.spinnerCategorie);
        spinnerSecteur = findViewById(R.id.spinnerSecteur);
        spinnerVille = findViewById(R.id.spinnerVille);
        buttonSuivant = findViewById(R.id.buttonSuivant);

        // Remplir les spinners avec des données fictives
        remplirSpinnerCategorie();
        remplirSpinnerSecteur();
        remplirSpinnerVille();

        // Action lorsque le bouton "Suivant" est cliqué
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titre = editTextTitre.getText().toString();
                String typeContrat = editTextTypeContrat.getText().toString();
                String description = editTextDescription.getText().toString();
                String categorie = spinnerCategorie.getSelectedItem().toString();
                String secteur = spinnerSecteur.getSelectedItem().toString();
                String ville = spinnerVille.getSelectedItem().toString();

                Intent intent = new Intent(AnnonceActivity.this, message.class);
                intent.putExtra("titre", titre);
                intent.putExtra("typeContrat", typeContrat);
                intent.putExtra("description", description);
                intent.putExtra("categorie", categorie);
                intent.putExtra("secteur", secteur);
                intent.putExtra("ville", ville);
                startActivity(intent);
            }
        });
    }

    private void remplirSpinnerCategorie() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorie.setAdapter(adapter);
    }
    private void remplirSpinnerSecteur() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sectors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecteur.setAdapter(adapter);
    }
    private void remplirSpinnerVille() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVille.setAdapter(adapter);
    }
}
