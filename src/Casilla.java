public class Casilla
{

    private Pieza pieza;

    private int[] coordenadas;

    public Casilla(Pieza pieza, int[] coordenadas)
    {

        this.pieza          = pieza;
        this.coordenadas    = coordenadas;

    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[] coordenadas) {
        this.coordenadas = coordenadas;
    }

}
