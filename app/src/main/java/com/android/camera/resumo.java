package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class resumo extends AppCompatActivity {

    private Button continuarResumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);


        continuarResumo = findViewById(R.id.buttonContinueResume);


        continuarResumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(resumo.this, observacoes.class);
                startActivity(intent8);
            }
        });
    }
}