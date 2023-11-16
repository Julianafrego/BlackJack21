package cartas;

public class Cinco implements Carta {
    private String naipe;

    public Cinco (String naipe) {
        this.naipe = naipe;
    }

    public String getNome() {
        return "5";
    }

    public String getNaipe() {
        return this.naipe;
    }

  public int getValor() {
  return 5;
  }
  
}