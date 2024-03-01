package com.android.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                Intent intent6 = new Intent(login.this, home.class);
                startActivity(intent6);
            }
        });

    }

    // Gerando um menu

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    // Verificando qual botão do menu foi clicado
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.menu_voltar:
//                // Ação quando o Item de voltar é selecionado
//                Toast.makeText(login.this, "Item Voltar", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.menu_aumentar:
//                // Ação quando o Item 2 é selecionado
//                Toast.makeText(login.this, "Item Aumentar", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.menu_diminuir:
//                // Ação quando o Item 2 é selecionado
//                Toast.makeText(login.this, "Item Diminuir", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }

}
