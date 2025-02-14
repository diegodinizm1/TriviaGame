package view;

import model.*;

import java.util.Scanner;

public class MenuPrincipalController implements Observer {
    private Trivia trivia;
    private MenuPrincipalView view;

    public void initMenuPrincipalController(Trivia trivia, MenuPrincipalView menuPrincipalView) {
        this.trivia = trivia;
        this.view = menuPrincipalView;
        trivia.attachObserver(this);
    }

    public void handleEvent(int event, Scanner entrada) {
        switch (event) {
            case 1:
                TemasView jogarView = new TemasView();
                jogarView.initTemasView(trivia, entrada);
                break;

            case 2:
                ConfiguracoesView configView = new ConfiguracoesView();
                configView.initConfiguracoesView(trivia, entrada);
                break;
        }
    }

    @Override
    public void update() {

    }
}
