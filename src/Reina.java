import java.util.ArrayList;

public class Reina extends Pieza
{

    public Reina(int lado, boolean vivo)
    {

        this.lado           = lado;
        this.vivo           = vivo;

    }

    @Override
    public ArrayList<String> moverse(int coordenadaX, int coordenadaY)
    {

        int[] movimientos = getMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO HACIA ADELANTE
        for (int j = coordenadaX - 1; j >= coordenadaX - movimientos[0]; j--)
        {

            if(j < 0 || Tablero.validarPiezaSeleccionada(j, coordenadaY))
                break;

            movimientosPermitidos.add(j +""+ coordenadaY);

            if(Tablero.validarPiezaEnemiga(j, coordenadaY))
                break;

        }

        // MOVIMIENTO HACIA LA DERECHA
        for (int j = coordenadaY + 1; j <= coordenadaY + movimientos[1]; j++)
        {

            if(j > 7 || Tablero.validarPiezaSeleccionada(coordenadaX, j))
                break;

            movimientosPermitidos.add(coordenadaX +""+ j);

            if(Tablero.validarPiezaEnemiga(coordenadaX, j))
                break;

        }

        // MOVIMIENTO HACIA ABAJO
        for (int j = coordenadaX + 1; j <= coordenadaX + movimientos[2]; j++)
        {

            if(j > 7 || Tablero.validarPiezaSeleccionada(j,coordenadaY))
                break;

            movimientosPermitidos.add(j +""+ coordenadaY);

            if(Tablero.validarPiezaEnemiga(j, coordenadaY))
                break;

        }

        // MOVIMIENTO HACIA LA IZQUIERDA
        for (int j = coordenadaY - 1; j >= coordenadaY - movimientos[3]; j--)
        {

            if(j < 0 || Tablero.validarPiezaSeleccionada(coordenadaX,j))
                break;

            movimientosPermitidos.add(coordenadaX +""+ j);

            if(Tablero.validarPiezaEnemiga(coordenadaX, j))
                break;

        }

        /***** MOVIMIENTO EN DIAGONAL *****/
        // ARRIBA DERECHA
        for(int x = coordenadaX - 1, y = coordenadaY + 1; x >= coordenadaX - movimientos[4] || y < coordenadaY - movimientos[4]; x--, y++)
        {

            if (x < 0 || y > 7 || Tablero.validarPiezaSeleccionada(x, y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }

        // ARRIBA IZQUIERDA
        for(int x = coordenadaX - 1, y = coordenadaY - 1; x >= coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x--, y--)
        {

            if (x < 0 || y < 0 || Tablero.validarPiezaSeleccionada(x, y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }

        // ABAJO IZQUIERDA
        for(int x = coordenadaX + 1, y = coordenadaY - 1; x < coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x++, y--)
        {

            if (x > 7 || y < 0 || Tablero.validarPiezaSeleccionada(x, y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }

        // ABAJO DERECHA
        for(int x = coordenadaX + 1, y = coordenadaY + 1; x > coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x++, y++)
        {

            if (x > 7 || y > 7 || Tablero.validarPiezaSeleccionada(x, y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }
        /**********************************/

        return movimientosPermitidos;

    }

    @Override
    public void pintarse(boolean blancas, boolean seleccionada)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        if(seleccionada)
        {

            System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♛ "+"\u001B[0m" );
            return;

        }

        if(blancas)
        {

            if(lado == NEGRAS)
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♛ "+"\u001B[0m" );
            else
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♛ "+"\u001B[0m");

        }
        else
        {

            if (lado == NEGRAS)
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♛ "+"\u001B[0m");
            else
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♛ "+"\u001B[0m");

        }

    }

    @Override
    public int[] getMovimientos()
    {

        int[] movimientos = {7, 7, 7, 7, 7};
        return movimientos;

    }

}
