import java.util.ArrayList;

public class Rey extends Pieza
{

    public Rey(int color)
    {

        this.color = color;

    }

    public void enroque()
    {



    }

    @Override
    public ArrayList<String> moverse(int coordenadaX, int coordenadaY)
    {

        int[] movimientos = obtenerMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO HACIA ADELANTE
        for (int j = coordenadaX - 1; j >= coordenadaX - movimientos[0]; j--)
        {

            if(j < 0 || Tablero.validarPiezaAliada(j,coordenadaY))
                break;

            movimientosPermitidos.add(j +""+ coordenadaY);

            if(Tablero.validarPiezaEnemiga(j, coordenadaY))
                break;

        }

        // MOVIMIENTO HACIA LA DERECHA
        for (int j = coordenadaY + 1; j <= coordenadaY + movimientos[1]; j++)
        {

            if(j > 7 || Tablero.validarPiezaAliada(coordenadaX, j))
                break;

            movimientosPermitidos.add(coordenadaX +""+ j);

            if(Tablero.validarPiezaEnemiga(coordenadaX, j))
                break;

        }

        // MOVIMIENTO HACIA ABAJO
        for (int j = coordenadaX + 1; j <= coordenadaX + movimientos[2]; j++)
        {

            if(j > 7 || Tablero.validarPiezaAliada(j,coordenadaY))
                break;

            movimientosPermitidos.add(j +""+ coordenadaY);

            if(Tablero.validarPiezaEnemiga(j, coordenadaY))
                break;

        }

        // MOVIMIENTO HACIA LA IZQUIERDA
        for (int j = coordenadaY - 1; j >= coordenadaY - movimientos[3]; j--)
        {

            if(j < 0 || Tablero.validarPiezaAliada(coordenadaX, j))
                break;

            movimientosPermitidos.add(coordenadaX +""+ j);



        }

        /***** MOVIMIENTO EN DIAGONAL *****/
        // ARRIBA DERECHA
        for(int x = coordenadaX - 1, y = coordenadaY + 1; x >= coordenadaX - movimientos[4] || y < coordenadaY - movimientos[4]; x--, y++)
        {

            if (x < 0 || y > 7 || Tablero.validarPiezaAliada(x,y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }

        // ARRIBA IZQUIERDA
        for(int x = coordenadaX - 1, y = coordenadaY - 1; x >= coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x--, y--)
        {

            if (x < 0 || y < 0 || Tablero.validarPiezaAliada(x,y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }

        // ABAJO IZQUIERDA
        for(int x = coordenadaX + 1, y = coordenadaY - 1; x < coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x++, y--)
        {

            if (x > 7 || y < 0 || Tablero.validarPiezaAliada(x, y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }

        // ABAJO DERECHA
        for(int x = coordenadaX + 1, y = coordenadaY + 1; x <= coordenadaX + movimientos[4] || y <= coordenadaY + movimientos[4]; x++, y++)
        {

            if (x > 7 || y > 7 || Tablero.validarPiezaAliada(x,y))
                break;

            movimientosPermitidos.add(x +""+ y);

            if(Tablero.validarPiezaEnemiga(x, y))
                break;

        }
        /**********************************/

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

                if(piezaObtenida.obtenerColor() == 1)
                {

                    if(piezaObtenida instanceof Peon)
                        return true;

                }

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

                if(piezaObtenida.obtenerColor() == 1)
                {

                    if(piezaObtenida instanceof Peon)
                        return true;

                }

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

                if(piezaObtenida.obtenerColor() == 0)
                {

                    if(piezaObtenida instanceof Peon)
                        return true;

                }

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

                if(piezaObtenida.obtenerColor() == 0)
                {

                    if(piezaObtenida instanceof Peon)
                        return true;

                }

                if(piezaObtenida instanceof Reina || piezaObtenida instanceof Alfil)
                    return true;

                break;

            }

        }
        /**********************************/

        /***** CABALLOS *****/

        if(coordenadaX + 2 <= 7)
        {

            if(coordenadaY - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 2, coordenadaY - 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 2, coordenadaY - 1);

                        if(piezaObtenida instanceof Caballo)
                            return true;

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 2, coordenadaY + 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 2, coordenadaY + 1);

                    if(piezaObtenida instanceof Caballo)
                        return true;

                }

            }

        }

        if(coordenadaX - 2 >= 0)
        {

            if(coordenadaY - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 2, coordenadaY - 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 2, coordenadaY - 1);

                    if(piezaObtenida instanceof Caballo)
                        return true;

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 2, coordenadaY + 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 2, coordenadaY + 1);

                    if(piezaObtenida instanceof Caballo)
                        return true;

                }

            }

        }

        if(coordenadaY + 2 <= 7)
        {

            if(coordenadaX - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 2))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY + 2);

                    if(piezaObtenida instanceof Caballo)
                        return true;

                }

            }

            if(coordenadaX + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 2))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY + 2);

                    if(piezaObtenida instanceof Caballo)
                        return true;

                }

            }

        }

        if(coordenadaY - 2 >= 0)
        {

            if(coordenadaX - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 2))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY - 2);

                    if(piezaObtenida instanceof Caballo)
                        return true;

                }

            }

            if(coordenadaX + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 2))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY - 2);

                    if(piezaObtenida instanceof Caballo)
                        return true;

                }

            }

        }

        /********************/

        return false;

    }

    @Override
    public ArrayList<String> moverseAtacaRey(int coordenadaX, int coordenadaY)
    {

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        return movimientosPermitidos;

    }

    @Override
    public void pintarse(boolean blancas, boolean seleccionada)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        if(seleccionada)
        {

            System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♚ "+"\u001B[0m" );
            return;

        }

        if(blancas)
        {

            if(color == NEGRAS)
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♚ "+"\u001B[0m" );
            else
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♚ "+"\u001B[0m");

        }
        else
        {

            if (color == NEGRAS)
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♚ "+"\u001B[0m");
            else
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♚ "+"\u001B[0m");

        }

    }

    @Override
    public int[] obtenerMovimientos()
    {

        int[] movimientos = {1, 1, 1, 1, 1};
        return movimientos;

    }

}
