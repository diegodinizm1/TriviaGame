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

    public void handleEvent(int opcao) {
        Scanner entrada = new Scanner(System.in);

        switch (opcao) {
            case 1:

                if (trivia.getUsuario() != null) {
                    System.out.println("Usuario atual: " + trivia.getUsuario().getNome());
                }
                System.out.println("Digite o nome do novo usuário");
                String nome = entrada.nextLine();
                Usuario usuario = new Usuario(nome, 0);
                trivia.setUsuario(usuario);
                trivia.getRanking().adicionarUsuario(usuario);
                break;

            case 2:

                MenuQuestoesView menuQuestoesView = new MenuQuestoesView();
                menuQuestoesView.initMenuQuestoesView(trivia);

            case 3:

                System.out.println("Configurações finalizadas.");
                view.finalizar();
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

}
