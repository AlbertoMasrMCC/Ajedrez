import java.util.ArrayList;

public abstract class Pieza
{

    int color;

    public abstract ArrayList<String> moverse(int coordenadaX, int coordenadaY);

    public abstract boolean validarMovimientosJaque(int coordenadaX, int coordenadaY);

    public abstract ArrayList<String> moverseAtacaRey(int coordenadaX, int coordenadaY);

    public abstract void pintarse(boolean blancas, boolean seleccionada);

    public int obtenerColor() {
        return color;
    }

    public abstract int[] obtenerMovimientos();

}
