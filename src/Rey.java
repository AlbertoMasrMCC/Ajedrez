public class Rey extends Pieza
{

    public Rey(int lado, boolean vivo)
    {

        this.lado           = lado;
        this.vivo           = vivo;

    }

    public void enroque()
    {



    }

    @Override
    public void moverse(Casilla origen, Casilla destino)
    {



    }

    @Override
    public int[] getMovimientos()
    {

        int[] movimientos = {1, 1, 1, 1, 1};
        return movimientos;

    }

}
