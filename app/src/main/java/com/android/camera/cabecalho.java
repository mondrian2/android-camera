package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cabecalho extends AppCompatActivity {

    private Button iniciarInspedicao;
    private EditText semana;
    private EditText cidade;
    private EditText estado;
    private EditText localidade;
    private EditText sublocalidade;
    private EditText zona;
    private EditText produtos;

    private TextView TexteObjeto;

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

        // Valores dos inputs
        String week = semana.getText().toString();
        String city = cidade.getText().toString();
        String state = estado.getText().toString();
        String locality = localidade.getText().toString();
        String sublocality = sublocalidade.getText().toString();
        String zone = zona.getText().toString();
        String products = produtos.getText().toString();

        iniciarInspedicao =  findViewById(R.id.buttonSend);

        // Ir para a próxima tela
        iniciarInspedicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validar();
                // salvarDadosFormulario();

                // Redireciona para proxima tela
                Intent intent4 = new Intent( cabecalho.this, inspecao.class);
                startActivity(intent4);
            }
        });
    }

    private void Validar(){
        // Valores dos inputs
        String week = semana.getText().toString();
        String city = cidade.getText().toString();
        String state = estado.getText().toString();
        String locality = localidade.getText().toString();
        String sublocality = sublocalidade.getText().toString();
        String zone = zona.getText().toString();
        String products = produtos.getText().toString();

        // Verificar se o campo está vázio
                if(TextUtils.isEmpty(week)) {
                    // Se estiver vázio, exibir uma mensagem de erro
                    semana.setError("Campo Semana é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(city)) {
                    cidade.setError("Campo Cidade é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(state)) {
                    estado.setError("Campo Estado é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(locality)) {
                    localidade.setError("Campo Localidade é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(sublocality)) {
                    sublocalidade.setError("Campo Sublocalidade é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(zone)) {
                    zona.setError("Campo Zona é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(products)) {
                    produtos.setError("Campo Produtos é obrigatório");
                    return;
                }else{
                    // salva dados
                    salvarDadosFormulario();

                    // Redireciona para proxima tela
                    Intent intent4 = new Intent( cabecalho.this, inspecao.class);
                    startActivity(intent4);
                }
    }

    // Método para salvar os dados do formulário
    private void salvarDadosFormulario() {

        // Valores dos inputs
        String week = semana.getText().toString();
        String city = cidade.getText().toString();
        String state = estado.getText().toString();
        String locality = localidade.getText().toString();
        String sublocality = sublocalidade.getText().toString();
        String zone = zona.getText().toString();
        String products = produtos.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("MeuSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("week", week);
        editor.putString("city", city);
        editor.putString("state", state);
        editor.putString("locality", locality);
        editor.putString("sublocality", sublocality);
        editor.putString("zone", zone);
        editor.putString("products", products);
        editor.apply();
    }

}