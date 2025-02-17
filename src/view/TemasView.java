package view;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TemasView implements Observer {
    private Trivia trivia;
    private TemasViewController controller;
    private int numTemas;
    private boolean finalizada = false;

    public void initTemasView(Trivia trivia) {
        this.trivia = trivia;
        controller = new TemasViewController();
        controller.initTemasViewController(trivia, this);
        trivia.attachObserver(this);
        menuTemas();
    }

    public void menuTemas() {
        Scanner entrada = new Scanner(System.in);
        if (trivia.getUsuario() == null) {
            System.out.println("Qual o seu nome?");
            String nome = entrada.nextLine();
            Usuario usuario = new Usuario(nome, 0);
            trivia.setUsuario(usuario);
            trivia.getRanking().adicionarUsuario(usuario);
        }

        System.out.println("======= Temas =======");

        ArrayList<String> temas = new ArrayList<>(trivia.getQuestoes().keySet());

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
            controller.handleEvent(temaEscolhido);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }


    @Override
    public void update() {
        numTemas = trivia.getNumTemas();
    }
}
