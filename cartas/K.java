package cartas;

public class K implements Carta {
    private String naipe;

    // K = REI
    public K (String naipe) {
        this.naipe = naipe;
    }

    public String getNome() {
        return "K";
    }

    public String getNaipe() {
        return this.naipe;
    }

  public int getValor() {
    return 10;
  }
  
}
