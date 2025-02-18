package view;

import model.*;

import java.util.Scanner;

public class MenuPrincipalController {
    private Trivia trivia;
    private MenuPrincipalView view;

    public void initMenuPrincipalController(Trivia trivia, MenuPrincipalView menuPrincipalView) {
        this.trivia = trivia;
        this.view = menuPrincipalView;
    }

    public void handleEvent(int event) {
        switch (event) {
            case 1:
                TemasView jogarView = new TemasView();
                jogarView.initTemasView(trivia);
                break;

            case 2:
                ConfiguracoesView configView = new ConfiguracoesView();
                configView.initConfiguracoesView(trivia);
                break;
            case 3:
                RankingView rankingView = new RankingView();
                rankingView.initRankingView(trivia, trivia.getRanking());
                break;
            case 4:
                view.finalizar();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

}
