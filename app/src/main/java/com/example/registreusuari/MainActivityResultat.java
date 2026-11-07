package com.example.registreusuari;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityResultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resultat);

        TextView tvNom = findViewById(R.id.tvResultatNom);
        TextView tvCognoms = findViewById(R.id.tvResultatCognoms);
        TextView tvEdat = findViewById(R.id.tvResultatEdat);
        TextView tvMatriculat = findViewById(R.id.tvResultatMatriculat);
        CheckBox cbPolitica = findViewById(R.id.cbPoliticaConfidencialitat);
        Button btnSortir = findViewById(R.id.btnTornar);

        Persona p = (Persona) getIntent().getSerializableExtra("Persona");

        if (p != null) {
            tvNom.setText(p.getNom());
            tvCognoms.setText(p.getCognom());
            tvEdat.setText(String.valueOf(p.getEdat()));

            if (p.isMatriculat()) {
                tvMatriculat.setText("Sí");
            } else {
                tvMatriculat.setText("No");
            }
        }

        btnSortir.setOnClickListener(v -> {
            Intent resposta = new Intent();
            resposta.putExtra("acceptat", cbPolitica.isChecked());
            setResult(RESULT_OK, resposta);
            finish();
        });
    }
}