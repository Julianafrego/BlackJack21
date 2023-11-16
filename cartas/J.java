package cartas;

public class J implements Carta {
    private String naipe;

    public J (String naipe) {
        this.naipe = naipe;
    }
    //J = VALETE

    public String getNome() {
        return "J";
    }

    public String getNaipe() {
        return this.naipe;
    }
  public int getValor() {
  return 10;
  }
}
