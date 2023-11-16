package cartas;

public class CartaFactory {

    public static Carta criaCarta(String nome, String naipe) {
        switch (nome) {
            case "A":
                return new A(naipe);
               // caso seja as retorna nova instancia da classe a
            case "K":
            return new K(naipe);

            case "Q":
            return new Q(naipe);

            case "J":
            return new J(naipe);

            case "2":
            return new Dois(naipe);

            case "3":
            return new Tres(naipe);

            case "4":
            return new Quatro(naipe);

            case "5":
            return new Cinco(naipe);

            case "6":
            return new Seis(naipe);

            case "7":
            return new Sete(naipe);

            case "8":
            return new Oito(naipe);

            case "9":
            return new Nove(naipe);

            default:
                return null;
        }
    }
}