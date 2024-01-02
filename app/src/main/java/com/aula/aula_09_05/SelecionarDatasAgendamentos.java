package com.aula.aula_09_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class SelecionarDatasAgendamentos extends AppCompatActivity implements View.OnClickListener {
    DatePicker txtDataConsulta;
    Button btnConsultarAgendamentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_datas_agendamentos);

        txtDataConsulta = (DatePicker) findViewById(R.id.txtDataConsulta);
        btnConsultarAgendamentos = (Button) findViewById(R.id.btnConsultarAgendamentos);
        btnConsultarAgendamentos.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String dataSelecionada = txtDataConsulta.getDayOfMonth() + "/" + txtDataConsulta.getDayOfMonth() + "/" + txtDataConsulta.getYear();
        Intent telaListaAgendamento = new Intent(this, ConsultaLista.class);
        Bundle parametros = new Bundle();
        parametros.putString("data",dataSelecionada);
        telaListaAgendamento.putExtras(parametros);
        startActivity(telaListaAgendamento);
    }
}