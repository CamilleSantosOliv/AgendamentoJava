package com.aula.aula_09_05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity  implements View.OnClickListener {

    Button btnMeusDados, btnCadastrarContatos, btnListaAgendamentos, btnPedido, btnAgendar;
    TextView txtNomeUsuario;
    String nome="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // recebendo os dados da tela de login
        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        btnMeusDados = (Button) findViewById(R.id.btnMeusDados);
        btnCadastrarContatos = (Button) findViewById(R.id.btnCadastrarContatos);
        btnPedido = (Button) findViewById(R.id.btnPedido);
        btnAgendar = (Button) findViewById(R.id.btnAgendar);

        btnListaAgendamentos = (Button) findViewById(R.id.btnListaAgendamento);
        txtNomeUsuario = (TextView) findViewById(R.id.txtNomeUsuario);
        // apresentando o nome do usuario
        txtNomeUsuario.setText("Usuário: " + nome);

        btnMeusDados.setOnClickListener(this);
        btnCadastrarContatos.setOnClickListener(this);
        btnListaAgendamentos.setOnClickListener(this);
        btnPedido.setOnClickListener(this);
        btnAgendar.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.btnCadastrarContatos) {
            Intent telaCadastroContatos = new Intent(this, MainActivity.class);
            startActivity(telaCadastroContatos);
        }
        if (v.getId() == R.id.btnMeusDados) {
            Intent telaCadastroContatos = new Intent(this, meusdados.class);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            telaCadastroContatos.putExtras(parametros);
            startActivity(telaCadastroContatos);
        }
        if (v.getId() == R.id.btnListaAgendamento) {
            //Intent telaListaUsuarios = new Intent(this, ConsultaLista.class);
            //startActivity(telaListaUsuarios);
            Intent telaSelecionarData = new Intent(this, SelecionarDatasAgendamentos.class);
            startActivity(telaSelecionarData);
        }
        if (v.getId() == R.id.btnPedido) {
            Intent telaPedido = new Intent(this, pedido.class);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            telaPedido.putExtras(parametros);
            startActivity(telaPedido);
        }
        if (v.getId() == R.id.btnAgendar) {
            Intent telaAgendamento = new Intent(this, agendamento.class);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            telaAgendamento.putExtras(parametros);
            startActivity(telaAgendamento);
        }
    }
}
