package model;

import java.lang.reflect.Array;
import java.util.*;

public class Trivia {
    private HashMap<String, ArrayList<Questao>> questoes;
    private ArrayList<Observer> observers;
    private Usuario usuario;
    private String dificuldadeEscolhida;
    private int numQuestoes;
    private int numTemas;

    public Trivia() {
        questoes = new HashMap<>();
        observers = new ArrayList<>();
    }

    public HashMap<String, ArrayList<Questao>> getQuestoes() {
        return questoes;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public int getNumTemas() {
        return numTemas;
    }

    public void incrementaTemas() {
        numTemas++;
    }

    public void setNumTemas(int numTemas) {
        this.numTemas = numTemas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        notifica();
    }

    public String getDificuldadeEscolhida() {
        return dificuldadeEscolhida;
    }

    public void setDificuldadeEscolhida(String dificuldadeEscolhida) {
        this.dificuldadeEscolhida = dificuldadeEscolhida;
        notifica();
    }

    public void notifica(){
        for(Observer o : observers){
            o.update();
        }
    }

    public void attachObserver(Observer o){
        observers.add(o);
    }

    public void detachObserver(Observer o){
        observers.remove(o);
    }

    public void adicionarQuestao(Questao questao) {
        if(!questoes.containsKey(questao.getTema())){
            questoes.put(questao.getTema().toLowerCase(), new ArrayList<>());
            incrementaTemas();
        }
        questoes.get(questao.getTema().toLowerCase()).add(questao);
        notifica();
    }

    public void removerQuestao(Questao questao) {
        if(questoes.containsKey(questao.getTema())){
            questoes.get(questao.getTema()).remove(questao);
        }
        notifica();
    }

    public void atualizarQuestao(Questao questao, String atributo) {
        if(questoes.containsKey(questao.getTema())){
            if(questoes.get(questao.getTema()).contains(questao)){

            }
        }
    }

    public void mostrarQuestoes(String tema, int numQuestoes, String dificuldadeEscolhida) {
        ArrayList<Questao> questoesEscolhidas = questoes.get(tema);
        if(numQuestoes > questoesEscolhidas.size()){
            numQuestoes = questoesEscolhidas.size();
        }
        if(dificuldadeEscolhida == null){
            dificuldadeEscolhida = "Normal";
        }
        for(int i = 0; i < numQuestoes; i++){
            if(questoesEscolhidas.get(i).getDificuldade().equals(dificuldadeEscolhida)){
                System.out.println(questoesEscolhidas.get(i));
            }
        }

    }

    public void mostrarTemas(){
        int index = 1;
        for (String tema : questoes.keySet()) {
            System.out.printf("\n%d - %s\n", index, tema);
            index++;
        }

    }

    public int getNumQuestoes() {
        return numQuestoes;
    }

    public void setNumQuestoes(int qtd) {
        this.numQuestoes = qtd;
        notifica();
    }



    public void inicializarQuestoes(){
        Questao q1 = new Questao("Programação Orientada a Objetos",
                "Quais são os 4 (quatro) pilares da Orientação a Objetos?",
                "Fácil",
                "Abstração, Herança, Polimorfismo e Encapsulamento");
        q1.setAlternativas(
                "Abstração, Herança, Polimorfismo e Encapsulamento",
                "Classes, Objetos, Métodos e Atributos",
                "Instanciação, Modularização, Polimorfismo e Herança",
                "Abstração, Modularidade, Encapsulamento e Delegação"
        );
        adicionarQuestao(q1);

        // Tema: Estruturas de Dados
        Questao q2 = new Questao("Estruturas de Dados",
                "Qual estrutura de dados utiliza o conceito LIFO (Last In, First Out)?",
                "Normal",
                "Pilha");
        q2.setAlternativas(
                "Pilha",
                "Fila",
                "Lista Encadeada",
                "Árvore Binária"
        );
        adicionarQuestao(q2);

        // Tema: Algoritmos e Complexidade
        Questao q3 = new Questao("Algoritmos e Complexidade",
                "Qual é a complexidade de tempo do algoritmo de busca binária?",
                "Normal",
                "O(log n)");
        q3.setAlternativas(
                "O(n)",
                "O(n^2)",
                "O(1)",
                "O(log n)"
        );
        adicionarQuestao(q3);

        // Tema: Banco de Dados
        Questao q4 = new Questao("Banco de Dados",
                "Qual comando SQL é usado para recuperar dados de uma tabela?",
                "Fácil",
                "SELECT");
        q4.setAlternativas(
                "SELECT",
                "UPDATE",
                "DELETE",
                "DROP"
        );
        adicionarQuestao(q4);

        // Tema: Redes de Computadores
        Questao q5 = new Questao("Redes de Computadores",
                "Qual protocolo é amplamente usado para transferência de arquivos na internet?",
                "Normal",
                "FTP");
        q5.setAlternativas(
                "TCP",
                "HTTP",
                "FTP",
                "UDP"
        );
        adicionarQuestao(q5);

        // Tema: Segurança da Informação
        Questao q6 = new Questao("Segurança da Informação",
                "Qual destas técnicas é usada para proteger senhas armazenadas em um sistema?",
                "Difícil",
                "Hashing");
        q6.setAlternativas(
                "Hashing",
                "Criptografia simétrica",
                "Criptografia assimétrica",
                "Firewall"
        );
        adicionarQuestao(q6);

        // Tema: Inteligência Artificial
        Questao q7 = new Questao("Inteligência Artificial",
                "Qual é o nome do algoritmo de aprendizado supervisionado que divide os dados em grupos?",
                "Difícil",
                "Árvore de Decisão");
        q7.setAlternativas(
                "Árvore de Decisão",
                "Redes Neurais",
                "K-Means",
                "Busca em Largura"
        );
        adicionarQuestao(q7);

        // Tema: Desenvolvimento Web
        Questao q8 = new Questao("Desenvolvimento Web",
                "Qual linguagem é usada principalmente para estilização de páginas web?",
                "Fácil",
                "CSS");
        q8.setAlternativas(
                "HTML",
                "JavaScript",
                "CSS",
                "Python"
        );
        adicionarQuestao(q8);

        // Tema: Sistemas Operacionais
        Questao q9 = new Questao("Sistemas Operacionais",
                "Qual é o principal responsável pelo gerenciamento de processos em um SO?",
                "Normal",
                "Escalonador");
        q9.setAlternativas(
                "Escalonador",
                "Gerenciador de Memória",
                "Shell",
                "BIOS"
        );
        adicionarQuestao(q9);

        // Tema: Arquitetura de Computadores
        Questao q10 = new Questao("Arquitetura de Computadores",
                "O que é a Unidade Lógica e Aritmética (ULA)?",
                "Normal",
                "A parte do processador responsável por operações matemáticas e lógicas.");
        q10.setAlternativas(
                "A parte do processador responsável por operações matemáticas e lógicas.",
                "O componente que armazena dados temporários durante a execução do programa.",
                "O circuito que controla a interação entre a CPU e a memória.",
                "A unidade de gerenciamento de energia do processador."
        );
        adicionarQuestao(q10);
    }
}
