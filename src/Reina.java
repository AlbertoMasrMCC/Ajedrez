public class Reina extends Pieza
{

    public Reina(int lado, boolean vivo)
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

        int[] movimientos = {7, 7, 7, 7, 7};
        return movimientos;

    }

}
