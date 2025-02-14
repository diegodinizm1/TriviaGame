package view;

import model.Trivia;

public class MenuQuestoesViewController {
    private Trivia trivia;
    private MenuQuestoesView menuQuestoesView;

    public void initMenuQuestoesController(Trivia trivia, MenuQuestoesView menuQuestoesView) {
        this.trivia = trivia;
        this.menuQuestoesView = menuQuestoesView;
    }

    public void handleEvent(int event) {
        switch (event) {

        }
    }
}
