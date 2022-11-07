public class Casilla
{

    private Pieza pieza;

    private int[] coordenadas;

    public Casilla(Pieza pieza, int[] coordenadas)
    {

        this.pieza          = pieza;
        this.coordenadas    = coordenadas;

    }

    public void pintarse(boolean blancas)
    {

        if(blancas)
        {

            System.out.print("\u001b[48;5;250m"+"\u001b[38;5;250m"+" ♜ " + "\u001B[0m");

        }
        else
        {

            System.out.print("\u001b[48;5;8m"+"\u001b[38;5;8m"+" ♜ "+"\u001B[0m");

        }

    }

    public Pieza obtenerPieza()
    {

        return pieza;

    }

    public void establecerPieza(Pieza pieza)
    {

        this.pieza = pieza;

    }

    public int[] obtenerCoordenadas()
    {

        return coordenadas;

    }

}
