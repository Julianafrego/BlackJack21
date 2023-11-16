package cartas;

public class Tres implements Carta {
  private String naipe;

  public Tres(String naipe) {
    this.naipe = naipe;
  }

  public String getNome() {
    return "3";
  }

  public String getNaipe() {
    return this.naipe;
  }

  public int getValor() {
    return 3;
  }
}
