package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class login extends AppCompatActivity {
    private Button login;
    private EditText user;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.buttonSend);
        user = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginpassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Valores dos inputs
                String usuario = user.getText().toString();
                String senha = password.getText().toString();

                // Campos para setar as mensagens de erros
                EditText editTextEmail = findViewById(R.id.loginEmail);
                EditText editTextSenha = findViewById(R.id.loginpassword);

                // Verificar se o campo está vazio
                if (TextUtils.isEmpty(usuario)) {
                    // Se estiver vazio, exibir uma mensagem de erro
                    editTextEmail.setError("Campo Email é obrigatório");
                    return;
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(usuario).matches()) {
                    // Se não for do tipo email exibir uma mensagem de erro
                    editTextEmail.setError("Endereço de e-mail inválido");
                    return;
                }
                else if (TextUtils.isEmpty(senha)) {
                    // Se estiver vazio, exibir uma mensagem de erro
                    editTextSenha.setError("Campo Senha é obrigatório");
                }else{
                    // Redireciona para proxima tela
                    Intent intent6 = new Intent(login.this, home.class);
                    intent6.putExtra("EMAIL", usuario);
                    startActivity(intent6);
                }

            }
        });

    }

    // Gerando um menu

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }



}