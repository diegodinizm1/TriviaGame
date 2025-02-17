package view;

import model.Trivia;

import java.util.Scanner;

public class TemasViewController {
    private Trivia trivia;
    private TemasView temasView;

    public void initTemasViewController(Trivia trivia, TemasView temasView) {
        this.trivia = trivia;
        this.temasView = temasView;
        trivia.attachObserver(temasView);
    }

    public void handleEvent(String event) {
        QuestoesView questoesView = new QuestoesView();
        questoesView.initQuestoesView(trivia, event);
    }
}
