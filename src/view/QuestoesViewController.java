package view;

import model.Questao;
import model.Trivia;

import java.util.ArrayList;

public class QuestoesViewController {
    private Trivia trivia;
    private QuestoesView questoesView;
    private ArrayList<Questao> questoesEscolhidas;

    public void initQuestoesViewController(Trivia trivia, QuestoesView questoesView) {
        this.trivia = trivia;
        this.questoesView = questoesView;
    }

    public Questao getProximaQuestao(String tema, int indiceAtual) {
        if(indiceAtual < trivia.getQuestoes().get(tema).size()) {
            return trivia.getQuestoes().get(tema).get(indiceAtual);
        }
        return null;
    }

    public boolean checarResposta(String tema, int indice, char alternativa) {
        Questao q = trivia.getQuestoes().get(tema).get(indice);
        String chute = q.getAlternativas().get(Character.toUpperCase(alternativa));
        if(chute.equalsIgnoreCase(q.getResposta())){
            trivia.getUsuario().setPontuacao(trivia.getUsuario().getPontuacao() + q.getPontuacao());
            return true;
        }
        return false;
    }
}
