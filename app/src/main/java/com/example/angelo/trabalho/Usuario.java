package com.example.angelo.trabalho;

public class Usuario {

    private Long id;
    private UsuarioCategoria categoria;
    private String nome;
    private String login;
    private String senha;

    public Usuario(UsuarioCategoria categoria, String nome, String login, String senha) {
        this.categoria = categoria;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(Long id, UsuarioCategoria categoria, String nome, String login, String senha) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(UsuarioCategoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
