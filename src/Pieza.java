import java.util.ArrayList;

public abstract class Pieza
{

    int color;

    String movimientosRealizados;

    public abstract ArrayList<String> moverse(int coordenadaX, int coordenadaY);

    public abstract boolean validarMovimientosJaque(int coordenadaX, int coordenadaY);

    public abstract ArrayList<String> moverseAtacaRey(int coordenadaX, int coordenadaY);

    public abstract void pintarse(boolean blancas, boolean seleccionada, boolean estaPeligro);

    public abstract int[] obtenerMovimientos();

    public int obtenerColor() {
        return color;
    }

}
