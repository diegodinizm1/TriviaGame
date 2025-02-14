package view;

import model.Questao;
import model.Trivia;

public class QuestoesViewController {
    private Trivia trivia;
    private QuestoesView questoesView;

    public void initQuestoesViewController(Trivia trivia, QuestoesView questoesView) {
        this.trivia = trivia;
        this.questoesView = questoesView;
    }

    public void handleEvent(Questao questao, char resposta) {
        String chute = questao.getAlternativas().get(resposta);
        if(chute.equals(questao.getResposta())) {
            int pontoQuestao = questao.getPontuacao();
            trivia.getUsuario().setPontuacao(trivia.getUsuario().getPontuacao() + pontoQuestao);
            questoesView.correcaoQuestao("Resposta correta!");
        }else{
            questoesView.correcaoQuestao("Resposta incorreta!");
        }
    }
}
