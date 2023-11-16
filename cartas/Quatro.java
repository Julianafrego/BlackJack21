package cartas;

public class Quatro implements Carta {
  private String naipe;

  public Quatro(String naipe) {
    this.naipe = naipe;
  }

  public String getNome() {
    return "4";
  }

  public String getNaipe() {
    return this.naipe;
  }

  public int getValor() {
    return 4;

  }
}