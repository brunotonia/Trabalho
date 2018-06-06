package com.example.angelo.trabalho;

public interface TreinoConstantes {
    String TABLE_NOME = "treino";
    String COLUMN_ID = "id";
    String COLUMN_PROFESSOR = "professor";
    String COLUMN_ALUNO = "aluno";
    String COLUMN_CATEGORIA = "categoria";
    String COLUMN_DATA = "data";
    String COLUMN_EXERCICIO = "exercicio";
    String COLUMN_REPETICAO = "repeticao";
    String COLUMN_CARGA = "carga";
    String COLUMN_INTERVALO = "intervalo";
    String COLUMN_REALIZADO = "realizado";



    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NOME + "] ( " +
                    "[" + COLUMN_ID +    "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_PROFESSOR +  "] INTEGR NOT NULL," +
                    "[" + COLUMN_ALUNO    + "] INTEGR NOT NULL, " +
                    "[" + COLUMN_CATEGORIA + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_DATA + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_EXERCICIO   + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_REPETICAO   + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_CARGA   + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_INTERVALO   + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_REALIZADO   + "] INTEGER NOT NULL, " +
                    "FOREIGN KEY([" + COLUMN_PROFESSOR +"]) REFERENCES " +
                    UsuarioConstantes.TABLE_NOME +
                    "(" +  UsuarioConstantes.COLUMN_ID + ")" +
                    "FOREIGN KEY([" + COLUMN_ALUNO +"]) REFERENCES " +
                    UsuarioConstantes.TABLE_NOME +
                    "(" +  UsuarioConstantes.COLUMN_ID + ")" +
                    "FOREIGN KEY([" + COLUMN_CATEGORIA +"]) REFERENCES " +
                    UsuarioCategoriaConstantes.TABLE_NOME +
                    "(" +  UsuarioCategoriaConstantes.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NOME;



}
