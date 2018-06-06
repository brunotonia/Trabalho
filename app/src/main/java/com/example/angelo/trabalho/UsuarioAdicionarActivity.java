package com.example.angelo.trabalho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAdicionarActivity extends Activity {

    /* Variaveis de Tela */
    private EditText edNome;
    private Spinner spnUrCategoria;
    private EditText edLogin;
    private EditText edSenha;
    private Button btSalvar;
    private Button btCancelar;

    DataBaseHelper base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_adicionar);

        /* Inicializa Elementos de Tela */
        edNome = (EditText)findViewById(R.id.edNome);
        spnUrCategoria = (Spinner)findViewById(R.id.spUsrCategoria);
        edLogin = (EditText)findViewById(R.id.edLogin);
        edSenha = (EditText)findViewById(R.id.edSenha);
        btSalvar = (Button)findViewById(R.id.btSalvar);
        btCancelar = (Button)findViewById(R.id.btCancelar);

        /* Povoar o Spinner */
        povoarSpinner();

        /* Listener do Botão Salvar */
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarUsuario(UsuarioAdicionarActivity.this);
            }
        });

        /* Listener do Botão Cancelar */
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar(UsuarioAdicionarActivity.this);
            }
        });
    }

    /* Povoar o Spinner */
    private void povoarSpinner() {
        List<String> lista = new ArrayList<>();
        lista.add(UsuarioCategoriaConstantes.VETOR_DESCRICOES[0]);
        lista.add(UsuarioCategoriaConstantes.VETOR_DESCRICOES[1]);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, lista);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnUrCategoria.setAdapter(arrayAdapter);
    }

    private void adicionarUsuario(Context context) {
        base = new DataBaseHelper(getApplicationContext());
        Usuario usuario = new Usuario(base.buscarUsuarioCategoria(spnUrCategoria.getSelectedItemId()), edNome.getText().toString(),
                edLogin.getText().toString(), edSenha.getText().toString());
        try {
            boolean resposta = base.adicionarUsuario(usuario);
            if (resposta) {
                /* Exibir Mensagem */
                Toast.makeText(context, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show();
                /* Usuário salvo, voltar a tela de loginUsuario */
                retornar_login(this);
            } else {
                Toast.makeText(context, "Não foi possível cadastrar usuário", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cancelar (Context context) {
        retornar_login(this);
    }

    private void retornar_login (Context context) {
        Bundle params = new Bundle(); // usa-se pra passar parametros de uma tela pra outra
        Intent iLogin = new Intent(this, LoginActivity.class);
        iLogin.putExtras(params);
        startActivity(iLogin);
    }

}
