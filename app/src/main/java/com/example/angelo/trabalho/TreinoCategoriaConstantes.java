package com.example.angelo.trabalho;

public interface TreinoCategoriaConstantes {

    String TABLE_NOME = "treino_categoria";
    String COLUMN_ID = "id";
    String COLUMN_CATEGORIA = "categoria";

    String CREATE_TABLE =
            "CREATE TABLE [" + TABLE_NOME + "] ( " +
                    "[" + COLUMN_ID +    "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_CATEGORIA +  "] TEXT NOT NULL UNIQUE" + " )";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NOME;

    String VETOR_CATEGORIAS[] = {"0", "1", "2"};
    String VETOR_DESCRICOES[] = {"Aeróbico", "Cardio", "Muscular"};

    String INSERT_CATEGORIA1 = "INSERT INTO " + TABLE_NOME + " VALUES ("
            + VETOR_CATEGORIAS[0] + ", \""+ VETOR_DESCRICOES[0] + "\")";
    String INSERT_CATEGORIA2 = "INSERT INTO " + TABLE_NOME + " VALUES ("
            + VETOR_CATEGORIAS[1] + ", \""+ VETOR_DESCRICOES[1] + "\")";
    String INSERT_CATEGORIA3 = "INSERT INTO " + TABLE_NOME + " VALUES ("
            + VETOR_CATEGORIAS[2] + ", \""+ VETOR_DESCRICOES[2] + "\")";

}
