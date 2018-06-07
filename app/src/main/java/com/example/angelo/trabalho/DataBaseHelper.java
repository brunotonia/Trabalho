package com.example.angelo.trabalho;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Switch;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Treino.db";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criando e povoando tabela usuário_categoria
        db.execSQL(UsuarioCategoriaConstantes.CREATE_TABLE);
        db.execSQL(UsuarioCategoriaConstantes.INSERT_CATEGORIA1);
        db.execSQL(UsuarioCategoriaConstantes.INSERT_CATEGORIA2);
        // Criando tabela usuário
        db.execSQL(UsuarioConstantes.CREATE_TABLE);
        // Criando e povoando tabela treino_categoria
        db.execSQL(TreinoCategoriaConstantes.CREATE_TABLE);
        db.execSQL(TreinoCategoriaConstantes.INSERT_CATEGORIA1);
        db.execSQL(TreinoCategoriaConstantes.INSERT_CATEGORIA2);
        db.execSQL(TreinoCategoriaConstantes.INSERT_CATEGORIA3);
        // Criando tabela treino
        db.execSQL(TreinoConstantes.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UsuarioConstantes.DROP_TABLE);
        db.execSQL(UsuarioCategoriaConstantes.DROP_TABLE);
        db.execSQL(TreinoConstantes.DROP_TABLE);
        db.execSQL(TreinoCategoriaConstantes.DROP_TABLE);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public boolean adicionarUsuario (Usuario usuario) {
        /* Variáveis do BD */
        SQLiteDatabase db = this.getWritableDatabase();
        /* Parametros do banco de dados */
        ContentValues contentValues = new ContentValues();
        contentValues.put(UsuarioConstantes.COLUMN_CATEGORIA, usuario.getCategoria().getId());
        contentValues.put(UsuarioConstantes.COLUMN_NOME, usuario.getNome());
        contentValues.put(UsuarioConstantes.COLUMN_LOGIN, usuario.getLogin());
        contentValues.put(UsuarioConstantes.COLUMN_SENHA, usuario.getSenha());
        /* Inserindo no Banco de Dados */
        Long l = db.insert(UsuarioConstantes.TABLE_NOME, null, contentValues);
        return (l != -1L);
    }

    public Usuario loginUsuario (String login, String senha) {
        /* Variáveis do BD */
        SQLiteDatabase db = this.getWritableDatabase();
        Usuario usuario = new Usuario(-1L, new UsuarioCategoria(-1L, "erro"),
                "erro", "erro", "senha");
        String colunas[] = {UsuarioConstantes.COLUMN_ID, UsuarioConstantes.COLUMN_CATEGORIA,
                UsuarioConstantes.COLUMN_NOME, UsuarioConstantes.COLUMN_LOGIN,
                UsuarioConstantes.COLUMN_SENHA};
        String selecao = UsuarioConstantes.COLUMN_LOGIN + " =? AND " +
                UsuarioConstantes.COLUMN_SENHA + " =? ";
        String valores[] = {login,senha};

        /* Realizando busca no banco de dados */
        Cursor cursor =  db.query(UsuarioConstantes.TABLE_NOME, colunas, selecao, valores,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            usuario.setId(cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_ID)));
            usuario.setCategoria(buscarUsuarioCategoria(cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_CATEGORIA))));
            usuario.setNome(cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_NOME)));
            usuario.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_LOGIN)));
            usuario.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_SENHA)));
        }
        return usuario;
    }

    public UsuarioCategoria buscarUsuarioCategoria (Long id) {
        /* Variáveis do BD */
        SQLiteDatabase db = this.getWritableDatabase();
        UsuarioCategoria categoria = new UsuarioCategoria(-1L, "erro");

        String colunas[] = {UsuarioCategoriaConstantes.COLUMN_ID, UsuarioCategoriaConstantes.COLUMN_CATEGORIA};
        String selecao = UsuarioCategoriaConstantes.COLUMN_ID + " =? ";
        String valores[] = {id.toString()};

        /* Realizando busca no banco de dados */
        Cursor cursor =  db.query(UsuarioConstantes.TABLE_NOME, colunas, selecao, valores,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            categoria.setId(cursor.getLong(cursor.getColumnIndex(UsuarioCategoriaConstantes.COLUMN_ID)));
            categoria.setCategoria(cursor.getString(
                    cursor.getColumnIndex(UsuarioCategoriaConstantes.COLUMN_CATEGORIA)));;
        }
        return categoria;
    }

    public Usuario buscarUsuario (Long id) {
        /* Variáveis do BD */
        SQLiteDatabase db = this.getWritableDatabase();
        Usuario usuario = new Usuario(-1L, new UsuarioCategoria(-1L, "erro"),
                "erro", "erro", "senha");
        String colunas[] = {UsuarioConstantes.COLUMN_ID, UsuarioConstantes.COLUMN_CATEGORIA,
                UsuarioConstantes.COLUMN_NOME, UsuarioConstantes.COLUMN_LOGIN,
                UsuarioConstantes.COLUMN_SENHA};
        String selecao = UsuarioConstantes.COLUMN_ID + " =? ";
        String valores[] = {id.toString()};

        /* Realizando busca no banco de dados */
        Cursor cursor =  db.query(UsuarioConstantes.TABLE_NOME, colunas, selecao, valores,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            usuario.setId(cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_ID)));
            usuario.setCategoria(buscarUsuarioCategoria(cursor.getLong(cursor.getColumnIndex(UsuarioConstantes.COLUMN_CATEGORIA))));
            usuario.setNome(cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_NOME)));
            usuario.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_LOGIN)));
            usuario.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioConstantes.COLUMN_SENHA)));
        }
        return usuario;
    }

    public TreinoCategoria buscarTreinoCategoria (Long id) {
        /* Variáveis do BD */
        SQLiteDatabase db = this.getWritableDatabase();
        TreinoCategoria categoria = new TreinoCategoria(-1L, "erro");

        String colunas[] = {UsuarioCategoriaConstantes.COLUMN_ID, UsuarioCategoriaConstantes.COLUMN_CATEGORIA};
        String selecao = UsuarioCategoriaConstantes.COLUMN_ID + " =? ";
        String valores[] = {id.toString()};

        /* Realizando busca no banco de dados */
        Cursor cursor =  db.query(TreinoCategoriaConstantes.TABLE_NOME, colunas, selecao, valores,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            categoria.setId(cursor.getLong(cursor.getColumnIndex(TreinoCategoriaConstantes.COLUMN_ID)));
            categoria.setCategoria(cursor.getString(
                    cursor.getColumnIndex(TreinoCategoriaConstantes.COLUMN_CATEGORIA)));;
        }
        return categoria;
    }

    public ArrayList consultarTreino(Long data, Usuario usuario){
        ArrayList lista = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        String colunas[] = {TreinoConstantes.COLUMN_ID, TreinoConstantes.COLUMN_PROFESSOR,
                TreinoConstantes.COLUMN_ALUNO, TreinoConstantes.COLUMN_CATEGORIA, TreinoConstantes.COLUMN_DATA,
                TreinoConstantes.COLUMN_EXERCICIO, TreinoConstantes.COLUMN_REPETICAO,
                TreinoConstantes.COLUMN_CARGA, TreinoConstantes.COLUMN_INTERVALO,
                TreinoConstantes.COLUMN_REALIZADO};
        String selecao;
        if (usuario.getCategoria().getId() == 0L) {
            selecao = TreinoConstantes.COLUMN_DATA + " =? AND " +
                    TreinoConstantes.COLUMN_PROFESSOR + " =? ";
        } else {
                selecao = TreinoConstantes.COLUMN_DATA + " =? AND " +
                        TreinoConstantes.COLUMN_ALUNO + " =? ";
        }
        String valores[] = {data.toString(), usuario.getId().toString()};

        /* Realizando busca no banco de dados */
        Cursor cursor =  db.query(TreinoConstantes.TABLE_NOME, colunas, selecao, valores,
                null, null, null, null);
        while (cursor.moveToNext()){
            lista.add(new Treino(cursor.getLong(cursor.getColumnIndex(TreinoConstantes.COLUMN_ID)),
                    buscarUsuario(cursor.getLong(cursor.getColumnIndex(TreinoConstantes.COLUMN_PROFESSOR))),
                    buscarUsuario(cursor.getLong(cursor.getColumnIndex(TreinoConstantes.COLUMN_ALUNO))),
                    buscarTreinoCategoria(cursor.getLong(cursor.getColumnIndex(TreinoConstantes.COLUMN_CATEGORIA))),
                    cursor.getLong(cursor.getColumnIndex(TreinoConstantes.COLUMN_DATA)),
                    cursor.getString(cursor.getColumnIndex(TreinoConstantes.COLUMN_EXERCICIO)),
                    cursor.getInt(cursor.getColumnIndex(TreinoConstantes.COLUMN_REPETICAO)),
                    cursor.getInt(cursor.getColumnIndex(TreinoConstantes.COLUMN_CARGA)),
                    cursor.getInt(cursor.getColumnIndex(TreinoConstantes.COLUMN_INTERVALO)),
                    (cursor.getInt(cursor.getColumnIndex(TreinoConstantes.COLUMN_REALIZADO)) == 0L)));
        }
        return  lista;
    }
}
