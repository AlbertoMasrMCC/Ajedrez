public class Alfil extends Pieza
{

    public Alfil(String nombre, int lado, boolean vivo, int[] movimientos)
    {

        this.nombre         = nombre;
        this.lado           = lado;
        this.vivo           = vivo;
        this.movimientos    = movimientos;

    }

    @Override
    public void moverse(Casilla origen, Casilla destino) {
        super.moverse(origen, destino);
    }
}
