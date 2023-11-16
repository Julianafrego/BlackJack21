package cartas;
import java.util.ArrayList;

import java.util.List;

public class Historico {
  private List<String> resultados;

  public Historico() {
    this.resultados = new ArrayList<>();
  }

  public void adicionarResultado(String resultado) {
    resultados.add(resultado);
  }

  public List<String> getResultados() {
    return resultados;
  }
}
