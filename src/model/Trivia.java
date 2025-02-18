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
        // Tema: Programação Orientada a Objetos
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

        Questao q21 = new Questao("Sistemas Operacionais",
                "O que é um sistema operacional?",
                "Normal",
                "Software que gerencia recursos de hardware e software.");
        q21.setAlternativas(
                "Software que gerencia recursos de hardware e software.",
                "Software que gerencia recursos de hardware.",
                "Software que gerencia recursos de software.",
                "Software que gerencia recursos de rede."
        );
        adicionarQuestao(q21);

        Questao q22 = new Questao("Sistemas Operacionais",
                "O que é um processo?",
                "Normal",
                "Programa em execução.");
        q22.setAlternativas(
                "Programa em execução.",
                "Programa em espera.",
                "Programa em execução e em espera.",
                "Programa em execução e finalizado."
        );
        adicionarQuestao(q22);

        Questao q23 = new Questao("Sistemas Operacionais",
                "O que é um escalonador?",
                "Normal",
                "Módulo do sistema operacional que decide qual processo será executado.");
        q23.setAlternativas(
                "Módulo do sistema operacional que decide qual processo será executado.",
                "Módulo do sistema operacional que decide qual processo será finalizado.",
                "Módulo do sistema operacional que decide qual processo será iniciado.",
                "Módulo do sistema operacional que decide qual processo será interrompido."
        );
        adicionarQuestao(q23);

        Questao q24 = new Questao("Sistemas Operacionais",
                "O que é um thread?",
                "Normal",
                "Processo de execução isolado.");
        q24.setAlternativas(
                "Processo de execução isolado.",
                "Processo de execução comum.",
                "Processo de execução paralelo.",
                "Processo de execução com prioridade."
        );
        adicionarQuestao(q24);

        Questao q25 = new Questao("Sistemas Operacionais",
                "O que é um semáforo?",
                "Normal",
                "Mecanismo de sincronização de processos.");
        q25.setAlternativas(
                "Mecanismo de sincronização de processos.",
                "Mecanismo de sincronização de threads.",
                "Mecanismo de sincronização de recursos.",
                "Mecanismo de sincronização de eventos."
        );
        adicionarQuestao(q25);

        Questao q26 = new Questao("Sistemas Operacionais",
                "O que é um monitor?",
                "Normal",
                "Módulo do sistema operacional que coordena a execução de processos.");
        q26.setAlternativas(
                "Módulo do sistema operacional que coordena a execução de processos.",
                "Módulo do sistema operacional que coordena a execução de threads.",
                "Módulo do sistema operacional que coordena a execução de semáforos.",
                "Módulo do sistema operacional que coordena a execução de eventos."
        );
        adicionarQuestao(q26);

        Questao q27 = new Questao("Inteligência Artificial",
                "O que é inteligência artificial?",
                "Normal",
                "Campo da ciência da computação que estuda a criação de máquinas inteligentes.");
        q27.setAlternativas(
                "Campo da ciência da computação que estuda a criação de máquinas inteligentes.",
                "Campo da ciência da computação que estuda a criação de programas humanos.",
                "Campo da ciência da computação que estuda a criação de sistemas humanos.",
                "Campo da ciência da computação que estuda a criação de programas humanos e sistemas humanos."
        );
        adicionarQuestao(q27);

        Questao q28 = new Questao("Inteligência Artificial",
                "O que é aprendizado de máquina?",
                "Normal",
                "Campo da inteligência artificial que estuda a criação de sistemas que aprendem com dados.");
        q28.setAlternativas(
                "Campo da inteligência artificial que estuda a criação de sistemas que aprendem com dados.",
                "Campo da inteligência artificial que estuda a criação de programas humanos.",
                "Campo da inteligência artificial que estuda a criação de sistemas humanos.",
                "Campo da inteligência artificial que estuda a criação de programas humanos e sistemas humanos."
        );
        adicionarQuestao(q28);

        Questao q29 = new Questao("Inteligência Artificial",
                "O que é aprendizado supervisionado?",
                "Normal",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados rotulados.");
        q29.setAlternativas(
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem dados rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados não rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados parcialmente rotulados."
        );
        adicionarQuestao(q29);

        Questao q30 = new Questao("Inteligência Artificial",
                "O que é aprendizado não supervisionado?",
                "Normal",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem dados rotulados.");
        q30.setAlternativas(
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem dados rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados não rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados parcialmente rotulados."
        );
        adicionarQuestao(q30);

        Questao q31 = new Questao("Inteligência Artificial",
                "O que é aprendizado por reforço?",
                "Normal",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em recompensas.");
        q31.setAlternativas(
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em recompensas.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem base em recompensas.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em dados não rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em dados parcialmente rotulados."
        );
        adicionarQuestao(q31);

        Questao q32 = new Questao("Inteligência Artificial",
                "O que é uma rede neural?",
                "Normal",
                "Modelo computacional inspirado no cérebro humano.");
        q32.setAlternativas(
                "Modelo computacional inspirado no cérebro humano.",
                "Modelo computacional inspirado no sistema nervoso central.",
                "Modelo computacional inspirado no sistema nervoso periférico.",
                "Modelo computacional inspirado no sistema nervoso central e periférico."
        );
        adicionarQuestao(q32);

        Questao q33 = new Questao("Inteligência Artificial",
                "O que é deep learning?",
                "Normal",
                "Subcampo da inteligência artificial que estuda redes neurais profundas.");
        q33.setAlternativas(
                "Subcampo da inteligência artificial que estuda redes neurais profundas.",
                "Subcampo da inteligência artificial que estuda redes neurais simples.",
                "Subcampo da inteligência artificial que estuda redes neurais artificiais.",
                "Subcampo da inteligência artificial que estuda redes neurais evolutivas."
        );
        adicionarQuestao(q33);

        Questao q34 = new Questao("Inteligência Artificial",
                "O que é uma árvore de decisão?",
                "Normal",
                "Modelo de aprendizado supervisionado que divide os dados em grupos.");
        q34.setAlternativas(
                "Modelo de aprendizado supervisionado que divide os dados em grupos.",
                "Modelo de aprendizado supervisionado que divide os dados em classes.",
                "Modelo de aprendizado supervisionado que divide os dados em clusters.",
                "Modelo de aprendizado supervisionado que divide os dados em camadas."
        );
        adicionarQuestao(q34);

        // Tema: Algoritmos e Complexidade
        Questao q35 = new Questao("Algoritmos e Complexidade",
                "O que é complexidade de tempo?",
                "Normal",
                "Medida do tempo de execução de um algoritmo em função do tamanho da entrada.");
        q35.setAlternativas(
                "Medida do tempo de execução de um algoritmo em função do número de operações.",
                "Medida do tempo de execução de um algoritmo em função do número de bits.",
                "Medida do tempo de execução de um algoritmo em função do número de elementos.",
                "Medida do tempo de execução de um algoritmo em função do número de operações e bits."
        );
        adicionarQuestao(q35);


        // Tema: Algoritmos e Complexidade
        Questao q36 = new Questao("Algoritmos e Complexidade",
                "O que é complexidade de espaço?",
                "Normal",
                "Medida do espaço de memória utilizado por um algoritmo em função do tamanho da entrada.");
        q36.setAlternativas(
                "Medida do espaço de memória utilizado por um algoritmo em função do número de bits.",
                "Medida do espaço de memória utilizado por um algoritmo em função do número de operações.",
                "Medida do espaço de memória utilizado por um algoritmo em função do número de elementos.",
                "Medida do espaço de memória utilizado por um algoritmo em função do número de operações e bits."
        );
        adicionarQuestao(q36);

        // Tema: Algoritmos e Complexidade
        Questao q37 = new Questao("Algoritmos e Complexidade",
                "O que é complexidade de tempo e espaço?",
                "Difícil",
                "Medida do tempo de execução e espaço de memória utilizados por um algoritmo.");
        q37.setAlternativas(
                "Medida do tempo de execução e espaço de memória utilizados por um algoritmo em função do número de bits.",
                "Medida do tempo de execução e espaço de memória utilizados por um algoritmo em função do número de operações.",
                "Medida do tempo de execução e espaço de memória utilizados por um algoritmo em função do número de elementos.",
                "Medida do tempo de execução e espaço de memória utilizados por um algoritmo em função do número de operações e bits."
        );
        adicionarQuestao(q37);

        // Tema: Algoritmos e Complexidade
        Questao q38 = new Questao("Algoritmos e Complexidade",
                "O que é complexidade de pior caso?",
                "Normal",
                "Medida do tempo de execução de um algoritmo no pior cenário.");
        q38.setAlternativas(
                "Medida do tempo de execução de um algoritmo no pior cenário em função do número de bits.",
                "Medida do tempo de execução de um algoritmo no pior cenário em função do número de operações.",
                "Medida do tempo de execução de um algoritmo no pior cenário em função do número de elementos.",
                "Medida do tempo de execução de um algoritmo no pior cenário em função do número de operações e bits."
        );
        adicionarQuestao(q38);

        //Tema: Segurança da informação

        Questao q39 = new Questao("Segurança da Informação",
                "O que é criptografia?",
                "Normal",
                "Técnica de codificação de informações para proteger sua confidencialidade.");
        q39.setAlternativas(
                "Técnica de criptografia de dados para proteger sua confidencialidade.",
                "Técnica de codificação de dados para proteger sua confidencialidade.",
                "Técnica de criptografia de dados para proteger sua integridade.",
                "Técnica de criptografia de dados para proteger sua privacidade."
        );
        adicionarQuestao(q39);

        //Tema: Segurança da informação

        Questao q40 = new Questao("Segurança da Informação",
                "O que é criptografia simétrica?",
                "Normal",
                "Técnica de criptografia que usa duas chaves de mesmo tamanho.");
        q40.setAlternativas(
                "Técnica de criptografia que não usa chaves.",
                "Técnica de criptografia que usa chaves de tamanhos diferentes.",
                "Técnica de criptografia que usa duas chaves de mesmo tamanho.",
                "Técnica de criptografia que usa dois chaves de tamanhos diferentes."
        );
        adicionarQuestao(q40);

        //Tema: Segurança da informação
        Questao q41 = new Questao("Segurança da Informação",
                "O que é criptografia assimétrica?",
                "Normal",
                "Técnica de criptografia que usa duas chaves de tamanhos diferentes.");
        q41.setAlternativas(
                "Técnica de criptografia que não usa chaves.",
                "Técnica de criptografia que usa chaves de mesmo tamanho.",
                "Técnica de criptografia que usa duas chaves de tamanhos diferentes.",
                "Técnica de criptografia que usa dois chaves de mesmo tamanho."
        );
        adicionarQuestao(q41);

        //Tema: Segurança da informação
        Questao q42 = new Questao("Segurança da Informação",
                "O que é hashing?",
                "Difícil",
                "Técnica de criptografia que gera um código único para um conjunto de dados.");
        q42.setAlternativas(
                "Técnica de criptografia que gera um código único para um conjunto de dados.",
                "Técnica de criptografia que gera um código único para um conjunto de chaves.",
                "Técnica de criptografia que gera um código único para um conjunto de valores.",
                "Técnica de criptografia que gera um código único para um conjunto de informações."
        );
        adicionarQuestao(q42);

        //Tema: Segurança da informação
        Questao q43 = new Questao("Segurança da Informação",
                "O que é um firewall?",
                "Normal",
                "Sistema de segurança que controla o tráfego de rede.");
        q43.setAlternativas(
                "Sistema de segurança que controla o tráfego de dados.",
                "Sistema de segurança que controla o tráfego de rede.",
                "Sistema de segurança que controla o tráfego de pacotes.",
                "Sistema de segurança que controla o tráfego de dados."
        );
        adicionarQuestao(q43);


        //Tema: Redes de Computadores
        Questao q44 = new Questao("Redes de Computadores",
                "O que é um protocolo?",
                "Normal",
                "Conjunto de regras que define a comunicação entre dispositivos.");
        q44.setAlternativas(
                "Conjunto de regras que define a comunicação entre dispositivos.",
                "Conjunto de regras que define a comunicação entre redes.",
                "Conjunto de regras que define a comunicação entre sistemas.",
                "Conjunto de regras que define a comunicação entre computadores."
        );
        adicionarQuestao(q44);

        //Tema: Redes de Computadores
        Questao q45 = new Questao("Redes de Computadores",
                "O que é um endereço IP?",
                "Normal",
                "Identificador único de um dispositivo em uma rede.");
        q45.setAlternativas(
                "Identificador único de um dispositivo em uma rede.",
                "Identificador único de um dispositivo em um sistema.",
                "Identificador único de um dispositivo em um computador.",
                "Identificador único de um dispositivo em um servidor."
        );
        adicionarQuestao(q45);


        //Tema: Redes de Computadores
        Questao q46 = new Questao("Redes de Computadores",
                "O que é um roteador?",
                "Normal",
                "Dispositivo que encaminha pacotes entre redes.");
        q46.setAlternativas(

                "Dispositivo que encaminha pacotes entre sistemas.",
                "Dispositivo que encaminha pacotes entre computadores.",
                "Dispositivo que encaminha pacotes entre redes.",
                "Dispositivo que encaminha pacotes entre servidores."
        );
        adicionarQuestao(q46);

        //Tema: Redes de Computadores
        Questao q47 = new Questao("Redes de Computadores",
                "O que é um switch?",
                "Normal",
                "Dispositivo que encaminha pacotes entre dispositivos em uma rede.");
        q47.setAlternativas(
                "Dispositivo que encaminha pacotes entre sistemas.",
                "Dispositivo que encaminha pacotes entre computadores.",
                "Dispositivo que encaminha pacotes entre dispositivos em uma rede.",
                "Dispositivo que encaminha pacotes entre servidores."
        );
        adicionarQuestao(q47);

        //Tema: Redes de Computadores
        Questao q48 = new Questao("Redes de Computadores",
                "O que é um modem?",
                "Normal",
                "Dispositivo que converte sinais digitais em analógicos e vice-versa.");
        q48.setAlternativas(
                "Dispositivo que converte sinais digitais em analógicos.",
                "Dispositivo que converte sinais analógicos em digitais.",
                "Dispositivo que converte sinais digitais em analógicos e vice-versa.",
                "Dispositivo que converte sinais analógicos em digitais."
        );
        adicionarQuestao(q48);

        //Tema: Segurança da Informação
        Questao q49 = new Questao("Segurança da Informação",
                "O que é um ataque de negação de serviço (DDoS)?",
                "Normal",
                "Ataque que sobrecarrega um servidor com um grande volume de tráfego.");
        q49.setAlternativas(
                "Ataque que altera o conteúdo de um arquivo.",
                "Ataque que altera o comportamento de um computador.",
                "Ataque que sobrecarrega um servidor com um grande volume de tráfego.",
                "Ataque que altera o conteúdo de um arquivo e altera o comportamento de um computador."
        );
        adicionarQuestao(q49);

        //Tema: Segurança da Informação
        Questao q50 = new Questao("Segurança da Informação",
                "O que é um ataque de força bruta?",
                "Normal",
                "Ataque que tenta adivinhar uma senha por tentativa e erro.");
        q50.setAlternativas(
                "Ataque que tenta adivinhar uma senha por tentativa e erro.",
                "Ataque que altera o comportamento de um computador.",
                "Ataque que altera o conteúdo de um arquivo.",
                "Ataque que altera o conteúdo de um arquivo e altera o comportamento de um computador."
        );
        adicionarQuestao(q50);

        //Tema: Segurança da Informação
        Questao q51 = new Questao("Segurança da Informação",
                "O que é um ataque de phishing?",
                "Normal",
                "Ataque que tenta enganar uma pessoa para obter informações confidenciais.");
        q51.setAlternativas(
                "Ataque que tenta alterar o comportamento de um computador.",
                "Ataque que tenta alterar o conteúdo de um arquivo.",
                "Ataque que tenta alterar o conteúdo de um arquivo e alterar o comportamento de um computador.",
                "Ataque que tenta enganar uma pessoa para obter informações confidenciais."
        );
        adicionarQuestao(q51);

        //Tema: Segurança da Informação
        Questao q52 = new Questao("Segurança da Informação",
                "O que é um ataque de ransomware?",
                "Difícil",
                "Ataque que criptografa arquivos e exige um resgate para liberá-los.");
        q52.setAlternativas(
                "Ataque que tenta alterar o comportamento de um computador.",
                "Ataque que tenta alterar o conteúdo de um arquivo.",
                "Ataque que tenta alterar o conteúdo de um arquivo e alterar o comportamento de um computador.",
                "Ataque que criptografa arquivos e exige um resgate para liberá-los."
        );
        adicionarQuestao(q52);
    }


}
