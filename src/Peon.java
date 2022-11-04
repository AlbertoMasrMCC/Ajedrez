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

                    if(Tablero.validarPiezaEnemiga(j, coordenadaY))
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

                    if(Tablero.validarPiezaEnemiga(j, coordenadaY))
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


                    if(Tablero.validarPiezaEnemiga(j, coordenadaY))
                    {

                        Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(j, coordenadaY);

                        if (piezaEnemiga instanceof Rey)
                        {

                            movimientosPermitidos.add(j +""+ coordenadaY);
                            return movimientosPermitidos;

                        }

                    }

                }

            }
            else
            {

                if (!Tablero.validarPiezaAliada(coordenadaX + 1, coordenadaY))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX + 1) +""+ coordenadaY);
                        return movimientosPermitidos;

                    }

                }

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

                    if(Tablero.validarPiezaEnemiga(j, coordenadaY))
                    {

                        Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(j, coordenadaY);

                        if (piezaEnemiga instanceof Rey)
                        {

                            movimientosPermitidos.add(j +""+ coordenadaY);
                            return movimientosPermitidos;

                        }

                    }
                        break;

                }

            }
            else
            {

                if (!Tablero.validarPiezaAliada(coordenadaX - 1,coordenadaY))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX - 1,coordenadaY);

                    if (piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX - 1) +""+ coordenadaY);
                        return movimientosPermitidos;

                    }

                }

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
