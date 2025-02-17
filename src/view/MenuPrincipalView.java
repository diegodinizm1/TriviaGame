package view;

import model.*;

import java.util.Scanner;


public class MenuPrincipalView implements Observer {
    private Trivia trivia;
    private MenuPrincipalController controller;
    private String nome;
    private boolean finalizada = false;

    public void initMenuPrincipalView(Trivia trivia) {
        this.trivia = trivia;
        controller  = new MenuPrincipalController();
        controller.initMenuPrincipalController(trivia, this);
        trivia.attachObserver(this);
        menuPrincipal();
    }

    public void menuPrincipal() {

        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("=======Trivia Quiz=======");
            if(trivia.getUsuario() != null) {
                System.out.println("Bem vindo, "+ trivia.getUsuario().getNome());
            }
            System.out.println("\n1 - Jogar");
            System.out.println("2 - Configurações");
            System.out.println("3 - Ranking");
            System.out.println("4 - Sair");
            System.out.println("\n=========================");
            int opcao = entrada.nextInt();
            entrada.nextLine();
            controller.handleEvent(opcao);
        }while(!finalizada);
    }


    public void finalizar(){
        finalizada = true;
    }

    public Trivia getTrivia() {
        return trivia;
    }

    public void setTrivia(Trivia trivia) {
        this.trivia = trivia;
    }

    public MenuPrincipalController getController() {
        return controller;
    }

    public void setController(MenuPrincipalController controller) {
        this.controller = controller;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void update() {
        if(trivia.getUsuario() != null) {
            nome = trivia.getUsuario().getNome();
        }
    }
}
