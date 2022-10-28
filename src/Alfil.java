public class Alfil extends Pieza
{

    public Alfil(int lado, boolean vivo)
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

        int[] movimientos = {0, 0, 0, 0, 7};
        return movimientos;

    }

}
