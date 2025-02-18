package view;

import model.Observer;
import model.Questao;
import model.Trivia;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestoesView implements Observer {
    private String temaEscolhido;
    private Trivia trivia;
    private QuestoesViewController controller;
    private int indiceAtual;
    ArrayList<Questao> questoesDoTema;

    public void initQuestoesView(Trivia trivia, String temaEscolhido){
        this.trivia = trivia;
        setTemaEscolhido(temaEscolhido);
        controller = new QuestoesViewController();
        controller.initQuestoesViewController(trivia, this);
        trivia.attachObserver(this);
        comecarQuiz();
    }

    public String getTemaEscolhido() {
        return temaEscolhido;
    }

    public void setTemaEscolhido(String temaEscolhido){
        this.temaEscolhido = temaEscolhido;
        questoesDoTema = trivia.getQuestoes().get(temaEscolhido);
    }

    public void comecarQuiz() {
        Scanner resposta = new Scanner(System.in);
        int indice = 0;
        while(controller.getProximaQuestao(temaEscolhido, indice) != null) {
            System.out.println(controller.getProximaQuestao(temaEscolhido, indice));
            char alternativa = Character.toUpperCase(resposta.nextLine().charAt(0));

            if(alternativa <'A' || alternativa > 'D'){
                System.out.println("Opção inválida!");
                continue;
            }

            if(controller.checarResposta(temaEscolhido, indice, alternativa)){
                System.out.println("Correto!");
            }else{
                System.out.println("Alternativa errada!");
            }
            indice++;
        }
        if(controller.getProximaQuestao(temaEscolhido, indice) == null){
            System.out.println("Todas as questões respondidas.");
        }
        System.out.println("Quiz finalizado!");
        System.out.println("Pontuação do usuário "+ trivia.getUsuario().getNome()+": " + trivia.getUsuario().getPontuacao());
    }

    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }


    @Override
    public void update() {

    }

}
