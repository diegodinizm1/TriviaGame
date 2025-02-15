package view;

import model.Trivia;
import model.Usuario;

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

                if (trivia.getUsuario() != null) {
                    System.out.println("Usuario atual: " + trivia.getUsuario().getNome());
                }
                System.out.println("Digite o nome do novo usuário");
                String nome = entrada.nextLine();
                trivia.setUsuario(new Usuario(nome, 0));
                break;

            case 4:

                MenuQuestoesView menuQuestoesView = new MenuQuestoesView();
                menuQuestoesView.initMenuQuestoesView(trivia, entrada);

            case 5:

                System.out.println("Configurações finalizadas.");
                view.finalizar();
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

}
