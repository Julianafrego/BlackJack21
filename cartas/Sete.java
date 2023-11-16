package cartas;

public class Sete implements Carta {
  private String naipe;

  public Sete(String naipe) {
    this.naipe = naipe;
  }

  public String getNome() {
    return "7";
  }

  public String getNaipe() {
    return this.naipe;
  }

  public int getValor() {
    return 7;
  }
}
