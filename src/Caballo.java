public class Caballo extends Pieza
{

    public Caballo(int lado, boolean vivo)
    {

        this.lado           = lado;
        this.vivo           = vivo;

    }
    @Override
    public void moverse(Casilla origen, Casilla destino)
    {



    }

    @Override
    public int[] getMovimientos()
    {

        int[] movimientos = {2, 2, 2, 2, 0};
        return movimientos;

    }

}
