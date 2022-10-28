public class Peon extends Pieza implements Cloneable
{

    public Peon(int lado, boolean vivo)
    {

        this.lado           = lado;
        this.vivo           = vivo;

    }

    public void convertirse()
    {



    }

    public void primerMovimiento()
    {



    }

    @Override
    public void moverse(Casilla origen, Casilla destino)
    {



    }

    @Override
    public int[] getMovimientos()
    {

        int[] movimientos = {2, 0, 0, 0, 1};
        return movimientos;

    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {

        try
        {

            return  (Peon) super.clone();

        }
        catch (CloneNotSupportedException e)
        {

            return new Peon(this.lado, this.vivo);

        }

    }

}
