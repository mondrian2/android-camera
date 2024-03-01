package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class endereco extends AppCompatActivity {
    private Spinner spinnerStatus;

    private Spinner spinnerTipoImovel;

    private Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        spinnerStatus = findViewById(R.id.spinnerStatusVisita);
        spinnerTipoImovel =findViewById(R.id.spinnerTipoImovel);
        continuar = findViewById(R.id.buttonContinue);

        // Crie um ArrayAdapter usando um array de strings e um layout de spinner padrão
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.statusVisita_options, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> imoveisAdapter = ArrayAdapter.createFromResource(this,
                R.array.tipoImovel_options, android.R.layout.simple_spinner_item);

        // Especifique o layout a ser usado quando a lista de opções aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        imoveisAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicar o adaptador ao spinner
        spinnerStatus.setAdapter(adapter);
        spinnerTipoImovel.setAdapter(imoveisAdapter);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(endereco.this, deposito.class);
                startActivity(intent6);
            }
        });

    }


}