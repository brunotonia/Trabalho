package com.example.angelo.trabalho;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

public class TreinoActivity extends Activity {

    /* Variáveis de BD */
    private DataBaseHelper base;

    /* Variáveis de Tela */
    private CalendarView calendario;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    /* Variáveis Globais */
    private Intent it = null;
    private Bundle params = null;
    private Usuario usuario;
    private Long data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);

        /*Recuperando informações do usuário da tela de loginUsuario */
        recuperarParams();

        /* Inicializando interface */
        base = new DataBaseHelper(getApplicationContext());

        final CalendarView calendario = (CalendarView)findViewById(R.id.calendarView);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull final CalendarView view, int year, int month, int dayOfMonth) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TreinoActivity.this);
                CharSequence[]itens = new  CharSequence[3];
                itens[0]="Novo Exercício";
                itens[1]="Consulta Treino";
                itens[2]="Cancelar";

                builder.setTitle("Selecione uma opção:").setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // carrega valor da data
                        data = calendario.getDate();
                        // usa um switch fica melhor o código
                        switch (which) {
                            case 0:
                                ir_addActivity(TreinoActivity.this);
                                break;
                            case 1:
                                visualizarTreino(view);
                                break;
                            case 2:
                                break;
                        }
                    }
                });


                AlertDialog dialog = builder.create();
                dialog.show();
                // um toast pra ver o "id" da data, vai ter que refazer as tabelas com um long contendo a data
                Toast.makeText(TreinoActivity.this,
                        new Long(calendario.getDate()).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /* Visualizar Treino */
    public void visualizarTreino(View view){
        ListView lista = (ListView) findViewById(R.id.ltvListaTreino);
        /*ArrayAdapter<Treino> arrayAd = new ArrayAdapter<Treino>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base.consultarTreino());
        lista.setAdapter(arrayAd);*/
    }

    /* Recuperar params */
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
        usuario = new Usuario(params.getLong("usuarioId"),
                new UsuarioCategoria(params.getLong("usuarioCategoriaId"),
                        params.getString("usuarioCategoriaCategoria")), params.getString("usuarioNome"),
                params.getString("loginUsuario"), params.getString("usuarioSenha"));
    }

    /* Carregar params */
    private void carregarParams() {
        params = new Bundle();
        /* carregando paramentros de uma tela a outra */
        params.putLong("usuarioId", usuario.getId());
        params.putString("usuarioNome", usuario.getNome());
        params.putLong("usuarioCategoriaId", usuario.getCategoria().getId());
        params.putString("usuarioCategoriaCategoria", usuario.getCategoria().getCategoria());
        params.putString("loginUsuario", usuario.getLogin());
        params.putString("usuarioSenha", usuario.getSenha());
        /* Adicionar data para cadastrar e buscar */
        params.putLong("treinoData", data);
    }

    private void ir_addActivity (Context context) {
        carregarParams();
        /* iniciando nova tela*/
        /*Intent iAddActivity = new Intent(this, AddActivity.class);
        iAddActivity.putExtras(params);
        startActivity(iAddActivity);*/
    }

}
