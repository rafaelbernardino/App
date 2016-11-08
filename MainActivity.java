package com.bernardino.app;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bernardino.app.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view) {
        TextInputLayout tilUsuario = (TextInputLayout) findViewById(R.id.tilUsuaioId);
        TextInputLayout tilSenha = (TextInputLayout) findViewById(R.id.tilSenhaId);
        String usuario = tilUsuario.getEditText().getText().toString();
        String senha = tilSenha.getEditText().getText().toString();

        if (usuario == null || usuario.equals("")) {
//            Toast.makeText(this, "Campo usuário deve ser preenchido", Toast.LENGTH_LONG).show();
            tilUsuario.setError("Campo usuário deve ser preenchido");
            return;
        }

        if (senha == null || senha.equals("")) {
//            Toast.makeText(this, "Campo senha deve ser preenchido", Toast.LENGTH_LONG).show();
            tilSenha.setError("Campo senha deve ser preenchido");
            return;
        }

        if (usuario.equals("admin") && senha.equals("171")) {
            tilUsuario.setErrorEnabled(false);
            tilSenha.setErrorEnabled(false);
            Intent intent = new Intent(this, FormActivity.class);
            intent.putExtra(Constants.KEY_USER, usuario);
            startActivity(intent);
        } else {
//            Toast.makeText(this, "Credenciais incorretas", Toast.LENGTH_LONG).show();
            tilSenha.setError("Credenciais incorretas");
        }
    }
}
