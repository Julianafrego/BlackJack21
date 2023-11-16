package cartas;

public class Nove implements Carta {
    private String naipe;

    public Nove(String naipe) {
        this.naipe = naipe;
    }

    public String getNome() {
        return "9";
    }

    public String getNaipe() {
        return this.naipe;
    }
  public int getValor() {
  return 9;
  }
}