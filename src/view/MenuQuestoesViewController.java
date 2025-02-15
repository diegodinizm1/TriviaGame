package view;

import model.Questao;
import model.Trivia;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuQuestoesViewController {
    private Trivia trivia;
    private MenuQuestoesView menuQuestoesView;

    public void initMenuQuestoesController(Trivia trivia, MenuQuestoesView menuQuestoesView) {
        this.trivia = trivia;
        this.menuQuestoesView = menuQuestoesView;
    }

    public void handleEvent(int event, Scanner entrada) {
        switch (event) {
            case 1:
                addPergunta(entrada);
                break;
            case 2:
                removerQuestao(entrada);
                break;
            case 3:
                atualizarQuestao(entrada);
                break;
        }
    }

    private void addPergunta(Scanner entrada) {

        entrada.nextLine();

        menuQuestoesView.exibirMensagem("Digite o tema da pergunta:");
        String tema = entrada.nextLine();

        menuQuestoesView.exibirMensagem("Escreva o enunciado da questão:");
        String enunciado = entrada.nextLine();

        menuQuestoesView.exibirMensagem("Dificuldade:\n 1 - Fácil\n 2 - Normal\n 3 - Difícil");
        int escolha = entrada.nextInt();
        entrada.nextLine();
        String dificuldade = retornarDificuldade(escolha);

        menuQuestoesView.exibirMensagem("Digite a primeira alternativa:");
        String alternativa1 = entrada.nextLine();

        menuQuestoesView.exibirMensagem("Digite a segunda alternativa:");
        String alternativa2 = entrada.nextLine();

        menuQuestoesView.exibirMensagem("Digite a terceira alternativa:");
        String alternativa3 = entrada.nextLine();

        menuQuestoesView.exibirMensagem("Digite a quarta alternativa:");
        String alternativa4 = entrada.nextLine();

        menuQuestoesView.exibirMensagem("Escreva a resposta:");
        String resposta = entrada.nextLine();

        Questao questao = new Questao(tema.toLowerCase(), enunciado, dificuldade, resposta);
        questao.setAlternativas(alternativa1, alternativa2, alternativa3, alternativa4);
        trivia.adicionarQuestao(questao);
    }

    private void removerQuestao(Scanner entrada) {
        entrada.nextLine();

        menuQuestoesView.exibirMensagem("Qual o tema da questão que deseja remover?");
        String tema = entrada.nextLine();

        menuQuestoesView.exibirMensagem("ID da questão: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Questao q = buscarQuestao(tema, id);
        if (q != null) {
            trivia.removerQuestao(q);
            return;
        }
        menuQuestoesView.exibirMensagem("Questão inexistente");
    }

    private Questao buscarQuestao(String tema, int id){
        ArrayList<Questao> questoesTema;
        questoesTema = trivia.getQuestoes().get(tema.toLowerCase());
        for (Questao questao : questoesTema) {
            if(questao.getId() == id){
                return questao;
            }
        }
        return null;
    }

    private String retornarDificuldade(int escolha) {
        switch (escolha) {
            case 1:
                return "Fácil";
            case 2:
                return "Normal";
            case 3:
                return "Difícil";
            default:
                menuQuestoesView.exibirMensagem("Opção inválida");
        }
        return "";
    }

    private void atualizarQuestao(Scanner entrada) {
        entrada.nextLine();

        menuQuestoesView.exibirMensagem("Qual o tema da pergunta que deseja atualizar?");
        String tema = entrada.nextLine();

        menuQuestoesView.exibirMensagem("ID da pergunta: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Questao q = buscarQuestao(tema, id);

        if (q != null) {
            menuQuestoesView.exibirMensagem("Questão encontrada");
            menuQuestoesView.exibirMensagem("Selecione o que deseja atualizar");
            menuQuestoesView.exibirMensagem(" 1 - Tema\n 2 - Enunciado\n 3 - Dificuldade\n 4 - Resposta\n 5 - Alternativas");
            int escolha = entrada.nextInt();
            entrada.nextLine();
            mudarAtributo(q, entrada, escolha);
            return;
        }
        System.out.println("Questão não encontrada");
    }

    private void mudarAtributo(Questao questao, Scanner entrada, int escolha) {
        switch (escolha) {
            case 1:
                menuQuestoesView.exibirMensagem("Qual o novo tema da pergunta? (atual: "+ questao.getTema() + ")");
                String novoTema = entrada.nextLine();
                questao.setTema(novoTema);
                break;
            case 2:
                menuQuestoesView.exibirMensagem("Qual o novo enunciado? (atual: "+ questao.getEnunciado() + ")");
                String novoEnunciado = entrada.nextLine();
                questao.setEnunciado(novoEnunciado);
                break;
            case 3:
                menuQuestoesView.exibirMensagem("Qual a nova dificuldade? (atual: "+ questao.getDificuldade() + ")");
                menuQuestoesView.exibirMensagem(" 1 - Fácil\n 2 - Normal\n 3 - Difícil");
                int escolhaD = entrada.nextInt();
                entrada.nextLine();
                String dificuldade = retornarDificuldade(escolhaD);
                questao.setDificuldade(dificuldade);
                break;
            case 4:
                menuQuestoesView.exibirMensagem("Qual a nova resposta? (atual: "+ questao.getResposta() + ")");
                String resposta = entrada.nextLine();
                questao.setResposta(resposta);
                break;
            case 5:
                menuQuestoesView.exibirMensagem("Alternativas atuais :");
                menuQuestoesView.exibirMensagem(questao.mostrarAlternativas());
                menuQuestoesView.exibirMensagem("Qual alternativa deseja atualizar?");
                char letra = entrada.nextLine().charAt(0);
                menuQuestoesView.exibirMensagem("Qual deve ser a nova alternativa?");
                String alternativaNova = entrada.nextLine();
                questao.atualizarAlternativa(letra, alternativaNova);
                break;
        }
    }
}
