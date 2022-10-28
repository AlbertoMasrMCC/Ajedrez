public class Reina extends Pieza
{

    public Reina(String nombre, int lado, boolean vivo, int[] movimientos)
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
