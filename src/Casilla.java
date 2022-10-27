public class Casilla
{

    private boolean ocupado;

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    private Pieza pieza;
    private int[] coordenadas;

    public Casilla(Pieza pieza, boolean ocupado, int[] coordenadas)
    {

        this.pieza          = pieza;
        this.ocupado        = ocupado;
        this.coordenadas    = coordenadas;

    }

    public void actualizarOcupado()
    {



    }

    public void actualizarPieza(Pieza pieza)
    {



    }

}
