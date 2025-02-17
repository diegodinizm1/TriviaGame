package view;

import model.Observer;
import model.Ranking;
import model.Trivia;
import model.Usuario;

import java.util.List;
import java.util.Scanner;

public class RankingView implements Observer {
    private Trivia trivia;
    private Scanner entrada;
    private String nome;
    private boolean finalizada = false;
    private RankingViewController controller;
    private Ranking ranking;



    public void initRankingView(Trivia trivia, Ranking ranking) {
        this.trivia = trivia;
        this.entrada = entrada;
        this.ranking = ranking;
        controller = new RankingViewController();
        controller.initRankingController(trivia, this, ranking);

        //exibirRanking(ranking); // Assim exibe automaticamente o ranking ao iniciar

    }

    public void exibirRanking(Ranking ranking) {
        List<Usuario> usuarios = ranking.getUsuarios();

        System.out.println("======= Ranking =======\n");
        if(usuarios.isEmpty()){
            System.out.println("Nenhum usuário encontrado.\n");
        }else{
            int posicao = 1;
            for (Usuario usuario : usuarios) {
                System.out.printf("%d. - %-10s | %d pontos\n", posicao, usuario.getNome(), usuario.getPontuacao());
                posicao++;
            }
        }
    }
    @Override
    public void update() {
        exibirRanking(ranking);
    }
}
