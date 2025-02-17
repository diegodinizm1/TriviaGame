package view;

import model.*;

import java.util.Scanner;

public class ConfiguracoesView implements Observer {
    private Trivia trivia;
    private ConfiguracoesViewController controller;
    private boolean finalizada;
    private String dificuldadeSelecionada;
    private int numQuestoes;


    public void initConfiguracoesView(Trivia trivia) {
        this.trivia = trivia;
        controller = new ConfiguracoesViewController();
        controller.initConfiguracoesViewController(trivia, this);
        trivia.attachObserver(this);
        telaConfiguracoes();
    }

    public void telaConfiguracoes() {
        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("=======Configurações Trivia========");
            System.out.println("1 - Trocar Usuário");
            System.out.println("2 - Menu Questões");
            System.out.println("3 - Finalizar Configuracoes");
            System.out.println("===================================");
            int opcao = entrada.nextInt();
            entrada.nextLine();
            controller.handleEvent(opcao);
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
