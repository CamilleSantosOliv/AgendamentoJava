package com.aula.aula_09_05;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class agendamento extends AppCompatActivity implements View.OnClickListener {
    DatePicker txtData;
    Spinner    txtHora;
    Button     btnAgendamento;
    String nome = "";

    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        txtData = (DatePicker) findViewById(R.id.txtData);
        btnAgendamento = (Button) findViewById(R.id.btnAgendamento);
        txtHora = (Spinner) findViewById( R.id.txtHora) ;

        btnAgendamento.setOnClickListener(this);

        String[] horarios = new String[] {"08:00", "09:00", "10:00"};

        ArrayAdapter<String> aad = new ArrayAdapter<String>( this , android.R.layout.simple_gallery_item , horarios ) ;
        txtHora.setAdapter( aad );

    }
    public void onClick(View v)
    {
        String data = txtData.getDayOfMonth() + "/" + txtData.getDayOfMonth() + "/" + txtData.getYear();
        String hora = (String) txtHora.getSelectedItem();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.consultaAgendaHora(data, hora);

        if(dados.moveToFirst()) {
            String msg = "Não foi possível cadastrar, pois não há vaga neste data/hora!!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        else{
            String resultado;
            resultado = bd.insereDadosAgendamento(nome, data, hora);
            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }



    }
}