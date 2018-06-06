package com.example.angelo.trabalho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    /* Variáveis de Tela */
    private Button btEntrar;
    private Button btNovo;
    private EditText edUsuario;
    private EditText edSenha;
    /* Variáveis de Sessão */
    private Bundle params = new Bundle();
    private Usuario usuario = new Usuario(-1L, new UsuarioCategoria(-1L, "erro"),
            "erro", "erro", "erro");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Inicializa Elementos de Tela */
        btEntrar = (Button) findViewById(R.id.btEntrar);
        btNovo = (Button) findViewById(R.id.btNovo);
        edUsuario = (EditText) findViewById(R.id.edUsuario);
        edSenha = (EditText) findViewById(R.id.edSenha);

        /* Listener botão Entrar */
        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLogin(LoginActivity.this, edUsuario.getText().toString(),
                        edSenha.getText().toString());
            }
        });

        /* Listener botão de Novo Usuário */
        btNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UsuarioAdicionarActivity.class);
                startActivity(intent);
            }
        });

    }

    /* Carregar Parametros de Tela */
    private void carregarParams() {
        params = new Bundle();
        /* carregando paramentros de uma tela a outra */
        params.putLong("usuarioId", usuario.getId());
        params.putString("usuarioNome", usuario.getNome());
        params.putLong("usuarioCategoriaId", usuario.getCategoria().getId());
        params.putString("usuarioCategoriaCategoria", usuario.getCategoria().getCategoria());
        params.putString("loginUsuario", usuario.getLogin());
        params.putString("usuarioSenha", usuario.getSenha());
    }

    /* Método para ir a tela Calendário */
    private void carregarCalendarioActivity(Context context) {
        carregarParams();
        /* iniciando nova tela*/
        //Intent iLogin = new Intent(this, CalendarioActivity.class);
        //iLogin.putExtras(params);
        //startActivity(iLogin);
    }

    private void realizarLogin (Context context, String login, String senha) {
        try {
            usuario = new DataBaseHelper(context).loginUsuario(login, senha);
            Toast.makeText(context, "id " + usuario.getId() + "!", Toast.LENGTH_LONG).show();
            if (usuario.getId() != -1L) {
                Toast.makeText(context, "Bem Vindo " + usuario.getNome() + "!", Toast.LENGTH_LONG).show();
                carregarCalendarioActivity(this);
            } else {
                Toast.makeText(context, "Usuário ou Senha incorretos", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, "Erro - Não foi possível logar", Toast.LENGTH_LONG).show();
        }
    }
}
