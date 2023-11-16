package cartas;

public class A implements Carta {
  private String naipe;

  public A(String naipe) {
    this.naipe = naipe;
  }

  public String getNome() {
    return "A";
  }

  public String getNaipe() {
    return this.naipe;
  }

  public int getValor() {
    return 1;
  }
}