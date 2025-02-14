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
    private Scanner chute;
    private int indiceAtual;
    ArrayList<Questao> questoesDoTema;

    public void initQuestoesView(Trivia trivia, Scanner chute, String temaEscolhido){
        this.trivia = trivia;
        this.chute = chute;
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
        int indice = 1;

        for (Questao questao : questoesDoTema) {
            System.out.printf("Pergunta %d de %d:%n", indice, questoesDoTema.size());
            System.out.println(questao);

            char resposta = Character.toUpperCase(chute.nextLine().charAt(0));

            if (resposta < 'A' || resposta > 'D') {
                System.out.println("Resposta inválida. Tente novamente.");
                continue;
            }

            controller.handleEvent(questao, resposta);
            indice++;
        }

        System.out.println("Quiz finalizado!");
        System.out.println("Pontuação do usuário "+ trivia.getUsuario().getNome()+": " + trivia.getUsuario().getPontuacao());
    }

    public void correcaoQuestao(String mensagem){
        System.out.println(mensagem);
    }


    @Override
    public void update() {

    }

}
