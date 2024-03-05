package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {
    private TextView logo;
    private TextView TextoEmail;
    private Button iniciar;
    private Button sair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextoEmail = findViewById(R.id.textEmailUser);

        // Recuperar o email do usuário logado como um extra
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("EMAIL")) {
            String email = intent.getStringExtra("EMAIL");
            // Exibir o email na TextView

            TextoEmail.setText(email);
        }

        // Botão iniciar expediente
        iniciar = findViewById(R.id.buttonIniciar);

        // Botão sair
        sair = findViewById(R.id.buttonSair);

        // Próxima página
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( home.this, cabecalho.class);
                startActivity(intent);
            }
        });

        // Voltar para tela anterior
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent( home.this, login.class);
                startActivity(intent2);
            }
        });
    }
}