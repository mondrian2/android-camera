package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class endereco extends AppCompatActivity {
    private static final String PREFS_NAME = "Myadress";
    private Spinner spinnerStatus;

    private Spinner spinnerTipoImovel;

    private Button continuar;

    private EditText endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        endereco = findViewById(R.id.endereco);
        spinnerStatus = findViewById(R.id.spinnerStatusVisita);
        spinnerTipoImovel =findViewById(R.id.spinnerTipoImovel);

        // Criando botao de continuar
        continuar = findViewById(R.id.buttonContinue);

        // Crie um ArrayAdapter usando um array de strings e um layout de spinner padrão
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.statusVisita_options, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> imoveisAdapter = ArrayAdapter.createFromResource(this,
                R.array.tipoImovel_options, android.R.layout.simple_spinner_item);

        // Especifica o layout a ser usado quando a lista de opções aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        imoveisAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicar o adaptador ao spinner
        spinnerStatus.setAdapter(adapter);
        spinnerTipoImovel.setAdapter(imoveisAdapter);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }

    private void validate(){
        // Valores dos inputs
        String adress = endereco.getText().toString();

        // Verificar se o campo está vázio
        if(TextUtils.isEmpty(adress)) {
            // Se estiver vázio, exibir uma mensagem de erro
            endereco.setError("Campo Endereco é obrigatório");
            return;
        }else{
            // salva dados

            saveStorage();
            // Redireciona para proxima tela
            Intent intent6 = new Intent(endereco.this, deposito.class);
            startActivity(intent6);
        }
    }
    private void saveStorage(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String status = (String) spinnerStatus.getSelectedItem();
        String type = (String) spinnerTipoImovel.getSelectedItem();

        // Salvar os dados quando o botão for clicado
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("adress", endereco.getText().toString());

        editor.apply();

        // Exemplo de exibição dos dados em um Toast
        String messageAdress =
                "adress: " + endereco.getText().toString() + "\n"+
                "status: " + status.toString() + "\n"+
                "type: " + type.toString() +"\n";
        Toast.makeText(this, messageAdress, Toast.LENGTH_LONG).show();

    }
}