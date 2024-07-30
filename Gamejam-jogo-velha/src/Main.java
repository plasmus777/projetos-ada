import java.util.Random;
import java.util.Scanner;

public class Main {
    //Início do programa
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String input = ""; //Entrada de dados do usuário
        boolean deveSair = false; //O jogo deve terminar (comando q)?

        String[] jogadores = new String[2]; //Nomes dos jogadores
        int[] pontos = new int[2]; //Pontuações dos jogadores
        int totalPartidas = 0; //Total de partidas jogadas

        //Executar o programa enquanto o usuário não digitar q
        while(!deveSair) {
            //Exibir tela inicial
            mensagemBoasVindas();

            //Exibe informações do jogo, caso hajam partidas realizadas
            if(totalPartidas > 0) {
                exibirPontuacoes(jogadores, pontos, totalPartidas);
            }

            //Obter a entrada inicial do usuário
            input = s.nextLine();

            //Verificar as possíveis entradas do usuário
            switch (input) {
                //O programa deve ser encerrado
                case "q" -> {
                    deveSair = true;
                    System.out.println("*******************************************************");
                    System.out.println("Obrigado por jogar!");
                    System.out.println("*******************************************************");
                    break;
                }

                //O jogo da velha deve ser iniciado - dois jogadores
                case "s" -> {
                    jogoDaVelha(s, jogadores, pontos);
                    totalPartidas++;
                    break;
                }

                //Comando inválido
                default -> {
                    System.out.println("*******************************************************");
                    System.out.println("O comando digitado é inválido!");
                    System.out.println("*******************************************************");
                }
            }
        }
    }

    //Utilizado para limpar o texto no terminal, facilitando a visualização do usuário.
    public static void limparTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mensagemBoasVindas(){
        System.out.println("*******************************************************");
        System.out.println("Jogo da Velha - Versão 1.0");
        System.out.println("Desenvolvido na linguagem java");
        System.out.println("*******************************************************");
        System.out.println("Comandos:");
        System.out.println("s - Iniciar um novo jogo - 2 jogadores");
        System.out.println("q - Sair");
        System.out.println("*******************************************************");
    }

    //Exibe os jogadores registrados, as pontuações atuais de cada jogador e o número de partidas jogadas.
    public static void exibirPontuacoes(String[] jogadores, int[] pontos, int numPartidas){
        System.out.println("*******************************************************");
        System.out.println("Número de partidas jogadas: " + numPartidas);
        System.out.println("----------------------------------------------");
        System.out.println("Jogador 1: " + jogadores[0]);
        System.out.println("Pontuação: " + pontos[0]);
        System.out.println("----------------------------------------------");
        System.out.println("Jogador 2: " + jogadores[1]);
        System.out.println("Pontuação: " + pontos[1]);
        System.out.println("*******************************************************");
    }

    //Início do jogo da velha
    public static void jogoDaVelha(Scanner s, String[] jogadores, int[] pontos){
        limparTerminal();
        System.out.println("*******************************************************");
        System.out.println("Jogo da Velha - Nova Partida");
        System.out.println("*******************************************************");

        //Registrar nomes dos jogadores caso estejam vazios
        if(jogadores[0] == null || jogadores[1] == null) {
            System.out.println("Nome do jogador 1: ");
            jogadores[0] = s.nextLine();
            System.out.println("Nome do jogador 2: ");
            jogadores[1] = s.nextLine();
        }

        //Seleciona o jogador1 ou jogador2 para começar a partida aleatoriamente, e exibe aos jogadores.
        Random random = new Random();
        int jogadorAtual = random.nextInt(1, 3);
        limparTerminal();
        System.out.println("*******************************************************");
        System.out.println("O jogador " + jogadorAtual + " iniciará a partida.");

        int[][] tela = new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}; //Tela do jogo, com posições marcadas pelos jogadores (0 - nenhum; 1 e 2 - símbolos dos jogadores, sendo X ou 0)
        //Execução principal do jogo
        while(true){ //Enquanto o jogo não terminou
            limparTerminal();
            exibirJogadorAtual(jogadorAtual, jogadores);
            exibirTela(tela);

            boolean entradaValida = false; //Verificar se a jogada digitada é válida
            do{
                //Pedir o comando referente à inserção do jogador atual
                System.out.println("Por favor, digite seu comando de inserção: ");
                String jogada = s.nextLine();

                entradaValida = processarJogada(jogada, jogadorAtual, tela);
            } while(!entradaValida); //Continuar até uma jogada válida ser processada

            //Após a realização da jogada, verificar se a partida foi concluída
            int resultadoJogada = partidaEncerrou(tela, jogadorAtual);

            //O jogador atual ganhou a partida
            if(resultadoJogada == 1){
                exibirTela(tela);
                System.out.println("Partida Encerrada!");
                System.out.println("Vencedor da Partida: " + jogadores[jogadorAtual - 1]);
                pontos[jogadorAtual - 1]++; //Aumenta a pontuação do vencedor
                break; //A rodada terminou, logo o loop da partida também deve ser terminado
            }

            //O espaço disponível na tela acabou, gerando um empate
            else if (resultadoJogada == 2) {
                exibirTela(tela);
                System.out.println("Partida Encerrada!");
                System.out.println("Empate!");
                break; //A rodada terminou, logo o loop da partida também deve ser terminado

            }

            //A partida ainda não acabou, então o loop deve continuar
            else {
                //Executar a troca entre os jogadores ao final da jogada atual
                if(jogadorAtual == 1){
                    jogadorAtual = 2;
                } else {
                    jogadorAtual = 1;
                }
            }
        }
    }

    //Exibe a tela do jogo da velha dependendo dos valores recebidos na matriz, onde 0 = espaço vazio, 1 = X e 2 = 0.
    public static void exibirTela(int[][] tela){
        System.out.println();
        System.out.println("   =============");
        System.out.println("   = 0 = 1 = 2 =");
        System.out.println("================");
        for (int i = 0; i < tela.length; i++){
            System.out.print(i + "  ");
            for(int j = 0; j < tela[i].length; j++){
                System.out.print("= ");
                switch (tela[i][j]){
                    case 1 -> {
                        System.out.print("X");
                        break;
                    }
                    case 2 -> {
                        System.out.print("0");
                        break;
                    }
                    default -> {
                        System.out.print(" ");
                        break;
                    }
                }
                System.out.print(" ");
            }
            System.out.print("=");
            System.out.println("\n================");
        }
        System.out.println();
    }

    //Exibe o jogador atual no topo da tela para cada jogada.
    public static void exibirJogadorAtual(int jogadorAtual, String[] jogadores){
        System.out.println("*******************************************************");
        System.out.println("Jogador " +  jogadorAtual + ": " + jogadores[jogadorAtual - 1] + " (" + ((jogadorAtual == 1) ? "X" : "0") + ")");
        System.out.println("*******************************************************");
    }

    //Recebe uma jogada através de uma string, o número do jogador atual e determina se é uma jogada válida para a tela recebida.
    //Retorna um boolean indicando sucesso/falha do processamento.
    public static boolean processarJogada(String jogada, int jogadorAtual, int[][] tela){
        if(jogada.length() == 2 && (jogada.charAt(0) == '0' || jogada.charAt(0) == '1' || jogada.charAt(0) == '2') && (jogada.charAt(1) == '0' || jogada.charAt(1) == '1' || jogada.charAt(1) == '2')){
            int i = Integer.parseInt(String.valueOf(jogada.charAt(0))); //Obter linha da jogada na tela
            int j = Integer.parseInt(String.valueOf(jogada.charAt(1))); //Obter coluna da jogada na tela

            if(tela[i][j] == 0){ //Jogada válida em local vazio
                tela[i][j] = jogadorAtual;
                System.out.println("Jogada realizada: Linha = " + jogada.charAt(0) + ", Coluna = " + jogada.charAt(1));
                return true;
            } else { //Jogada válida em local preenchido
                System.out.println("A posição com [Linha = " + jogada.charAt(0) + ", Coluna = " + jogada.charAt(1) + "] já foi preenchida. Por favor, tente novamente.");
                return false;
            }
        } else {
            System.out.println("A jogada digitada é inválida. Por favor, tente novamente.");
            return false;
        }
    }

    /*Retorna um inteiro indicando se uma tela possui condições que garantem o término de uma partida ou não, sendo:
    0) A partida ainda não terminou;
    1) O jogador atual ganha a partida;
    2) Não há mais locais disponíveis para a inserção de dados (empate).
    * */
    public static int partidaEncerrou(int[][] tela, int jogadorAtual){
        boolean telaCheia = true;

        for(int i = 0; i < tela.length; i++){
            //Verificando as linhas - jogador atual ganhou
            if(tela[i][0] == jogadorAtual && tela[i][1] == jogadorAtual && tela[i][2] == jogadorAtual){
                return 1;
            }

            //Verificando as colunas - jogador atual ganhou
            if(tela[0][i] == jogadorAtual && tela[1][i] == jogadorAtual && tela[2][i] == jogadorAtual){
                return 1;
            }

            for(int j = 0; j < tela[i].length; j++){
                if(tela[i][j] == 0){ //Verificar se alguma posição está vazia
                    telaCheia = false;
                }
            }
        }

        //Verificar as diagonais da tela
        if((tela[0][0] == jogadorAtual && tela[1][1] == jogadorAtual && tela[2][2] == jogadorAtual) || (tela[0][2] == jogadorAtual && tela[1][1] == jogadorAtual && tela[2][0] == jogadorAtual)){
            return 1;
        }

        if(telaCheia){
            return 2;
        } else {
            return 0;
        }
    }
}