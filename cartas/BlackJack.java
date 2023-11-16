
package cartas;

// Importar bibliotecas gráficas
import javax.swing.*;
/*import cartas.Embaralhador;
import cartas.Jogador;
import cartas.Carta;
import cartas.CartaFactory; */
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

// Criar classe, herda JFrame
public class BlackJack {
  private ArrayList<Carta> baralho;
  private Embaralhador strategyEmbaralhador;

  private Jogador player1;
  private Jogador player2;
  private Historico historico;

  public BlackJack(Embaralhador strategyEmbaralhador, Jogador player1, Jogador player2) {
    this.strategyEmbaralhador = strategyEmbaralhador;
    this.player1 = player1;
    this.player2 = player2;
    this.historico = new Historico();
  }

  public void iniciarJogo() {
    criarBaralho();
    embaralharBaralho();

    System.out.println("Jogo iniciado!");
    System.out.println("                      ");
    realizarRodada(player1);
    realizarRodada(player1);
    System.out.println("Pontos: " + player1.getPontos());
    System.out.println("                      ");
    verificarBlackJack(player1);
    System.out.println("                      ");
    System.out.println("                      ");
    realizarRodada(player2);
    realizarRodada(player2);
    System.out.println("Pontos: " + player2.getPontos());
    System.out.println("                      ");
    verificarBlackJack(player2);
    System.out.println("                      ");
    // Lógica do jogo aqui...
  }

  private void criarBaralho() {
    baralho = new ArrayList<>();
    String[] naipes = { "Ouros", "Paus", "Copas", "Espadas" };

    for (String naipe : naipes) {
      baralho.add(CartaFactory.criaCarta("A", naipe));
      baralho.add(CartaFactory.criaCarta("K", naipe));
      baralho.add(CartaFactory.criaCarta("Q", naipe));
      baralho.add(CartaFactory.criaCarta("J", naipe));
      for (int i = 2; i <= 10; i++) {
        baralho.add(CartaFactory.criaCarta(String.valueOf(i), naipe));
      }
    }
  }

  private void embaralharBaralho() {
    strategyEmbaralhador.embaralhar(baralho);
  }

  public void realizarRodada(Jogador jogador) {
    if (baralho.isEmpty()) {
      System.out.println("Baralho vazio. O jogo deve ser reiniciado.");
      return;
    }

    Carta cartaDistribuida = baralho.remove(0);

    if (cartaDistribuida != null) {
      jogador.receberCarta(cartaDistribuida);

      System.out.println(" " + jogador.getNome() + " recebeu a carta: " + cartaDistribuida.getNome() + " de "
          + cartaDistribuida.getNaipe() + " ");
      System.out.print(" ");

      int pontos = jogador.getPontos();
      pontos += cartaDistribuida.getValor();
      jogador.setPontos(pontos);

      if (verificarEstouro(jogador)) {
        System.out.println("  ");
        System.out.println(jogador.getNome() + " - Estourou!");
        System.out.println("  ");
        System.out.println("Pontuação de " + jogador.getNome() + ": " + jogador.getPontos());
        System.out.println("  ");
      } else {
        System.out.println("  ");
        System.out.println("Pontuação de " + jogador.getNome() + ": " + jogador.getPontos());
        System.out.println("  ");
      }
    } else {
      /*
       * System.out.println("Carta distribuída é nula. Recebendo uma nova carta...");
       */
      realizarRodada(jogador); // Chama recursivamente até obter uma carta válida
    }
  }

  public void pedirCarta(Jogador jogador) {
    if (baralho.isEmpty()) {
      System.out.println("Baralho vazio. O jogo deve ser reiniciado.");
      return;
    }

    Carta cartaDistribuida = baralho.remove(0);

    if (cartaDistribuida != null) {
      jogador.receberCarta(cartaDistribuida);

      System.out.println(" " + jogador.getNome() + " recebeu a carta: " + cartaDistribuida.getNome() + " de "
          + cartaDistribuida.getNaipe() + " ");
      System.out.print(" ");

      int pontos = jogador.getPontos();
      pontos += cartaDistribuida.getValor();
      jogador.setPontos(pontos);

      if (verificarEstouro(jogador)) {
        System.out.println("  ");
        System.out.println(jogador.getNome() + " - Estourou!");
        System.out.println("  ");
        System.out.println("Pontuação de " + jogador.getNome() + ": " + jogador.getPontos());
        System.out.println("  ");
      } else {
        System.out.println("  ");
        System.out.println("Pontuação de " + jogador.getNome() + ": " + jogador.getPontos());
        System.out.println("  ");
      }
    } else {
      /*
       * System.out.println("Carta distribuída é nula. Recebendo uma nova carta...");
       */
      pedirCarta(jogador); // Chama recursivamente até obter uma carta válida
    }
  }

  public boolean decidirAcao(Jogador jogador, Scanner scan) {
    System.out.println("Vez de " + jogador.getNome());
    System.out.println("O que deseja?");
    System.out.println("1. Pedir 1 carta;");
    System.out.println("2. Manter.");

    int decisao = scan.nextInt();
    if (decisao == 1) {
      realizarRodada(jogador);
      System.out.println("Pontos de " + jogador.getNome() + ": " + jogador.getPontos());

      return true;
    } else if (decisao == 2) {
      return false;
    }
    return false;
  }

  public boolean verificarBlackJack(Jogador jogador) {
    if (jogador.getPontos() == 21) {
      // System.out.println(jogador.getNome() + ", parabéns, voce fez um Blackjack!");
      return true;
    }
    return false;
  }

  public boolean verificarEstouro(Jogador jogador) {
    return jogador.getPontos() > 21;
  }

  public Jogador verificarVitoria(Jogador jogador1, Jogador jogador2) {
    if (jogador1.getPontos() > 21 && jogador2.getPontos() <= 21) {
      System.out.println("  ");
      System.out.println("Parabéns " + jogador2.getNome() + ", você ganhou!");
      System.out.println("  ");
      return jogador2;
    } else if (jogador2.getPontos() > 21 && jogador1.getPontos() <= 21) {
      System.out.println("  ");
      System.out.println("Parabéns " + jogador1.getNome() + ", você ganhou!");
      System.out.println("  ");
      return jogador1;
    } else if (jogador1.getPontos() > jogador2.getPontos() && jogador1.getPontos() <= 21) {
      System.out.println("  ");
      System.out.println("Parabéns " + jogador1.getNome() + ", você ganhou!");
      System.out.println("  ");
      return jogador1;
    } else if (jogador2.getPontos() > jogador1.getPontos() && jogador2.getPontos() <= 21) {
      System.out.println("  ");
      System.out.println("Parabéns " + jogador2.getNome() + ", você ganhou!");
      System.out.println("  ");
      return jogador2;
    } else {
      System.out.println("  ");
      System.out.println("Empate!");
      System.out.println("  ");
      return null;
    }
  }

  public boolean verificarEmpate(Jogador jogador1, Jogador jogador2) {
    return jogador1.getPontos() == jogador2.getPontos();
  }

  // historico........
  public void adicionarAoHistorico(String resultado) {
    historico.adicionarResultado(resultado);
  }

  public Historico getHistorico() {
    return historico;
  }

  // public void distribuirCarta()
  // * throw new
  // @Override
  /*
   * public void actionPerforme//d(ActionEvent e) {
   * 
   * UnsupportedOperationException("Unimplemented method 'actionPerformed'");
   * }
   */

}