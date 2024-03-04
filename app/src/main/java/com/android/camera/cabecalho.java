package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

        // Local dos campos
        EditText semana = findViewById(R.id.week);
        EditText cidade = findViewById(R.id.city);
        EditText estado = findViewById(R.id.state);
        EditText localidade = findViewById(R.id.locality);
        EditText sublocalidade = findViewById(R.id.sublocality);
        EditText zona = findViewById(R.id.zone);
        EditText produtos = findViewById(R.id.products);

        iniciarInspedicao =  findViewById(R.id.buttonSend);

        // Valores dos inputs
        String week = semana.getText().toString();
        String city = cidade.getText().toString();
        String state = estado.getText().toString();
        String locality = localidade.getText().toString();
        String sublocality = sublocalidade.getText().toString();
        String zone = zona.getText().toString();
        String products = produtos.getText().toString();


        // Ir para a próxima tela
        iniciarInspedicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Redireciona para proxima tela
                Intent intent4 = new Intent( cabecalho.this, inspecao.class);
                startActivity(intent4);

                // Verificar se o campo está vazio
//                if(TextUtils.isEmpty(week)) {
//                    // Se estiver vázio, exibir uma mensagem de erro
//                    semana.setError("Campo Semana é obrigatório");
//                    return;
//                }else if (TextUtils.isEmpty(city)) {
//                    cidade.setError("Campo Cidade é obrigatório");
//                    return;
//                }else if (TextUtils.isEmpty(state)) {
//                    estado.setError("Campo Estado é obrigatório");
//                    return;
//                }else if (TextUtils.isEmpty(locality)) {
//                    localidade.setError("Campo Localidade é obrigatório");
//                    return;
//                }else if (TextUtils.isEmpty(sublocality)) {
//                    sublocalidade.setError("Campo Sublocalidade é obrigatório");
//                    return;
//                }else if (TextUtils.isEmpty(zone)) {
//                    zona.setError("Campo Zona é obrigatório");
//                    return;
//                }else if (TextUtils.isEmpty(products)) {
//                    produtos.setError("Campo Produtos é obrigatório");
//                    return;
//                }else{
//                    // Redireciona para proxima tela
//                    Intent intent4 = new Intent( cabecalho.this, inspecao.class);
//                    startActivity(intent4);
//                }

            }
        });

    }

}