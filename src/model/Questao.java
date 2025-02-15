package model;
import java.util.*;

public class Questao {
    private static int contador = 0;
    private int id;
    private String enunciado;
    private String dificuldade;
    private String resposta;
    private String tema;
    private int pontuacao;
    private HashMap<Character, String> alternativas;

    public Questao() {
        this.id = contador++;
        alternativas = new HashMap<>();
    }

    public Questao(String tema, String enunciado, String dificuldade, String resposta) {
        this();
        setTema(tema);
        setEnunciado(enunciado);
        setDificuldade(dificuldade);
        setResposta(resposta);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) throws OperacaoInvalidaException {
        if(enunciado != null && !enunciado.isEmpty()) {
            this.enunciado = enunciado;
        }else{
            throw new OperacaoInvalidaException("O enunciado da questão não pode ser nulo!");
        }
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) throws OperacaoInvalidaException {
        if(dificuldade.equals("Fácil")){
            setPontuacao(50);
        } else if (dificuldade.equals("Normal")) {
            setPontuacao(100);
        }else{
            setPontuacao(200);
        }
        if(dificuldade.equals("Fácil") || dificuldade.equals("Normal") || dificuldade.equals("Difícil")) {
            this.dificuldade = dificuldade;
        }else{
            throw new OperacaoInvalidaException("Difículdade inválida!");
        }
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) throws OperacaoInvalidaException {
        if(resposta != null && !resposta.isEmpty()) {
            this.resposta = resposta;
        }else{
            throw new OperacaoInvalidaException("Resposta inválida!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) throws OperacaoInvalidaException {
        if(tema != null && !tema.isEmpty()) {
            this.tema = tema;
        }else{
            throw new OperacaoInvalidaException("Tema inválido!");
        }
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public HashMap<Character, String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String alternativa1, String alternativa2, String alternativa3, String alternativa4) {
        alternativas.put('A', alternativa1);
        alternativas.put('B', alternativa2);
        alternativas.put('C', alternativa3);
        alternativas.put('D', alternativa4);
    }

    public String mostrarAlternativas() {
        StringBuilder sb = new StringBuilder();
        char c = 'A';
        for (String valor : getAlternativas().values()) {
            sb.append(c).append(") ").append(valor).append("\n");
            c++;
        }
        return sb.toString();
    }

    public void atualizarAlternativa(char letra, String alternativaNova) {
        getAlternativas().put(Character.toUpperCase(letra), alternativaNova);
    }


    public String toString() {
        System.out.println("(ID: " + id + "): ");
        System.out.println("Dificuldade: "+dificuldade);
        System.out.println();
        System.out.println(enunciado);
        char c = 'A';
        for(int i = 0; i<alternativas.size(); i++){
            System.out.println(c+") "+alternativas.get(c));
            c++;
        }
        return "";
    }
}
