public class Rey extends Pieza
{

    public Rey(String nombre, int lado, boolean vivo, int[] movimientos)
    {

        this.nombre         = nombre;
        this.lado           = lado;
        this.vivo           = vivo;
        this.movimientos    = movimientos;

    }

    public void enroque()
    {



    }

    @Override
    public void moverse(Casilla origen, Casilla destino) {
        super.moverse(origen, destino);
    }
}
