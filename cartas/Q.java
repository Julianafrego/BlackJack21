package cartas;

public class Q implements Carta {
  private String naipe;

  // Q = DAMA
  public Q(String naipe) {
    this.naipe = naipe;
  }

  public String getNome() {
    return "Q";
  }

  public String getNaipe() {
    return this.naipe;
  }

  public int getValor() {
    return 10;
  }
}
