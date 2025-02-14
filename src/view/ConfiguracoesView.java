package view;

import model.*;

import java.util.Scanner;

public class ConfiguracoesView implements Observer {
    private Trivia trivia;
    private ConfiguracoesViewController controller;
    private boolean finalizada;
    private String dificuldadeSelecionada;
    private int numQuestoes;
    private Scanner entrada;


    public void initConfiguracoesView(Trivia trivia, Scanner entrada) {
        this.trivia = trivia;
        this.entrada = entrada;
        controller = new ConfiguracoesViewController();
        controller.initConfiguracoesViewController(trivia, this);
        trivia.attachObserver(this);
        telaConfiguracoes();
    }

    public void telaConfiguracoes() {
        do {
            System.out.println("=======Configurações Trivia=======");
            if(trivia.getNumQuestoes() > 0) {
                System.out.println("Quantidade de questoes atual: " + numQuestoes);
            }
            if(trivia.getDificuldadeEscolhida() != null) {
                System.out.println("Dificuldade atual: " + trivia.getDificuldadeEscolhida());
            }

            System.out.println("1 - Quantidade de questões por rodada:");
            System.out.println("2 - Dificuldade das questões");
            System.out.println("3 - Finalizar Configuracoes");
            int opcao = entrada.nextInt();
            entrada.nextLine();
            controller.handleEvent(opcao, entrada);
            trivia.detachObserver(this);
        }while(!finalizada);
    }

    public void finalizar(){
        finalizada = true;
    }

    public Trivia getTrivia() {
        return trivia;
    }

    public void setTrivia(Trivia trivia) {
        this.trivia = trivia;
    }

    public ConfiguracoesViewController getController() {
        return controller;
    }

    public void setController(ConfiguracoesViewController controller) {
        this.controller = controller;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    @Override
    public void update() {
        numQuestoes = trivia.getNumQuestoes();
    }
}
