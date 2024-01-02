package com.aula.aula_09_05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cadastrese extends AppCompatActivity  implements View.OnClickListener {

    Button btnSalvar;
    EditText txtNomeCad, txtEmailCad, txtSenhaCad, txtConfSenhaCad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrese);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        txtNomeCad = (EditText) findViewById(R.id.txtNomeCad);
        txtEmailCad = (EditText) findViewById(R.id.txtEmailCad);
        txtSenhaCad = (EditText) findViewById(R.id.txtSenhaCad);
        txtConfSenhaCad = (EditText) findViewById(R.id.txtConfSenhaCad);

        btnSalvar.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        String NomeCad = txtNomeCad.getText().toString();
        String EmailCad = txtEmailCad.getText().toString();
        String SenhaCad = txtSenhaCad.getText().toString();
        String ConfSenhaCad = txtConfSenhaCad.getText().toString();


        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        if (SenhaCad.equals(ConfSenhaCad)) {
            resultado = bd.insereDadosUsuario(NomeCad, EmailCad, SenhaCad);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            limpar();
        }else{
            String msg = "As senhas digitadas não são iguais, digite novamente!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
    public void limpar()
    {
        txtNomeCad.setText("");
        txtEmailCad.setText("");
        txtSenhaCad.setText("");
        txtConfSenhaCad.setText("");
        txtNomeCad.requestFocus();
    }
}
