package cartas;

public class Dois implements Carta {
    private String naipe;

    public Dois (String naipe) {
        this.naipe = naipe;
    }

    public String getNome() {
        return "2";
    }

    public String getNaipe() {
        return this.naipe;
    }

  public int getValor() {
    return 2;
  }
}
