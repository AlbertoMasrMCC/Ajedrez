import java.util.ArrayList;

public abstract class Pieza
{

    int lado;

    boolean vivo;

    private int[] movimientos;

    public abstract ArrayList<String> moverse(int coordenadaX, int coordenadaY);

    public abstract boolean validarMovimientosJaque(int coordenadaX, int coordenadaY);

    public abstract ArrayList<String> moverseAtacaRey(int coordenadaX, int coordenadaY);

    public abstract void pintarse(boolean blancas, boolean seleccionada);

    public int getLado() {
        return lado;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public abstract int[] getMovimientos();

}
