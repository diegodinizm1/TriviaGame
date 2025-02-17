package view;

import model.Ranking;
import model.Trivia;
import model.Usuario;

import java.util.Scanner;

public class RankingViewController {
    private Trivia trivia;
    private RankingView rankingView;
    private Ranking ranking;


    public void initRankingController(Trivia trivia, RankingView rankingView, Ranking ranking) {
        this.trivia = trivia;
        this.rankingView = rankingView;
        this.ranking = ranking;
        atualizarRanking();
    }



    public void atualizarRanking() {
        rankingView.exibirRanking(ranking);
    }
}
