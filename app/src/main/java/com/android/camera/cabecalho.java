package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cabecalho extends AppCompatActivity {

    private Button iniciarInspedicao;

    private EditText semana;
    private EditText cidade;
    private EditText estado;
    private EditText localidade;
    private EditText sublocalidade;
    private EditText zona;
    private EditText produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabecalho);

        semana = findViewById(R.id.week);
        cidade = findViewById(R.id.city);
        estado = findViewById(R.id.state);
        localidade = findViewById(R.id.locality);
        sublocalidade = findViewById(R.id.sublocality);
        zona = findViewById(R.id.zone);
        produtos = findViewById(R.id.products);

        iniciarInspedicao =  findViewById(R.id.buttonSend);


        // Voltar para tela anterior
        iniciarInspedicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent( cabecalho.this, inspecao.class);
                startActivity(intent4);
            }
        });

    }

}