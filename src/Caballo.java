import java.util.ArrayList;

public class Caballo extends Pieza
{

    public Caballo(int color)
    {

        this.color = color;

    }

    @Override
    public ArrayList<String> moverse(int coordenadaX, int coordenadaY)
    {

        int movimientoPosible;

        int[] movimientos = obtenerMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO HACIA ADELANTE
        movimientoPosible = coordenadaX - movimientos[0];

        if(movimientoPosible >= 0)
        {

            if(coordenadaY - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY - 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {movimientoPosible, coordenadaY - 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY + 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {movimientoPosible, coordenadaY + 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

                }

            }

        }

        // MOVIMIENTO HACIA LA DERECHA
        movimientoPosible = coordenadaY + movimientos[0];

        if(movimientoPosible <= 7)
        {

            if(coordenadaX - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(coordenadaX - 1, movimientoPosible))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX - 1, movimientoPosible};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

                }

            }

            if(coordenadaX + 1 <= 7)
            {

                if (!Tablero.validarPiezaAliada(coordenadaX + 1, movimientoPosible))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX + 1, movimientoPosible};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);

                }

            }

        }

        // MOVIMIENTO HACIA ABAJO
        movimientoPosible = coordenadaX + movimientos[0];

        if(movimientoPosible <= 7)
        {

            if(coordenadaY - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY - 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {movimientoPosible, coordenadaY - 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY + 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {movimientoPosible, coordenadaY + 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

                }

            }

        }

        // MOVIMIENTO HACIA LA IZQUIERDA
        movimientoPosible = coordenadaY - movimientos[0];

        if(movimientoPosible >= 0)
        {

            if(coordenadaX - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(coordenadaX - 1, movimientoPosible))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX - 1, movimientoPosible};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

                }

            }

            if(coordenadaX + 1 <= 7)
            {
                if (!Tablero.validarPiezaAliada(coordenadaX + 1, movimientoPosible))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX + 1, movimientoPosible};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);

                }

            }

        }

        return movimientosPermitidos;

    }

    @Override
    public boolean validarMovimientosJaque(int coordenadaX, int coordenadaY)
    {

        int[] movimientos = {7, 7, 7, 7, 7};

        // MOVIMIENTO HACIA ADELANTE
        for (int j = coordenadaX - 1; j >= coordenadaX - movimientos[0]; j--)
        {

            if(j < 0 || Tablero.validarPiezaAliada(j, coordenadaY))
                break;

            if(Tablero.validarPiezaEnemiga(j, coordenadaY))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(j, coordenadaY);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Torre)
                    return true;

                break;

            }

        }

        // MOVIMIENTO HACIA LA DERECHA
        for (int j = coordenadaY + 1; j <= coordenadaY + movimientos[1]; j++)
        {

            if(j > 7 || Tablero.validarPiezaAliada(coordenadaX, j))
                break;


            if(Tablero.validarPiezaEnemiga(coordenadaX, j))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX, j);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Torre)
                    return true;

                break;

            }

        }

        // MOVIMIENTO HACIA ABAJO
        for (int j = coordenadaX + 1; j <= coordenadaX + movimientos[2]; j++)
        {

            if(j > 7 || Tablero.validarPiezaAliada(j,coordenadaY))
                break;

            if(Tablero.validarPiezaEnemiga(j, coordenadaY))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(j, coordenadaY);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Torre)
                    return true;

                break;

            }

        }

        // MOVIMIENTO HACIA LA IZQUIERDA
        for (int j = coordenadaY - 1; j >= coordenadaY - movimientos[3]; j--)
        {

            if(j < 0 || Tablero.validarPiezaAliada(coordenadaX, j))
                break;

            if(Tablero.validarPiezaEnemiga(coordenadaX, j))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX, j);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Torre)
                    return true;

                break;

            }

        }

        /***** MOVIMIENTO EN DIAGONAL *****/
        // ARRIBA DERECHA
        for(int x = coordenadaX - 1, y = coordenadaY + 1; x >= coordenadaX - movimientos[4] || y < coordenadaY - movimientos[4]; x--, y++)
        {

            if (x < 0 || y > 7 || Tablero.validarPiezaAliada(x,y))
                break;

            if(Tablero.validarPiezaEnemiga(x, y))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(x, y);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Alfil)
                    return true;

                break;

            }

        }

        // ARRIBA IZQUIERDA
        for(int x = coordenadaX - 1, y = coordenadaY - 1; x >= coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x--, y--)
        {

            if (x < 0 || y < 0 || Tablero.validarPiezaAliada(x,y))
                break;

            if(Tablero.validarPiezaEnemiga(x, y))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(x, y);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Alfil)
                    return true;

                break;

            }

        }

        // ABAJO IZQUIERDA
        for(int x = coordenadaX + 1, y = coordenadaY - 1; x < coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x++, y--)
        {

            if (x > 7 || y < 0 || Tablero.validarPiezaAliada(x, y))
                break;

            if(Tablero.validarPiezaEnemiga(x, y))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(x, y);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Alfil)
                    return true;

                break;

            }

        }

        // ABAJO DERECHA
        for(int x = coordenadaX + 1, y = coordenadaY + 1; x > coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x++, y++)
        {

            if (x > 7 || y > 7 || Tablero.validarPiezaAliada(x,y))
                break;

            if(Tablero.validarPiezaEnemiga(x, y))
            {

                Pieza piezaObtenida = Tablero.obtenerPiezaJaque(x, y);

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Alfil)
                    return true;

                break;

            }

        }
        /**********************************/

        return false;

    }

    @Override
    public ArrayList<String> moverseAtacaRey(int coordenadaX, int coordenadaY)
    {

        int movimientoPosible;

        int[] movimientos = obtenerMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO HACIA ADELANTE
        movimientoPosible = coordenadaX - movimientos[0];

        if(movimientoPosible >= 0)
        {

            if(coordenadaY - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY - 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(movimientoPosible, coordenadaY - 1);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));

                        return movimientosPermitidos;

                    }

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY + 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(movimientoPosible, coordenadaY + 1);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

                        return movimientosPermitidos;

                    }

                }

            }

        }

        // MOVIMIENTO HACIA LA DERECHA
        movimientoPosible = coordenadaY + movimientos[0];

        if(movimientoPosible <= 7)
        {

            if(coordenadaX - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(coordenadaX - 1, movimientoPosible))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX - 1, movimientoPosible);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

                        return movimientosPermitidos;

                    }

                }

            }

            if(coordenadaX + 1 <= 7)
            {

                if (!Tablero.validarPiezaAliada(coordenadaX + 1, movimientoPosible))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX + 1, movimientoPosible);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);

                        return movimientosPermitidos;

                    }

                }

            }

        }

        // MOVIMIENTO HACIA ABAJO
        movimientoPosible = coordenadaX + movimientos[0];

        if(movimientoPosible <= 7)
        {

            if(coordenadaY - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY - 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(movimientoPosible, coordenadaY - 1);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));

                        return movimientosPermitidos;

                    }

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if (!Tablero.validarPiezaAliada(movimientoPosible, coordenadaY + 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(movimientoPosible, coordenadaY + 1);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

                        return movimientosPermitidos;

                    }

                }

            }

        }

        // MOVIMIENTO HACIA LA IZQUIERDA
        movimientoPosible = coordenadaY - movimientos[0];

        if(movimientoPosible >= 0)
        {

            if(coordenadaX - 1 >= 0)
            {

                if (!Tablero.validarPiezaAliada(coordenadaX - 1, movimientoPosible))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX - 1, movimientoPosible);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

                        return movimientosPermitidos;

                    }

                }

            }

            if(coordenadaX + 1 <= 7)
            {
                if (!Tablero.validarPiezaAliada(coordenadaX + 1, movimientoPosible))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX + 1, movimientoPosible);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);

                        return movimientosPermitidos;

                    }

                }

            }

        }

        return movimientosPermitidos;

    }

    @Override
    public void pintarse(boolean blancas, boolean seleccionada, boolean estaPeligro)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        if(seleccionada)
        {

            System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♞ "+"\u001B[0m" );
            return;

        }

        if(estaPeligro)
        {

            System.out.print("\u001b[42m"+"\u001b[38;5;127m"+" ♞ "+"\u001B[0m" );
            return;

        }

        if(blancas)
        {

            if(color == NEGRAS)
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♞ "+"\u001B[0m" );
            else
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♞ "+"\u001B[0m");

        }
        else
        {

            if (color == NEGRAS)
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♞ "+"\u001B[0m");
            else
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♞ "+"\u001B[0m");

        }

    }

    @Override
    public int[] obtenerMovimientos()
    {

        int[] movimientos = {2, 2, 2, 2, 0};
        return movimientos;

    }

}
