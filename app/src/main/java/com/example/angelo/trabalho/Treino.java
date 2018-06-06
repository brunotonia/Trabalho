package com.example.angelo.trabalho;

public class Treino {

    private Long id;
    private Usuario professor;
    private Usuario aluno;
    private TreinoCategoria categoria;
    private Long data;
    private String exercico;
    private Integer repeticao;
    private Integer carga;
    private Integer intervalo;
    private Boolean realizado;

    public Treino(Long id, Usuario professor, Usuario aluno, TreinoCategoria categoria, Long data,
                  String exercico, Integer repeticao, Integer carga, Integer intervalo, Boolean realizado) {
        this.id = id;
        this.professor = professor;
        this.aluno = aluno;
        this.categoria = categoria;
        this.data = data;
        this.exercico = exercico;
        this.repeticao = repeticao;
        this.carga = carga;
        this.intervalo = intervalo;
        this.realizado = realizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public TreinoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(TreinoCategoria categoria) {
        this.categoria = categoria;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public String getExercico() {
        return exercico;
    }

    public void setExercico(String exercico) {
        this.exercico = exercico;
    }

    public Integer getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public Integer getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Integer intervalo) {
        this.intervalo = intervalo;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }
}
