package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class observacoes extends AppCompatActivity {
    private Button encerrarInspecao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observacoes);

        encerrarInspecao = findViewById(R.id.buttonCloseInspection);

        encerrarInspecao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(observacoes.this, inspecao.class);
                startActivity(intent6);
            }
        });
    }

}