public class Casilla
{

    private boolean ocupado;

    private Pieza pieza;

    private int[] coordenadas;

    public Casilla(Pieza pieza, boolean ocupado, int[] coordenadas)
    {

        this.pieza          = pieza;
        this.ocupado        = ocupado;
        this.coordenadas    = coordenadas;

    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
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
