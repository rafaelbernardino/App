package com.bernardino.app;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bernardino.app.model.Participante;
import com.bernardino.app.utils.Constants;

public class FormActivity extends AppCompatActivity {
    private TextView txtUsuario;
    private TextInputLayout tilNome;
    private TextInputLayout tilEmail;
    private TextInputLayout tilTelefone;
    private TextInputLayout tilSite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtUsuario = (TextView) findViewById(R.id.txtUsuario);
        tilNome = (TextInputLayout) findViewById(R.id.tilNomeId);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmailId);
        tilTelefone = (TextInputLayout) findViewById(R.id.tilTelefoneId);
        tilSite = (TextInputLayout) findViewById(R.id.tilSiteId);

        if (getIntent() != null) {
            txtUsuario.setText(getIntent().getStringExtra(Constants.KEY_USER));
        }
    }

    public void cadastrar(View view) {
        String nome = tilNome.getEditText().getText().toString();
        String email = tilEmail.getEditText().getText().toString();
        String telefone = tilTelefone.getEditText().getText().toString();
        String site = tilSite.getEditText().getText().toString();

        if (nome == null || nome.equals("")) {
            tilNome.setError("Campo nome obrigatorio");
            return;
        }

        if (email == null || email.equals("")) {
            tilEmail.setError("Campo email obrigatorio");
            return;
        }

        if (telefone == null || telefone.equals("")) {
            tilTelefone.setError("Campo telefone obrigatorio");
            return;
        }

        if (site == null || site.equals("")) {
            tilSite.setError("Campo site obrigatorio");
            return;
        }

        Participante participante = new Participante();
        participante.setNome(nome);
        participante.setEmail(email);
        participante.setTelefone(telefone);
        participante.setSite(site);

        Intent intent = new Intent(this, ConfirmActivity.class);
        intent.putExtra(Constants.KEY_PARTICIPANTE, participante);
        startActivity(intent);
    }
}
