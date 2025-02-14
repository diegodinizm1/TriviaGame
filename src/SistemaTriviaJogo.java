import model.Trivia;
import view.MenuPrincipalView;

import java.util.Scanner;

public class SistemaTriviaJogo {
    public static void main(String[] args) {
        Trivia trivia = new Trivia();
        trivia.inicializarQuestoes();
        Scanner entrada = new Scanner(System.in);
        MenuPrincipalView view = new MenuPrincipalView();
        view.initMenuPrincipalView(trivia, entrada);
    }
}
