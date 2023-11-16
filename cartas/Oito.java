package cartas;

public class Oito implements Carta {
    private String naipe;

    public Oito (String naipe) {
        this.naipe = naipe;
    }

    public String getNome() {
        return "8";
    }

    public String getNaipe() {
        return this.naipe;
    }
  public int getValor() {
  return 8;
  }
}