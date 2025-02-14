package view;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TemasView implements Observer {
    private Trivia trivia;
    private TemasViewController controller;
    private int numTemas;
    private boolean finalizada = false;
    private Scanner entrada;

    public void initTemasView(Trivia trivia, Scanner entrada) {
        this.trivia = trivia;
        this.entrada = entrada;
        controller = new TemasViewController();
        controller.initTemasViewController(trivia, this);
        trivia.attachObserver(this);
        menuTemas();
    }

    public void menuTemas() {
        if (trivia.getUsuario() == null) {
            System.out.println("Qual o seu nome?");
            String nome = entrada.nextLine();
            trivia.setUsuario(new Usuario(nome, 0));
        }

        System.out.println("======= Temas =======");

        ArrayList<String> temas = new ArrayList<>(trivia.getQuestoes().keySet()); // Convertendo o keySet para List

        if (temas.isEmpty()) {
            System.out.println("Nenhum tema encontrado.");
            return;
        }

        for (int i = 0; i < temas.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, temas.get(i));
        }

        System.out.println("Escolha um tema pelo número:");
        int opcao = entrada.nextInt();
        entrada.nextLine();

        if (opcao >= 1 && opcao <= temas.size()) {
            String temaEscolhido = temas.get(opcao - 1);
            System.out.println("Você escolheu o tema: " + temaEscolhido);
            controller.handleEvent(temaEscolhido, entrada);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }


    @Override
    public void update() {
        numTemas = trivia.getNumTemas();
    }
}
