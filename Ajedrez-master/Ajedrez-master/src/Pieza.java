public abstract class Pieza
{

    String nombre;
    int lado;
    boolean vivo;
    int[] movimientos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int[] movimientos) {
        this.movimientos = movimientos;
    }

    public void moverse(Casilla origen, Casilla destino){}

}
