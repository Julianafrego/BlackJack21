package cartas;
import java.util.ArrayList;


public class Jogador {
  private String nome;
  private ArrayList<Carta> mao;
  private int pontos;
  private int vitorias;

  public Jogador(String nome, int pontos, int vitorias) {
    this.nome = nome;
    this.mao = new ArrayList<>(); // cartas na mao
    this.pontos = pontos;
    this.vitorias = vitorias;

  }

  public void receberCarta(Carta carta) {
    mao.add(carta);
  }

  public ArrayList<Carta> getMao() {
    return mao;
  }

  public String mostrarMao() {
    StringBuilder maoString = new StringBuilder();
    for (Carta carta : mao) {
      maoString.append(carta.getNome()).append(" de ").append(carta.getNaipe()).append(", ");
    }
   ///, se houver cartas na mão
    if (!mao.isEmpty()) {
      maoString.delete(maoString.length() - 2, maoString.length());
    }
    return maoString.toString();
  }

  public String getNome() {
    return nome;
  }

  public int getPontos() {
    return pontos;
  }

  public void setPontos(int pontos) {
    this.pontos = pontos;
  }

  public int getVitorias() {
    return vitorias;
  }

  public void setVitorias(int vitorias) {
    this.vitorias = vitorias;
  }

}