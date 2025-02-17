import model.Trivia;
import view.MenuPrincipalView;


public class SistemaTriviaJogo {
    public static void main(String[] args) {
        Trivia trivia = new Trivia();
        trivia.inicializarQuestoes();
        MenuPrincipalView view = new MenuPrincipalView();
        view.initMenuPrincipalView(trivia);
    }
}
