public abstract class Pieza
{

    int lado;

    boolean vivo;

    private int[] movimientos;

    public abstract void moverse(Casilla origen, Casilla destino);

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
