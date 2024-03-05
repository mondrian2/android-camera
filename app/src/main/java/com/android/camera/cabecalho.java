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
import android.widget.Toast;

public class cabecalho extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefsFile";
    private Button iniciarInspedicao;
    private EditText editTextWeek;
    private EditText editTextCity;
    private EditText editTextState;
    private EditText editTextLocality;
    private EditText editTextSubLocality;
    private EditText editTextZone;
    private EditText editTextProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabecalho);

        editTextWeek = findViewById(R.id.week);
        editTextCity = findViewById(R.id.city);
        editTextState = findViewById(R.id.state);
        editTextLocality = findViewById(R.id.locality);
        editTextSubLocality = findViewById(R.id.sublocality);
        editTextZone = findViewById(R.id.zone);
        editTextProducts = findViewById(R.id.products);

        iniciarInspedicao = findViewById(R.id.buttonSend);

        iniciarInspedicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validar();
            }
        });
    }


    // Salvar os dados no strage
    private void saveStorage(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("week", editTextWeek.getText().toString());
        editor.putString("city", editTextCity.getText().toString());
        editor.putString("state", editTextState.getText().toString());
        editor.putString("locality", editTextLocality.getText().toString());
        editor.putString("subLocality", editTextSubLocality.getText().toString());
        editor.putString("zone", editTextZone.getText().toString());
        editor.putString("products", editTextProducts.getText().toString());
        editor.apply();

        saveFormData();

        // ir para próxima tela

        Intent intent = new Intent( cabecalho.this, inspecao.class);
        startActivity(intent);

    }

    // Gera Mensagem na tela com os dados dos unputs
    private void saveFormData() {
        String week = editTextWeek.getText().toString();
        String city = editTextCity.getText().toString();
        String state = editTextState.getText().toString();
        String locality = editTextLocality.getText().toString();
        String subLocality = editTextSubLocality.getText().toString();
        String zone = editTextZone.getText().toString();
        String products = editTextProducts.getText().toString();

        // Aqui você pode implementar a lógica para salvar os dados, por exemplo, em um banco de dados ou em um arquivo

        // Exemplo de exibição dos dados em um Toast
        String message = "Semana: " + week + "\n" +
                "Cidade: " + city + "\n" +
                "Estado: " + state + "\n" +
                "Localidade: " + locality + "\n" +
                "Sublocalidade: " + subLocality + "\n" +
                "Zona: " + zone + "\n" +
                "Produtos: " + products;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    private void Validar(){
        // Valores dos inputs
        String week = editTextWeek.getText().toString();
        String city = editTextCity.getText().toString();
        String state = editTextState.getText().toString();
        String locality =editTextLocality.getText().toString();
        String sublocality = editTextSubLocality.getText().toString();
        String zone = editTextZone.getText().toString();
        String products = editTextProducts.getText().toString();

        // Verificar se o campo está vázio
                if(TextUtils.isEmpty(week)) {
                    // Se estiver vázio, exibir uma mensagem de erro
                    editTextWeek.setError("Campo Semana é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(city)) {
                    editTextCity.setError("Campo Cidade é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(state)) {
                    editTextState.setError("Campo Estado é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(locality)) {
                   editTextLocality.setError("Campo Localidade é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(sublocality)) {
                    editTextSubLocality.setError("Campo Sublocalidade é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(zone)) {
                    editTextZone.setError("Campo Zona é obrigatório");
                    return;
                }else if (TextUtils.isEmpty(products)) {
                    editTextProducts.setError("Campo Produtos é obrigatório");
                    return;
                }else{
                    // salva dados

                    saveStorage();
                    // Redireciona para proxima tela
                    Intent intent4 = new Intent( cabecalho.this, inspecao.class);
                    startActivity(intent4);
                }
    }

}