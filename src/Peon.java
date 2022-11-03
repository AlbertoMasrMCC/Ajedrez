import java.util.ArrayList;

public class Peon extends Pieza
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
    public ArrayList<String> moverse(int coordenadaX, int coordenadaY)
    {

        final int NEGRAS            = 0;

        int[] movimientos = getMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO HACIA ADELANTE
        if (lado == NEGRAS)
        {

            if(coordenadaX == 1)
            {

                for (int j = coordenadaX + 1; j <= coordenadaX + movimientos[0]; j++)
                {

                    if (Tablero.validarPiezaAliada(j,coordenadaY))
                        break;

                    movimientosPermitidos.add(j +""+ coordenadaY);

                }

            }
            else
            {

                if (!Tablero.validarPiezaAliada(coordenadaX + 1, coordenadaY))
                    movimientosPermitidos.add((coordenadaX + 1) +""+ coordenadaY);

            }

        }
        else
        {

            if(coordenadaX == 6)
            {

                for (int j = coordenadaX - 1; j >= coordenadaX - movimientos[0]; j--)
                {

                    if (Tablero.validarPiezaAliada(j,coordenadaY))
                        break;

                    movimientosPermitidos.add(j +""+ coordenadaY);

                }

            }
            else
            {

                if (!Tablero.validarPiezaAliada(coordenadaX - 1,coordenadaY))
                    movimientosPermitidos.add((coordenadaX - 1) +""+ coordenadaY);

            }

        }

        // MOVIMIENTO EN DIAGONAL
        if(lado == NEGRAS)
        {

            if(coordenadaY != 0 && coordenadaY != 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                    movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY + 1));

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                    movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY - 1));

            }

            if(coordenadaY == 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                    movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY + 1));

            }

            if(coordenadaY == 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                    movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY - 1));

            }

        }
        else
        {

            if(coordenadaY != 0 && coordenadaY != 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                    movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY + 1));

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                    movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY - 1));

            }

            if(coordenadaY == 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                    movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY + 1));

            }

            if(coordenadaY == 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                    movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY - 1));

            }

        }

        return movimientosPermitidos;

    }

    @Override
    public void pintarse(boolean blancas, boolean seleccionada)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        if(seleccionada)
        {

            System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♙ "+"\u001B[0m" );
            return;

        }

        if(blancas)
        {

            if(lado == NEGRAS)
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♙ "+"\u001B[0m" );
            else
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♙ "+"\u001B[0m");

        }
        else
        {

            if (lado == NEGRAS)
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♙ "+"\u001B[0m");
            else
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♙ "+"\u001B[0m");

        }

    }

    @Override
    public int[] getMovimientos()
    {

        int[] movimientos = {2, 0, 0, 0, 1};
        return movimientos;

    }

}
