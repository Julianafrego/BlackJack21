package cartas;

import java.util.Scanner;
/*import cartas.BlackJack;
import cartas.Embaralhador;
import cartas.Jogador;
import cartas.Historico;*/

public class Main {
  public static void main(String[] args) {
    System.out.println("Seja bem-vindo(a) ao Blackjack 21!");
    System.out.println("  ");

    int escolha;
    BlackJack game = null; // Inicializa game fora do loop

    Historico historico = new Historico();
    Scanner scan = new Scanner(System.in);

    do {
      System.out.println("Menu");
      System.out.println("  ");
      System.out.println("1 - Jogar");
      System.out.println("2 - Regras");
      System.out.println("3 - Historico");
      System.out.println("4 - Sair");
      System.out.println("  ");

      escolha = scan.nextInt();

      switch (escolha) {

        case 1:
          game = jogarBlackJack(scan, historico);
          break;

        case 2:
          regras();
          break;

        case 3:
          if (game != null) {
            exibirHistorico(game);
          } else {
            System.out.println("Não há histórico disponível. Jogue uma partida primeiro.");
          }
          break;

        case 4:
          System.out.println("Encerrando o jogo...");
          
          break;
      }
    } while (escolha != 4);

    scan.close(); // Fecha o Scanner no final do programa
  }

  public static BlackJack jogarBlackJack(Scanner scan, Historico historico) {
    BlackJack game = null; // game esta fora do try
    try {
      Embaralhador strategy = new Embaralhador();
      Jogador player1 = new Jogador("Player 1", 0, 0);
      Jogador player2 = new Jogador("Player 2", 0, 0);

      game = new BlackJack(strategy, player1, player2);

      // Loop para jogar várias partidas
      do {
        game.iniciarJogo();

        // Jogador 1
        do {
          System.out.println(player1.getNome() + ", Deseja mais uma carta? 1 - Sim / 2 - Não ");
          int decisaoPlayer1 = scan.nextInt();

          if (decisaoPlayer1 == 1) {
            game.pedirCarta(player1);
            System.out.println(player1.getNome() + ": Cartas na mão - " + player1.mostrarMao());
            System.out.println("  ");
            System.out.println(player1.getNome() + ": Pontuação - " + player1.getPontos());
            System.out.println("  ");

          } else {
            System.out.println("  ");
            System.out.println(player1.getNome() + ": Ficou com as cartas na mão - " + player1.mostrarMao());
            System.out.println("Pontos: " + player1.getPontos());
            System.out.println("  ");
            break; // Player 1 decidiu não pedir mais cartas
          }
        } while (true);

        // Jogador 2
        do {
          System.out.println(player2.getNome() + ", Deseja mais uma carta? 1 - Sim / 2 - Não ");
          int decisaoPlayer2 = scan.nextInt();

          if (decisaoPlayer2 == 1) {
            game.pedirCarta(player2);
            System.out.println(player2.getNome() + ": Cartas na mão - " + player2.mostrarMao());
            System.out.println("  ");

            System.out.println(player2.getNome() + ": Pontuação - " + player2.getPontos());
            System.out.println("  ");

          } else {
            System.out.println("  ");
            System.out.println(player2.getNome() + ": Ficou com as cartas na mão - " + player2.mostrarMao());
            System.out.println("Pontos: " + player2.getPontos());
            System.out.println("  ");

            break; // Player 2 decidiu não pedir mais cartas
          }
        } while (true);

        // Ao término de uma partida
        Jogador vencedor = game.verificarVitoria(player1, player2);
        if (vencedor != null) {
          System.out.println("  ");
          // System.out.println("O vencedor é: " + vencedor.getNome());
          game.adicionarAoHistorico("O vencedor é: " + vencedor.getNome() + ", Pontos:" + vencedor.getPontos()); // adiciona
                                                                                                                 // ao
                                                                                                                 // historico
          System.out.println("  ");
          break;
        } else {
          System.out.println("  ");
          // System.out.println("Empate!");
          game.adicionarAoHistorico("Empate! Nenhum jogador marcou ponto!");
          System.out.println("  ");
        }

        // reseta os pontos dos playes e as cartas na mao
        player1.setPontos(0);
        player2.setPontos(0);
        player1.getMao().clear();
        player2.getMao().clear();

        //
        System.out.println("Deseja continuar jogando? (1 - Sim / 2 - Não)");
        int continuar = scan.nextInt();
        if (continuar != 1) {
          // Exibir resultados finais
          System.out.println("Resultados finais:");
          System.out.println(player1.getNome() + ": " + player1.getVitorias() + " vitórias");
          System.out.println(player2.getNome() + ": " + player2.getVitorias() + " vitórias");
          break;
        }

      } while (true);
    } catch (Exception e) {
      System.out.println("Ocorreu um erro durante o jogo. Reinicie o programa e tente novamente.");
      scan.nextLine();
    }

    return game;

  }

  public static void regras() {
    System.out.println("  ");
    System.out.println("Regras");
    System.out.println("  ");
    System.out.println("O objetivo do jogo é conseguir o maior valor possível sem passar de 21.");
    System.out.println("  ");
    System.out.println("Cada jogador receberá 2 cartas inicialmente e terá a opção de pegar mais uma carta ou não.");
    System.out.println("  ");
    System.out.println(
        "O jogador ganha se o valor da mão for maior que o valor da mão do outro jogador ou se o valor for igual a 21");
    System.out.println("  ");
    System.out.println(
        "O jogador perde se o valor da mão for menor que o valor da mão do outro jogador ou se o valor for maior que 21");
    System.out.println("  ");
    System.out.println(
        "Cada carta possui o valor correspondente ao seu número, se for uma carta com número, ex. 2 de ouro vale 2 pontos");
    System.out.println("  ");
    System.out.println("Se for uma carta com letra, ex. Ás de copas vale 1 ponto");
    System.out.println("  ");
    System.out.println("Se for uma carta com letra J, K e Q, ex. Rei de paus vale 10 pontos");
    System.out.println("  ");
  }

  public static void exibirHistorico(BlackJack game) {
    System.out.println("Histórico da partida:");
    System.out.println(" ");
    for (String resultado : game.getHistorico().getResultados()) {
      System.out.println(resultado);
      System.out.println(" ");
    }
  }
}
