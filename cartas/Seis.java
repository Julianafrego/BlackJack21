package cartas;

public class Seis implements Carta {
  private String naipe;

  public Seis(String naipe) {
    this.naipe = naipe;
  }

  public String getNome() {
    return "6";
  }

  public String getNaipe() {
    return this.naipe;
  }

  public int getValor() {
    return 6;
  }
}
