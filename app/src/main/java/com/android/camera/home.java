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

        // Texto da Logo
        logo = findViewById(R.id.textLogo);



        // Email do usuario logado
        String email = "usuario@gmail.com";
        TextoEmail = findViewById(R.id.textEmailUser);
        TextoEmail.setText(email);

        // Botão iniciar expediente
        iniciar = findViewById(R.id.buttonIniciar);

        // Botão sair
        sair = findViewById(R.id.buttonSair);


        // Voltar para tela anterior
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( home.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}