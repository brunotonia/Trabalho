package com.example.angelo.trabalho;

public interface UsuarioConstantes {
    String TABLE_NOME = "usuario";
    String COLUMN_ID = "id";
    String COLUMN_CATEGORIA = "categoria";
    String COLUMN_NOME = "nome";
    String COLUMN_LOGIN = "login";
    String COLUMN_SENHA = "senha";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NOME + "] ( " +
                    "[" + COLUMN_ID +    "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_CATEGORIA +  "] INTEGER NOT NULL, " +
                    "[" + COLUMN_NOME    + "] TEXT NOT NULL, " +
                    "[" + COLUMN_LOGIN + "] TEXT UNIQUE NOT NULL, " +
                    "[" + COLUMN_SENHA   + "] TEXT NOT NULL, " +
                    "FOREIGN KEY([" + COLUMN_CATEGORIA +"]) REFERENCES " +
                    UsuarioCategoriaConstantes.TABLE_NOME +
                    "(" +  UsuarioCategoriaConstantes.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NOME;

    /*String INSERT_PROFESSOR = "INSERT INTO " + TABLE_NOME + " VALUES ("
            + VETOR_CATEGORIAS[0].toString() + ", \""+ VETOR_DESCRICOES[0] + "\")";
    String INSERT_CATEGORIA2 = "INSERT INTO " + TABLE_NOME + " VALUES ("
            + VETOR_CATEGORIAS[1].toString() + ", \""+ VETOR_DESCRICOES[1] + "\")";*/

}
