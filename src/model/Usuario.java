package model;

public class Usuario {
    private String nome;
    private int pontuacao;

    public Usuario(){}

    public Usuario(String nome, int pontuacao) {
        setNome(nome);
        setPontuacao(pontuacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
