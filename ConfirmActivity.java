package com.bernardino.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bernardino.app.model.Participante;
import com.bernardino.app.utils.Constants;

import org.w3c.dom.Text;

public class ConfirmActivity extends AppCompatActivity {
    Participante participante;
    TextView txtEmail;
    TextView txtSite;
    TextView txtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        if (getIntent() != null) {
            participante = getIntent().getParcelableExtra(Constants.KEY_PARTICIPANTE);
            txtEmail = (TextView) findViewById(R.id.tvEmail);
            txtSite = (TextView) findViewById(R.id.tvSite);
            txtTelefone = (TextView) findViewById(R.id.tvTelefone);

            txtEmail.setText(participante.getEmail());
            txtSite.setText(participante.getSite());
            txtTelefone.setText(participante.getTelefone());
        }
    }
}
