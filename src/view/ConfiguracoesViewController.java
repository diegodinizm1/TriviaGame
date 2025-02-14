package view;

import model.Trivia;

import java.util.Scanner;

public class ConfiguracoesViewController {
    private Trivia trivia;
    private ConfiguracoesView view;

    public void initConfiguracoesViewController(Trivia trivia, ConfiguracoesView configuracoesView) {
        this.trivia = trivia;
        this.view = configuracoesView;
    }

    public void handleEvent(int opcao, Scanner entrada) {
        switch (opcao) {
            case 1:
                System.out.print("Digite a quantidade de questões por rodada: ");
                int qtd = entrada.nextInt();
                entrada.nextLine();
                trivia.setNumQuestoes(qtd);
                break;
            case 2:
                System.out.print("Escolha a dificuldade (Fácil, Normal, Difícil): ");
                String dificuldade = entrada.next();
                trivia.setDificuldadeEscolhida(dificuldade);
                break;
            case 3:
                System.out.println("Configurações finalizadas.");
                view.finalizar();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

}
