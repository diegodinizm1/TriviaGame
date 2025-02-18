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
                "Classes, Objetos, Métodos e Atributos",
                "Instanciação, Modularização, Polimorfismo e Herança",
                "Abstração, Herança, Polimorfismo e Encapsulamento",
                "Abstração, Modularidade, Encapsulamento e Delegação"
        );
        adicionarQuestao(q1);

        // Tema: Estruturas de Dados
        Questao q2 = new Questao("Estruturas de Dados",
                "Qual estrutura de dados utiliza o conceito LIFO (Last In, First Out)?",
                "Normal",
                "Pilha");
        q2.setAlternativas(
                "Fila",
                "Lista Encadeada",
                "Pilha",
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
                "UPDATE",
                "DELETE",
                "DROP",
                "SELECT"
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
                "Criptografia simétrica",
                "Criptografia assimétrica",
                "Hashing",
                "Firewall"
        );
        adicionarQuestao(q6);

        // Tema: Inteligência Artificial
        Questao q7 = new Questao("Inteligência Artificial",
                "Qual é o nome do algoritmo de aprendizado supervisionado que divide os dados em grupos?",
                "Difícil",
                "Árvore de Decisão");
        q7.setAlternativas(
                "Redes Neurais",
                "K-Means",
                "Busca em Largura",
                "Árvore de Decisão"
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
                "O componente que armazena dados temporários durante a execução do programa.",
                "A parte do processador responsável por operações matemáticas e lógicas.",
                "O circuito que controla a interação entre a CPU e a memória.",
                "A unidade de gerenciamento de energia do processador."
        );
        adicionarQuestao(q10);

        Questao q11 = new Questao("Programação Orientada a Objetos",
                "Qual é a diferença entre classe e objeto?",
                "Fácil",
                "Classe é o molde e objeto é a instância da classe.");
        q11.setAlternativas(
                "Classe é a instância e objeto é o molde da classe.",
                "Classe é o objeto e objeto é a classe.",
                "Classe é a instância e objeto é o molde da classe.",
                "Classe é o molde e objeto é a instância da classe."
        );
        adicionarQuestao(q11);

        Questao q12 = new Questao("Programação Orientada a Objetos",
                "O que é polimorfismo?",
                "Normal",
                "Capacidade de um objeto poder ser referenciado de várias formas.");
        q12.setAlternativas(
                "Capacidade de um objeto poder ser referenciado de uma única forma.",
                "Capacidade de um objeto poder ser referenciado de várias formas.",
                "Capacidade de um objeto poder ser referenciado de várias classes.",
                "Capacidade de um objeto poder ser referenciado de várias interfaces."
        );
        adicionarQuestao(q12);

        Questao q13 = new Questao("Programação Orientada a Objetos",
                "O que é encapsulamento?",
                "Fácil",
                "Ocultar o estado interno de um objeto e expor apenas o necessário.");
        q13.setAlternativas(
                "Expor o estado interno de um objeto e ocultar o necessário.",
                "Ocultar o estado interno de um objeto e expor tudo.",
                "Expor o estado interno de um objeto e ocultar tudo.",
                "Ocultar o estado interno de um objeto e expor apenas o necessário."
        );
        adicionarQuestao(q13);

        Questao q14 = new Questao("Programação Orientada a Objetos",
                "O que é herança?",
                "Normal",
                "Capacidade de criar uma nova classe a partir de uma já existente.");
        q14.setAlternativas(
                "Capacidade de criar uma nova classe a partir de uma interface.",
                "Capacidade de criar uma nova classe a partir de uma já existente.",
                "Capacidade de criar uma nova interface a partir de uma já existente.",
                "Capacidade de criar uma nova interface a partir de uma classe."
        );
        adicionarQuestao(q14);

        Questao q15 = new Questao("Estruturas de Dados",
                "O que é uma pilha?",
                "Fácil",
                "Estrutura de dados que segue o princípio LIFO.");
        q15.setAlternativas(
                "Estrutura de dados que segue o princípio FIFOUL.",
                "Estrutura de dados que se acumula.",
                "Estrutura de dados que segue o princípio LIFO.",
                "Estrutura de dados que segue o princípio de arvore binária."
        );
        adicionarQuestao(q15);

        //Tema: desenvolvimento web
        Questao q16 = new Questao("Desenvolvimento Web",
                "Quais são as três principais tecnologias utilizadas no desenvolvimento de páginas web?",
                "Normal",
                "HTML, CSS e JavaScript");
        q16.setAlternativas(
                "Java, Python e C++",
                "PHP, Ruby e C#",
                "HTML, CSS e JavaScript",
                "C, C++ e Assembly"
        );
        adicionarQuestao(q16);

        Questao q17 = new Questao("Desenvolvimento Web",
                "O que é um site responsivo?",
                "Fácil",
                "Um site que se adapta a diferentes tamanhos de tela e dispositivos.");
        q17.setAlternativas(
                "Um site que responde a comandos de voz.",
                "Um site que se adapta a diferentes tamanhos de tela e dispositivos.",
                "Um site que responde a comandos de gestos.",
                "Um site que responde a comandos de teclado."
        );
        adicionarQuestao(q17);

        Questao q18 = new Questao("Desenvolvimento Web",
                "O que é um framework?",
                "Normal",
                "Conjunto de bibliotecas e ferramentas que facilitam o desenvolvimento de software.");
        q18.setAlternativas(
                "Conjunto de classes e métodos que facilitam o desenvolvimento de software.",
                "Conjunto de funções e métodos que facilitam o desenvolvimento de software.",
                "Conjunto de bibliotecas e ferramentas que facilitam o desenvolvimento de software.",
                "Conjunto de classes e funções que facilitam o desenvolvimento de software."
        );
        adicionarQuestao(q18);

        Questao q19 = new Questao("Desenvolvimento Web",
                "O que é um servidor web?",
                "Normal",
                "Software que recebe requisições HTTP e envia respostas.");
        q19.setAlternativas(
                "Software que envia requisições HTTP e recebe respostas.",
                "Software que envia e recebe requisições HTTP.",
                "Software que envia e recebe respostas HTTP.",
                "Software que recebe requisições HTTP e envia respostas."
        );
        adicionarQuestao(q19);

        Questao q20 = new Questao("Desenvolvimento Web",
                "O que é um banco de dados?",
                "Fácil",
                "Conjunto de dados organizados de forma estruturada.");
        q20.setAlternativas(
                "Conjunto de dados organizados de forma linear.",
                "Conjunto de dados organizados de forma hierárquica.",
                "Conjunto de dados organizados de forma aleatória.",
                "Conjunto de dados organizados de forma estruturada."
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
                "Programa em espera.",
                "Programa em execução.",
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
                "Mecanismo de sincronização de threads.",
                "Mecanismo de sincronização de recursos.",
                "Mecanismo de sincronização de eventos.",
                "Mecanismo de sincronização de processos."
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
                "Campo da ciência da computação que estuda a criação de programas humanos.",
                "Campo da ciência da computação que estuda a criação de sistemas humanos.",
                "Campo da ciência da computação que estuda a criação de máquinas inteligentes.",
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
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem dados rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados não rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados parcialmente rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados rotulados."
        );
        adicionarQuestao(q29);

        Questao q30 = new Questao("Inteligência Artificial",
                "O que é aprendizado não supervisionado?",
                "Normal",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem dados rotulados.");
        q30.setAlternativas(
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem dados rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados não rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com dados parcialmente rotulados."
        );
        adicionarQuestao(q30);

        Questao q31 = new Questao("Inteligência Artificial",
                "O que é aprendizado por reforço?",
                "Normal",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em recompensas.");
        q31.setAlternativas(
                "Tipo de aprendizado de máquina em que o algoritmo é treinado sem base em recompensas.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em recompensas.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em dados não rotulados.",
                "Tipo de aprendizado de máquina em que o algoritmo é treinado com base em dados parcialmente rotulados."
        );
        adicionarQuestao(q31);

        Questao q32 = new Questao("Inteligência Artificial",
                "O que é uma rede neural?",
                "Normal",
                "Modelo computacional inspirado no cérebro humano.");
        q32.setAlternativas(
                "Modelo computacional inspirado no sistema nervoso central.",
                "Modelo computacional inspirado no sistema nervoso periférico.",
                "Modelo computacional inspirado no cérebro humano.",
                "Modelo computacional inspirado no sistema nervoso central e periférico."
        );
        adicionarQuestao(q32);

        Questao q33 = new Questao("Inteligência Artificial",
                "O que é deep learning?",
                "Normal",
                "Subcampo da inteligência artificial que estuda redes neurais profundas.");
        q33.setAlternativas(
                "Subcampo da inteligência artificial que estuda redes neurais simples.",
                "Subcampo da inteligência artificial que estuda redes neurais artificiais.",
                "Subcampo da inteligência artificial que estuda redes neurais evolutivas.",
                "Subcampo da inteligência artificial que estuda redes neurais profundas."
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
                "Medida do tempo de execução de um algoritmo em função do número de bits.",
                "Medida do tempo de execução de um algoritmo em função do número de operações.",
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
                "Medida do tempo de execução e espaço de memória utilizados por um algoritmo."
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
                "Medida do tempo de execução de um algoritmo no pior cenário.",
                "Medida do tempo de execução de um algoritmo no pior cenário em função do número de operações e bits."
        );
        adicionarQuestao(q38);

        //Tema: Segurança da informação

        Questao q39 = new Questao("Segurança da Informação",
                "O que é criptografia?",
                "Normal",
                "Técnica de codificação de informações para proteger sua confidencialidade.");
        q39.setAlternativas(
                "Técnica de codificação de dados para proteger sua confidencialidade.",
                "Técnica de criptografia de dados para proteger sua integridade.",
                "Técnica de criptografia de dados para proteger sua confidencialidade.",
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
                "Identificador único de um dispositivo em um sistema.",
                "Identificador único de um dispositivo em uma rede.",
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

        //Tema: Segurança da Informação
        Questao q53 = new Questao("Segurança da Informação",
                "O que é um ataque de engenharia social?",
                "Difícil",
                "Ataque que explora a confiança de uma pessoa para obter informações confidenciais.");
        q53.setAlternativas(
                "Ataque que tenta alterar o comportamento de um computador.",
                "Ataque que tenta alterar o conteúdo de um arquivo.",
                "Ataque que tenta alterar o conteúdo de um arquivo e alterar o comportamento de um computador.",
                "Ataque que explora a confiança de uma pessoa para obter informações confidenciais."
        );
        adicionarQuestao(q53);

        //Tema: inteligência artificial
        Questao q54 = new Questao("Inteligência Artificial",
                "O que é um chatbot?",
                "Normal",
                "Programa de computador que simula uma conversa com humanos.");
        q54.setAlternativas(
                "Programa de computador que simula uma conversa com humanos.",
                "Programa de computador que utiliza técnicas de inteligência artificial.",
                "Programa de computador que utiliza técnicas de aprendizado de máquina.",
                "Programa de computador que utiliza técnicas de inteligência artificial e aprendizado de máquina."
        );
        adicionarQuestao(q54);

        //Tema: Inteligência artificial
        Questao q55 = new Questao("Inteligência Artificial",
                "O que é um agente inteligente?",
                "Normal",
                "Entidade que percebe seu ambiente e age para atingir seus objetivos.");
        q55.setAlternativas(
                "Programa de computador que utiliza técnicas de inteligência artificial.",
                "Programa de computador que utiliza técnicas de aprendizado de máquina.",
                "Entidade que percebe seu ambiente e age para atingir seus objetivos.",
                "Programa de computador que utiliza técnicas de inteligência artificial e aprendizado de máquina."
        );
        adicionarQuestao(q55);


        //Tema: Inteligência artificial
        Questao q56 = new Questao("Inteligência Artificial",
                "O que é um sistema especialista?",
                "Normal",
                "Programa de computador que simula o raciocínio humano em um domínio específico.");
        q56.setAlternativas(
                "Programa de computador que utiliza técnicas de aprendizado de máquina.",
                "Programa de computador que utiliza técnicas de inteligência artificial.",
                "Programa de computador que utiliza técnicas de inteligência artificial e aprendizado de máquina.",
                "Programa de computador que simula o raciocínio humano em um domínio específico."

        );
        adicionarQuestao(q56);

        //Tema: Estrutura de dados
        Questao q57 = new Questao("Estruturas de Dados",
                "O que é uma fila?",
                "Normal",
                "Estrutura de dados que segue o princípio FIFO.");
        q57.setAlternativas(
                "Estrutura de dados que segue o princípio LIFO.",
                "Estrutura de dados que segue o princípio FIFO.",
                "Estrutura de dados que segue o princípio LIFO e não permite remoção.",
                "Estrutura de dados que segue o princípio LIFO e não permite inserção."
        );
        adicionarQuestao(q57);

        //Tema: Estrutura de dados
        Questao q58 = new Questao("Estruturas de Dados",
                "O que é uma árvore binária?",
                "Normal",
                "Estrutura de dados em que cada nó tem no máximo dois filhos.");
        q58.setAlternativas(
                "Estrutura de dados em que cada nó tem no máximo três filhos.",
                "Estrutura de dados em que cada nó tem no máximo dois filhos.",
                "Estrutura de dados em que cada nó tem no máximo dois filhos e não permite remoção.",
                "Estrutura de dados em que cada nó tem no máximo três filhos e não permite remoção."
        );
        adicionarQuestao(q58);

        //Tema: banco de dados
        Questao q59 = new Questao("Banco de Dados",
                "O que é um banco de dados relacional?",
                "Normal",
                "Banco de dados que armazena dados em tabelas relacionadas.");
        q59.setAlternativas(
                "Banco de dados que armazena dados em estruturas de dados não relacionais.",
                "Banco de dados que armazena dados em tabelas relacionadas.",
                "Banco de dados que armazena dados em estruturas de dados não relacionais e não permite a criação de chaves primárias.",
                "Banco de dados que armazena dados em estruturas de dados não relacionais e não permite a criação de chaves estrangeiras."
        );
        adicionarQuestao(q59);

        //Tema: banco de dados
        Questao q60 = new Questao("Banco de Dados",
                "O que é uma chave primária?",
                "Normal",
                "Atributo que identifica unicamente uma tupla em uma tabela.");
        q60.setAlternativas(
                "Atributo que identifica unicamente uma tabela em um banco de dados.",
                "Atributo que identifica unicamente uma tupla em uma tabela.",
                "Atributo que identifica unicamente um banco de dados.",
                "Atributo que identifica unicamente um registro em um banco de dados."
        );
        adicionarQuestao(q60);

        //Tema: Segurança da informação
        Questao q61 = new Questao("Segurança da Informação",
                "O que é um ataque de negação de serviço (DDoS)?",
                "Normal",
                "Ataque que sobrecarrega um servidor com um grande volume de tráfego.");
        q61.setAlternativas(
                "Ataque que tenta alterar o comportamento de um computador.",
                "Ataque que tenta alterar o conteúdo de um arquivo.",
                "Ataque que tenta alterar o conteúdo de um arquivo e alterar o comportamento de um computador.",
                "Ataque que sobrecarrega um servidor com um grande volume de tráfego."
        );
        adicionarQuestao(q61);

        //Tema: Segurança da informação
        Questao q62 = new Questao("Segurança da Informação",
                "O que é um ataque de força bruta?",
                "Normal",
                "Ataque que tenta adivinhar uma senha por tentativa e erro.");
        q62.setAlternativas(
                "Ataque que tenta adivinhar uma senha por tentativa e erro.",
                "Ataque que tenta alterar o comportamento de um computador.",
                "Ataque que tenta alterar o conteúdo de um arquivo.",
                "Ataque que tenta alterar o conteúdo de um arquivo e alterar o comportamento de um computador."
        );
        adicionarQuestao(q62);

        //Tema: Segurança da informação
        Questao q63 = new Questao("Segurança da Informação",
                "O que é um ataque de phishing?",
                "Normal",
                "Ataque que tenta enganar uma pessoa para obter informações confidenciais.");
        q63.setAlternativas(
                "Ataque que tenta alterar o comportamento de um computador.",
                "Ataque que tenta alterar o conteúdo de um arquivo.",
                "Ataque que tenta alterar o conteúdo de um arquivo e alterar o comportamento de um computador.",
                "Ataque que tenta enganar uma pessoa para obter informações confidenciais."
        );
        adicionarQuestao(q63);

        //Tema: Algoritmos e complexidade
        Questao q64 = new Questao("Algoritmos e Complexidade",
                "O que significa um algoritmo ter complexidade O(1)?",
                "Normal",
                "O tempo de execução do algoritmo não depende do tamanho da entrada.");
        q64.setAlternativas(
                "O tempo de execução do algoritmo cresce linearmente com o tamanho da entrada.",
                "O tempo de execução do algoritmo cresce exponencialmente com o tamanho da entrada.",
                "O tempo de execução do algoritmo não depende do tamanho da entrada.",
                "O tempo de execução do algoritmo dobra a cada novo elemento na entrada."
        );
        adicionarQuestao(q64);

        //Tema: Algoritmos e complexidade

        Questao q65 = new Questao("Algoritmos e Complexidade",
                "Qual é a complexidade de tempo do algoritmo de busca binária?",
                "Normal",
                "O(log n)");
        q65.setAlternativas(
                "O(n)",
                "O(n log n)",
                "O(log n)",
                "O(1)"
        );
        adicionarQuestao(q65);

        //Tema: Algoritmos e complexidade
        Questao q66 = new Questao("Algoritmos e Complexidade",
                "Qual algoritmo de ordenação tem complexidade média O(n log n)?",
                "Normal",
                "Merge Sort");
        q66.setAlternativas(
                "Bubble Sort",
                "Insertion Sort",
                "Merge Sort",
                "Selection Sort"
        );
        adicionarQuestao(q66);

        //Tema: Algoritmos e complexidade
        Questao q69 = new Questao("Algoritmos e Complexidade",
                "O que caracteriza um problema de complexidade NP-completo?",
                "Normal",
                "Problemas para os quais não se conhece um algoritmo eficiente de tempo polinomial, mas cuja solução pode ser verificada rapidamente.");
        q69.setAlternativas(
                "Problemas que podem ser resolvidos em tempo constante.",
                "Problemas que podem ser resolvidos em tempo linear.",
                "Problemas para os quais não se conhece um algoritmo eficiente de tempo polinomial, mas cuja solução pode ser verificada rapidamente.",
                "Problemas que sempre podem ser resolvidos em tempo O(n log n)."
        );
        adicionarQuestao(q69);

        //Tema: Programação orientada a objetos
        Questao q70 = new Questao("Programação Orientada a Objetos",
                "O que é uma classe em POO?",
                "Fácil",
                "Um modelo ou estrutura que define atributos e métodos para objetos.");
        q70.setAlternativas(
                "Um objeto específico dentro do código.",
                "Um tipo de variável que armazena apenas números inteiros.",
                "Um modelo ou estrutura que define atributos e métodos para objetos.",
                "Uma função que pode ser reutilizada em diferentes partes do código."
        );
        adicionarQuestao(q70);

        //Tema: Programação orientada a objetos
        Questao q71 = new Questao("Programação Orientada a Objetos",
                "Qual dos conceitos abaixo representa melhor a ideia de encapsulamento?",
                "Normal",
                "Restringir o acesso direto aos atributos de um objeto, permitindo a manipulação apenas através de métodos.");
        q71.setAlternativas(
                "Permitir que todas as classes acessem livremente os atributos de um objeto.",
                "Criar métodos estáticos para evitar a criação de instâncias.",
                "Restringir o acesso direto aos atributos de um objeto, permitindo a manipulação apenas através de métodos.",
                "Garantir que todas as classes herdam os atributos da classe pai."
        );
        adicionarQuestao(q71);


        //Tema: Programação orientada a objetos
        Questao q72 = new Questao("Programação Orientada a Objetos",
                "O que acontece se uma classe filha sobrescreve um método da classe pai em Java e não utiliza @Override?",
                "Difícil",
                "O código compila normalmente, mas pode causar erros inesperados se a assinatura do método for diferente da esperada.");
        q72.setAlternativas(
                "O código não compila, pois @Override é obrigatório.",
                "O código compila normalmente e funciona exatamente igual.",
                "O código compila normalmente, mas pode causar erros inesperados se a assinatura do método for diferente da esperada.",
                "O método da classe pai nunca será chamado, pois @Override é necessário para vinculação dinâmica."
        );
        adicionarQuestao(q72);

        //Tema: Programação orientada a objetos
        Questao q73 = new Questao("Programação Orientada a Objetos",
                "O que significa instanciar um objeto em POO?",
                "Fácil",
                "Criar uma instância de uma classe utilizando o operador 'new'.");
        q73.setAlternativas(
                "Excluir um objeto da memória.",
                "Criar uma instância de uma classe utilizando o operador 'new'.",
                "Copiar todos os métodos de uma classe para outra.",
                "Modificar os atributos de um objeto existente."
        );
        adicionarQuestao(q73);

        //Tema: Programação orientada a objetos
        Questao q74 = new Questao("Programação Orientada a Objetos",
                "Qual a principal diferença entre herança e composição?",
                "Normal",
                "Herança define uma relação 'é um', enquanto composição define uma relação 'tem um'.");
        q74.setAlternativas(
                "Herança e composição são sinônimos em POO.",
                "Herança define uma relação 'é um', enquanto composição define uma relação 'tem um'.",
                "A composição só pode ser usada em linguagens funcionais.",
                "A herança permite que um objeto tenha múltiplos estados ao mesmo tempo."
        );
        adicionarQuestao(q74);

        //Tema: Programação orientada a objetos
        Questao q75 = new Questao("Programação Orientada a Objetos",
                "O que acontece quando um método é marcado como final em Java?",
                "Difícil",
                "O método não pode ser sobrescrito por subclasses.");
        q75.setAlternativas(
                "O método não pode ser chamado por outras classes.",
                "O método não pode ser sobrescrito por subclasses.",
                "O método se torna abstrato e precisa ser implementado em subclasses.",
                "O método pode ser chamado sem a necessidade de instanciar um objeto."
        );
        adicionarQuestao(q75);

        //Tema: Sistemas Operacionais
        Questao q76 = new Questao("Sistemas Operacionais",
                "Qual é a principal função de um sistema operacional?",
                "Fácil",
                "Gerenciar recursos de hardware e software, permitindo a comunicação entre usuário e máquina.");
        q76.setAlternativas(
                "Executar apenas programas de terceiros.",
                "Gerenciar recursos de hardware e software, permitindo a comunicação entre usuário e máquina.",
                "Apenas fornecer uma interface gráfica para o usuário.",
                "Gerenciar redes e conexões de internet exclusivamente."
        );
        adicionarQuestao(q76);

        //Tema: Sistemas Operacionais
        Questao q77 = new Questao("Sistemas Operacionais",
                "O que é multiprogramação em sistemas operacionais?",
                "Normal",
                "A capacidade de executar múltiplos processos simultaneamente para melhor utilização da CPU.");
        q77.setAlternativas(
                "A execução de apenas um processo por vez.",
                "A capacidade de executar múltiplos processos simultaneamente para melhor utilização da CPU.",
                "A divisão de um único processo em várias threads.",
                "A execução de múltiplos sistemas operacionais ao mesmo tempo na mesma máquina."
        );
        adicionarQuestao(q77);

        //Tema: Sistemas Operacionais
        Questao q78 = new Questao("Sistemas Operacionais",
                "O que acontece quando ocorre um deadlock em um sistema operacional?",
                "Difícil",
                "Dois ou mais processos ficam bloqueados indefinidamente esperando por recursos que nunca serão liberados.");
        q78.setAlternativas(
                "Dois ou mais processos são finalizados automaticamente pelo sistema.",
                "O sistema operacional reinicia automaticamente para evitar a falha.",
                "Dois ou mais processos ficam bloqueados indefinidamente esperando por recursos que nunca serão liberados.",
                "O sistema operacional aloca mais memória para evitar o problema."
        );
        adicionarQuestao(q78);

        //Tema: Sistemas Operacionais
        Questao q79 = new Questao("Sistemas Operacionais",
                "O que é um sistema operacional de tempo real?",
                "Fácil",
                "Um sistema projetado para processar e responder a eventos dentro de prazos rigorosos.");
        q79.setAlternativas(
                "Um sistema operacional que só funciona em servidores.",
                "Um sistema operacional que exige atualizações diárias.",
                "Um sistema projetado para processar e responder a eventos dentro de prazos rigorosos.",
                "Um sistema operacional exclusivo para smartphones."
        );
        adicionarQuestao(q79);

        //Tema: Sistemas Operacionais
        Questao q80 = new Questao("Sistemas Operacionais",
                "Qual é a principal diferença entre escalonamento preemptivo e não preemptivo?",
                "Normal",
                "No preemptivo, o sistema pode interromper um processo em execução, enquanto no não preemptivo, um processo só libera a CPU voluntariamente.");
        q80.setAlternativas(
                "No escalonamento preemptivo, todos os processos são executados ao mesmo tempo.",
                "No escalonamento não preemptivo, o sistema operacional pode interromper um processo a qualquer momento.",
                "No preemptivo, o sistema pode interromper um processo em execução, enquanto no não preemptivo, um processo só libera a CPU voluntariamente.",
                "No não preemptivo, o sistema operacional escolhe qual processo deve ser finalizado primeiro."
        );
        adicionarQuestao(q80);

        //Tema: Tecnologia da Informação
        Questao q81 = new Questao("Sistemas Operacionais",
                "Qual estratégia de gerenciamento de memória reduz a fragmentação interna?",
                "Difícil",
                "Paginação, pois divide a memória em blocos fixos menores chamados páginas.");
        q81.setAlternativas(
                "Segmentação, pois divide a memória em blocos de diferentes tamanhos.",
                "Memória virtual, pois armazena parte dos processos no disco rígido.",
                "Paginação, pois divide a memória em blocos fixos menores chamados páginas.",
                "Swapping, pois move processos inteiros entre RAM e disco rígido."
        );
        adicionarQuestao(q81);


        //Tema: Redes de Computadores
        Questao q82 = new Questao("Redes de Computadores",
                "O que é um endereço IP?",
                "Fácil",
                "Um identificador único atribuído a um dispositivo em uma rede para comunicação.");
        q82.setAlternativas(
                "O nome de um dispositivo conectado à internet.",
                "Um identificador único atribuído a um dispositivo em uma rede para comunicação.",
                "Um protocolo de segurança para redes sem fio.",
                "Uma tecnologia usada apenas para redes privadas."
        );
        adicionarQuestao(q82);

        //Tema: Redes de Computadores
        Questao q83 = new Questao("Redes de Computadores",
                "Qual das alternativas representa corretamente o modelo OSI?",
                "Normal",
                "Aplicação, Apresentação, Sessão, Transporte, Rede, Enlace e Física.");
        q83.setAlternativas(
                "Física, Rede, Transporte, Sessão, Apresentação e Aplicação.",
                "Aplicação, Apresentação, Sessão, Transporte, Rede, Enlace e Física.",
                "Aplicação, Transporte, Rede, Física, Enlace e Sessão.",
                "Rede, Transporte, Aplicação, Enlace, Sessão e Física."
        );
        adicionarQuestao(q83);

        //Tema: Redes de Computadores
        Questao q84 = new Questao("Redes de Computadores",
                "Qual a principal diferença entre TCP e UDP?",
                "Difícil",
                "O TCP é orientado à conexão e garante entrega confiável, enquanto o UDP é não orientado à conexão e não garante entrega confiável.");
        q84.setAlternativas(
                "O UDP é mais lento que o TCP devido ao controle de erro adicional.",
                "O TCP é usado apenas para redes locais, enquanto o UDP é usado para internet.",
                "O TCP é orientado à conexão e garante entrega confiável, enquanto o UDP é não orientado à conexão e não garante entrega confiável.",
                "O UDP pode ser usado apenas para streaming de vídeo, enquanto o TCP é usado para qualquer tipo de comunicação."
        );
        adicionarQuestao(q84);

        //Tema: Redes de Computadores
        Questao q85 = new Questao("Redes de Computadores",
                "O que é um roteador em uma rede de computadores?",
                "Fácil",
                "Um dispositivo que encaminha pacotes de dados entre diferentes redes.");
        q85.setAlternativas(
                "Um dispositivo que armazena arquivos na nuvem.",
                "Um software que protege redes de ataques cibernéticos.",
                "Um dispositivo que encaminha pacotes de dados entre diferentes redes.",
                "Um cabo de conexão entre servidores e dispositivos."
        );
        adicionarQuestao(q85);

        //Tema: Redes de Computadores
        Questao q86 = new Questao("Redes de Computadores",
                "O que é NAT (Network Address Translation)?",
                "Normal",
                "Um método usado para mapear múltiplos endereços IP privados para um único endereço IP público.");
        q86.setAlternativas(
                "Uma técnica de segurança que impede o tráfego de pacotes desconhecidos.",
                "Um método usado para mapear múltiplos endereços IP privados para um único endereço IP público.",
                "Um protocolo de roteamento dinâmico usado em redes grandes.",
                "Uma configuração utilizada para garantir que pacotes sempre cheguem ao destino correto sem erros."
        );
        adicionarQuestao(q86);

        //Tema: Redes de Computadores
        Questao q87 = new Questao("Redes de Computadores",
                "O que é uma VPN (Virtual Private Network) e qual seu principal objetivo?",
                "Difícil",
                "Criar uma conexão segura e criptografada entre redes públicas e privadas.");
        q87.setAlternativas(
                "Criar redes de alta velocidade para jogos online.",
                "Apenas mascarar o endereço IP do usuário para dificultar rastreamento.",
                "Criar uma conexão segura e criptografada entre redes públicas e privadas.",
                "Permitir que dispositivos diferentes compartilhem arquivos sem conexão com a internet."
        );
        adicionarQuestao(q87);


        //Tema: Arquitetura de Computadores
        Questao q88 = new Questao("Arquitetura de Computadores",
                "Qual é a função principal da Unidade Central de Processamento (CPU)?",
                "Fácil",
                "Executar instruções e processar dados de acordo com os programas em execução.");
        q88.setAlternativas(
                "Gerenciar dispositivos de entrada e saída.",
                "Executar instruções e processar dados de acordo com os programas em execução.",
                "Armazenar permanentemente os arquivos do sistema operacional.",
                "Controlar apenas a memória RAM do computador."
        );
        adicionarQuestao(q88);

        //Tema: Arquitetura de Computadores
        Questao q89 = new Questao("Arquitetura de Computadores",
                "O que caracteriza uma arquitetura Von Neumann?",
                "Normal",
                "A utilização de uma única memória para armazenar dados e instruções.");
        q89.setAlternativas(
                "A separação de memória entre dados e instruções.",
                "O uso de múltiplos processadores para execução paralela.",
                "A utilização de uma única memória para armazenar dados e instruções.",
                "A execução de múltiplas instruções simultaneamente em um único núcleo."
        );
        adicionarQuestao(q89);

        //Tema: Arquitetura de Computadores
        Questao q90 = new Questao("Arquitetura de Computadores",
                "Qual das seguintes afirmações sobre pipelines em processadores está correta?",
                "Difícil",
                "O pipeline permite a execução simultânea de diferentes estágios de várias instruções, aumentando o desempenho do processador.");
        q90.setAlternativas(
                "O pipeline reduz o número de instruções que um processador pode executar.",
                "O pipeline permite a execução simultânea de diferentes estágios de várias instruções, aumentando o desempenho do processador.",
                "O pipeline impede que o processador execute instruções fora de ordem.",
                "O pipeline elimina a necessidade de memória cache no processador."
        );
        adicionarQuestao(q90);

        //Tema: Arquitetura de Computadores
        Questao q91 = new Questao("Arquitetura de Computadores",
                "O que é memória RAM?",
                "Fácil",
                "Um tipo de memória volátil usada para armazenar temporariamente dados e programas em execução.");
        q91.setAlternativas(
                "Uma memória de armazenamento permanente para salvar arquivos.",
                "Um tipo de memória volátil usada para armazenar temporariamente dados e programas em execução.",
                "Um componente responsável pelo processamento gráfico.",
                "Um dispositivo de armazenamento de longa duração, como um SSD."
        );
        adicionarQuestao(q91);

        //Tema: Arquitetura de Computadores
        Questao q92 = new Questao("Arquitetura de Computadores",
                "Qual a principal função da memória cache em um processador?",
                "Normal",
                "Armazenar dados frequentemente acessados para reduzir o tempo de busca na memória RAM.");
        q92.setAlternativas(
                "Ampliar a capacidade de armazenamento do computador.",
                "Armazenar dados frequentemente acessados para reduzir o tempo de busca na memória RAM.",
                "Criar backups automáticos do sistema operacional.",
                "Substituir a RAM quando ela estiver cheia."
        );
        adicionarQuestao(q92);

        //Tema: Arquitetura de Computadores
        Questao q93 = new Questao("Arquitetura de Computadores",
                "Qual é a principal vantagem de um processador RISC em relação a um processador CISC?",
                "Difícil",
                "Instruções mais simples e uniformes, permitindo execução mais rápida e eficiente.");
        q93.setAlternativas(
                "Maior número de transistores, o que melhora a eficiência energética.",
                "Instruções mais simples e uniformes, permitindo execução mais rápida e eficiente.",
                "Suporte nativo para múltiplas arquiteturas de software.",
                "Uso exclusivo em supercomputadores e servidores."
        );
        adicionarQuestao(q93);

        //Tema: Banco de Dados
        Questao q94 = new Questao("Banco de Dados",
                "O que é um Banco de Dados?",
                "Fácil",
                "Um sistema que armazena e organiza dados para fácil acesso e gerenciamento.");
        q94.setAlternativas(
                "Um programa de edição de planilhas.",
                "Um sistema que armazena e organiza dados para fácil acesso e gerenciamento.",
                "Um software usado apenas para criar documentos de texto.",
                "Uma tecnologia exclusiva para redes de computadores."
        );
        adicionarQuestao(q94);

        //Tema: Banco de Dados
        Questao q95 = new Questao("Banco de Dados",
                "O que é uma relação entre tabelas?",
                "Normal",
                "Uma conexão entre duas ou mais tabelas, permitindo relacionar dados de maneira natural.");
        q95.setAlternativas(
                "Uma conexão entre duas ou mais tabelas, permitindo relacionar dados de maneira natural.",
                "Um arquivo de texto que armazena os dados.",
                "Um software usado apenas para criar documentos de texto.",
                "Um sistema que armazena e organiza dados para fácil acesso e gerenciamento."
        );
        adicionarQuestao(q95);

        //Tema: Banco de Dados
        Questao q96 = new Questao("Banco de Dados",
                "O que caracteriza um Banco de Dados NoSQL?",
                "Difícil",
                "Ele não utiliza o modelo relacional e pode armazenar dados em formatos como documentos, chave-valor e grafos.");
        q96.setAlternativas(
                "Ele sempre usa tabelas para armazenar dados.",
                "Ele exige normalização para evitar redundância.",
                "Ele não utiliza o modelo relacional e pode armazenar dados em formatos como documentos, chave-valor e grafos.",
                "Ele não permite consultas complexas nos dados."
        );
        adicionarQuestao(q96);

        //Tema: Banco de Dados
        Questao q97 = new Questao("Banco de Dados",
                "O que é uma chave primária em um banco de dados relacional?",
                "Fácil",
                "Um campo que identifica de forma única cada registro em uma tabela.");
        q97.setAlternativas(
                "Uma coluna usada para armazenar apenas valores nulos.",
                "Um campo que identifica de forma única cada registro em uma tabela.",
                "Uma tabela especial que armazena dados temporários.",
                "Uma função que calcula automaticamente valores dentro da tabela."
        );
        adicionarQuestao(q97);

        //Tema: Banco de Dados
        Questao q98 = new Questao("Banco de Dados",
                "O que significa a normalização em banco de dados?",
                "Normal",
                "Um processo que organiza dados para reduzir redundância e melhorar a integridade dos dados.");
        q98.setAlternativas(
                "A conversão de um banco de dados relacional para NoSQL.",
                "Um processo que organiza dados para reduzir redundância e melhorar a integridade dos dados.",
                "A remoção de índices para melhorar o desempenho.",
                "A divisão de uma tabela grande em várias tabelas menores sem relação entre elas."
        );
        adicionarQuestao(q98);

        //Tema: Banco de Dados
        Questao q99 = new Questao("Banco de Dados",
                "Qual das alternativas descreve corretamente a operação de um índice em um banco de dados?",
                "Difícil",
                "Um índice melhora a velocidade das consultas ao permitir acesso mais rápido aos dados sem precisar percorrer toda a tabela.");
        q99.setAlternativas(
                "Um índice impede a inserção de dados duplicados em uma tabela.",
                "Um índice melhora a velocidade das consultas ao permitir acesso mais rápido aos dados sem precisar percorrer toda a tabela.",
                "Um índice reduz a necessidade de normalização do banco de dados.",
                "Um índice garante que a integridade referencial entre tabelas seja mantida automaticamente."
        );
        adicionarQuestao(q99);

        //Tema: Desencolvimento Web
        Questao q100 = new Questao("Desenvolvimento Web",
                "O que é o conceito de Progressive Web Apps (PWA) e qual sua principal vantagem?",
                "Difícil",
                "PWAs combinam o melhor da web e dos aplicativos nativos, permitindo funcionalidades offline e desempenho aprimorado.");
        q100.setAlternativas(
                "PWAs são aplicativos que funcionam apenas em navegadores específicos.",
                "PWAs combinam o melhor da web e dos aplicativos nativos, permitindo funcionalidades offline e desempenho aprimorado.",
                "PWAs são uma tecnologia exclusiva para dispositivos móveis e não podem ser usados em desktops.",
                "PWAs eliminam completamente a necessidade de um backend para aplicações web."
        );
        adicionarQuestao(q100);

    }


}
