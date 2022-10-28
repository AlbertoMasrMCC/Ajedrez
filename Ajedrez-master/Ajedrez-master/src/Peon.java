public class Peon extends Pieza
{

    public Peon(String nombre, int lado, boolean vivo, int[] movimientos)
    {

        this.nombre         = nombre;
        this.lado           = lado;
        this.vivo           = vivo;
        this.movimientos    = movimientos;

    }

    public void convertirse()
    {



    }

    public void primerMovimiento()
    {



    }

    @Override
    public void moverse(Casilla origen, Casilla destino) {
        super.moverse(origen, destino);
    }

}
