public class Torre extends Pieza
{

    public Torre(int lado, boolean vivo)
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

        int[] movimientos = {7, 7, 7, 7, 0};
        return movimientos;

    }

}
