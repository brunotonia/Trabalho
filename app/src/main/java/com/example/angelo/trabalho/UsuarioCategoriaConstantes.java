package com.example.angelo.trabalho;

public interface UsuarioCategoriaConstantes {

    String TABLE_NOME = "usuario_categoria";
    String COLUMN_ID = "id";
    String COLUMN_CATEGORIA = "categoria";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NOME + "] ( " +
                    "[" + COLUMN_ID +    "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_CATEGORIA +  "] TEXT NOT NULL UNIQUE" + " )";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NOME;

    String VETOR_CATEGORIAS[] = {"0", "1"};
    String VETOR_DESCRICOES[] = {"Professor", "Aluno"};

    String INSERT_CATEGORIA1 = "INSERT INTO " + TABLE_NOME + " VALUES ("
            + VETOR_CATEGORIAS[0] + ", \""+ VETOR_DESCRICOES[0] + "\")";
    String INSERT_CATEGORIA2 = "INSERT INTO " + TABLE_NOME + " VALUES ("
            + VETOR_CATEGORIAS[1] + ", \""+ VETOR_DESCRICOES[1] + "\")";

}
