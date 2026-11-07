package com.example.registreusuari;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_RESULTAT = 1;

    private EditText etNom, etCognoms, etEdat;
    private RadioButton rbSi, rbNo;
    private TextView tvPolitica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNom = findViewById(R.id.etNom);
        etCognoms = findViewById(R.id.etCognoms);
        etEdat = findViewById(R.id.etEdat);
        rbSi = findViewById(R.id.rbMatriculatSi);
        rbNo = findViewById(R.id.rbMatriculatNo);
        tvPolitica = findViewById(R.id.tvPolitica);

        Button btnMostrarInfo = findViewById(R.id.btnMostrarInfo);
        btnMostrarInfo.setOnClickListener(v -> mostrarInfo());
    }

    private void mostrarInfo() {
        String nom = etNom.getText().toString().trim();
        String cognom = etCognoms.getText().toString().trim();
        String edatText = etEdat.getText().toString().trim();

        if (nom.isEmpty()) {
            Toast.makeText(this, "No has introduït el teu nom!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cognom.isEmpty()) {
            Toast.makeText(this, "No has introduït els teus cognoms!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edatText.isEmpty()) {
            Toast.makeText(this, "No has introduït la teva edat!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!rbSi.isChecked() && !rbNo.isChecked()) {
            Toast.makeText(this, "No has marcat si estàs matriculat!", Toast.LENGTH_SHORT).show();
            return;
        }

        int edat;
        try {
            edat = Integer.parseInt(edatText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "L'edat ha de ser un número!", Toast.LENGTH_SHORT).show();
            return;
        }

        Persona p = new Persona(nom, cognom, edat, rbSi.isChecked());

        Intent i = new Intent(MainActivity.this, MainActivityResultat.class);
        i.putExtra("Persona", p);
        startActivityForResult(i, REQ_RESULTAT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            boolean acceptat = data.getBooleanExtra("acceptat", false);

            if (acceptat) {
                tvPolitica.setText("Has acceptat la política de confidencialitat");
            } else {
                tvPolitica.setText("No has acceptat la política de confidencialitat");
            }
        }
    }
}