package model;

import java.util.*;

public class Trivia {
    private HashMap<String, ArrayList<Questao>> questoes;
    private ArrayList<Observer> observers;
    private Usuario usuario;
    private Ranking ranking;
    private String dificuldadeEscolhida;
    private int numQuestoes;
    private int numTemas;

    public Trivia() {
        questoes = new HashMap<>();
        observers = new ArrayList<>();
        ranking = new Ranking();
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

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
        notifica();
    }
    public Ranking getRanking() {
        return ranking;
    }

    public String getDificuldadeEscolhida() {
        return dificuldadeEscolhida;
    }

    public void setDificuldadeEscolhida(int dificuldadeEscolhida) {
        if(dificuldadeEscolhida == 1){
            this.dificuldadeEscolhida = "Fácil";
        }else if(dificuldadeEscolhida == 2){
            this.dificuldadeEscolhida = "Normal";
        }else if(dificuldadeEscolhida == 3){
            this.dificuldadeEscolhida = "Difícil";
        }else{
            throw new IllegalArgumentException("Dificuldade escolhida inválida");
        }
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
        if(!questoes.containsKey(questao.getTema().toLowerCase().trim())){
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

        Questao q11 = new Questao("Programação Orientada a Objetos",
                "Qual é a diferença entre classe e objeto?",
                "Fácil",
                "Classe é o molde e objeto é a instância da classe.");
        q11.setAlternativas(
                "Classe é o molde e objeto é a instância da classe.",
                "Classe é a instância e objeto é o molde da classe.",
                "Classe é o objeto e objeto é a classe.",
                "Classe é a instância e objeto é o molde da classe."
        );
        adicionarQuestao(q11);

        Questao q12 = new Questao("Programação Orientada a Objetos",
                "O que é polimorfismo?",
                "Normal",
                "Capacidade de um objeto poder ser referenciado de várias formas.");
        q12.setAlternativas(
                "Capacidade de um objeto poder ser referenciado de várias formas.",
                "Capacidade de um objeto poder ser referenciado de uma única forma.",
                "Capacidade de um objeto poder ser referenciado de várias classes.",
                "Capacidade de um objeto poder ser referenciado de várias interfaces."
        );
        adicionarQuestao(q12);

        Questao q13 = new Questao("Programação Orientada a Objetos",
                "O que é encapsulamento?",
                "Fácil",
                "Ocultar o estado interno de um objeto e expor apenas o necessário.");
        q13.setAlternativas(
                "Ocultar o estado interno de um objeto e expor apenas o necessário.",
                "Expor o estado interno de um objeto e ocultar o necessário.",
                "Ocultar o estado interno de um objeto e expor tudo.",
                "Expor o estado interno de um objeto e ocultar tudo."
        );
        adicionarQuestao(q13);

        Questao q14 = new Questao("Programação Orientada a Objetos",
                "O que é herança?",
                "Normal",
                "Capacidade de criar uma nova classe a partir de uma já existente.");
        q14.setAlternativas(
                "Capacidade de criar uma nova classe a partir de uma já existente.",
                "Capacidade de criar uma nova classe a partir de uma interface.",
                "Capacidade de criar uma nova interface a partir de uma já existente.",
                "Capacidade de criar uma nova interface a partir de uma classe."
        );
        adicionarQuestao(q14);

        Questao q15 = new Questao("Estruturas de Dados",
                "O que é uma pilha?",
                "Fácil",
                "Estrutura de dados que segue o princípio LIFO.");
        q15.setAlternativas(
                "Estrutura de dados que segue o princípio LIFO.",
                "Estrutura de dados que segue o princípio FIFOUL.",
                "Estrutura de dados que se acumula.",
                "Estrutura de dados que segue o princípio de arvore binária."
        );
        adicionarQuestao(q15);

        //Tema: desenvolvimento web
        Questao q16 = new Questao("Desenvolvimento Web",
                "Quais são as três principais tecnologias utilizadas no desenvolvimento de páginas web?",
                "Normal",
                "HTML, CSS e JavaScript");
        q16.setAlternativas(
                "HTML, CSS e JavaScript",
                "Java, Python e C++",
                "PHP, Ruby e C#",
                "C, C++ e Assembly"
        );
        adicionarQuestao(q16);

        Questao q17 = new Questao("Desenvolvimento Web",
                "O que é um site responsivo?",
                "Fácil",
                "Um site que se adapta a diferentes tamanhos de tela e dispositivos.");
        q17.setAlternativas(
                "Um site que se adapta a diferentes tamanhos de tela e dispositivos.",
                "Um site que responde a comandos de voz.",
                "Um site que responde a comandos de gestos.",
                "Um site que responde a comandos de teclado."
        );
        adicionarQuestao(q17);

        Questao q18 = new Questao("Desenvolvimento Web",
                "O que é um framework?",
                "Normal",
                "Conjunto de bibliotecas e ferramentas que facilitam o desenvolvimento de software.");
        q18.setAlternativas(
                "Conjunto de bibliotecas e ferramentas que facilitam o desenvolvimento de software.",
                "Conjunto de classes e métodos que facilitam o desenvolvimento de software.",
                "Conjunto de funções e métodos que facilitam o desenvolvimento de software.",
                "Conjunto de classes e funções que facilitam o desenvolvimento de software."
        );
        adicionarQuestao(q18);

        Questao q19 = new Questao("Desenvolvimento Web",
                "O que é um servidor web?",
                "Normal",
                "Software que recebe requisições HTTP e envia respostas.");
        q19.setAlternativas(
                "Software que recebe requisições HTTP e envia respostas.",
                "Software que envia requisições HTTP e recebe respostas.",
                "Software que envia e recebe requisições HTTP.",
                "Software que envia e recebe respostas HTTP."
        );
        adicionarQuestao(q19);

        Questao q20 = new Questao("Desenvolvimento Web",
                "O que é um banco de dados?",
                "Fácil",
                "Conjunto de dados organizados de forma estruturada.");
        q20.setAlternativas(
                "Conjunto de dados organizados de forma estruturada.",
                "Conjunto de dados organizados de forma linear.",
                "Conjunto de dados organizados de forma hierárquica.",
                "Conjunto de dados organizados de forma aleatória."
        );
        adicionarQuestao(q20);
    }


}
