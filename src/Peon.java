import java.util.ArrayList;
import java.util.Scanner;

public class Peon extends Pieza
{

    public Peon(int color)
    {

        this.color = color;

    }

    public void convertirse(int [] coordenadaPieza)
    {

        int opcion = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.println("¡Tu peon llegó al otro extremo del tablero! \n Selecciona la pieza en la que te quieres convertir.");
        System.out.println("1. Alfil");
        System.out.println("2. Torre");
        System.out.println("3. Caballo");
        System.out.println("4. Reina");

        while (true)
        {

            try
            {

                opcion = Integer.parseInt(entrada.nextLine());

                if (opcion < 1 || opcion > 4)
                {

                    System.out.println("Selecciona una opción entre 1 y 4.");
                    continue;

                }

                break;

            }
            catch (Exception e)
            {

                System.out.println("Selecciona una opción entre 1 y 4.");

            }

        }

        Pieza piezaNueva = null;

        switch (opcion)
        {

            case 1:
                piezaNueva = new Alfil(color);
            break;

            case 2:
                piezaNueva = new Torre(color);
            break;

            case 3:
                piezaNueva = new Caballo(color);
            break;

            case 4:
                piezaNueva = new Reina(color);
            break;

        }

        Tablero.cambiarPeonTablero(coordenadaPieza, piezaNueva, color);

    }

    @Override
    public ArrayList<String> moverse(int coordenadaX, int coordenadaY)
    {

        final int NEGRAS            = 0;

        int[] movimientos = obtenerMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO HACIA ADELANTE
        if (color == NEGRAS)
        {

            if(coordenadaX == 1)
            {

                for (int j = coordenadaX + 1; j <= coordenadaX + movimientos[0]; j++)
                {

                    if (Tablero.validarPiezaAliada(j,coordenadaY))
                        break;

                    if(Tablero.validarPiezaEnemiga(j, coordenadaY))
                        break;

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {j, coordenadaY};

                    if(Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        break;

                    movimientosPermitidos.add(j +""+ coordenadaY);

                }

            }
            else
            {

                if (!Tablero.validarPiezaAliada(coordenadaX + 1, coordenadaY))
                {

                    if(!Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY))
                    {

                        int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                        int[] coordenadasDestino    = {coordenadaX + 1, coordenadaY};

                        if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                            movimientosPermitidos.add((coordenadaX + 1) +""+ coordenadaY);

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
                        break;

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {j, coordenadaY};

                    if(Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        break;

                    movimientosPermitidos.add(j +""+ coordenadaY);

                }

            }
            else
            {

                if (!Tablero.validarPiezaAliada(coordenadaX - 1,coordenadaY))
                {

                    if (!Tablero.validarPiezaEnemiga(coordenadaX - 1,coordenadaY))
                    {

                        int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                        int[] coordenadasDestino    = {coordenadaX - 1, coordenadaY};

                        if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                            movimientosPermitidos.add((coordenadaX - 1) +""+ coordenadaY);

                    }

                }

            }

        }

        // MOVIMIENTO EN DIAGONAL
        if(color == NEGRAS)
        {

            if(coordenadaY != 0 && coordenadaY != 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX + 1, coordenadaY + 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY + 1));

                }

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX + 1, coordenadaY - 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY - 1));

                }

            }

            if(coordenadaY == 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX + 1, coordenadaY + 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY + 1));

                }

            }

            if(coordenadaY == 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX + 1, coordenadaY - 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY - 1));

                }

            }

        }
        else
        {

            if(coordenadaY != 0 && coordenadaY != 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX - 1, coordenadaY + 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY + 1));

                }

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX - 1, coordenadaY - 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY - 1));

                }

            }

            if(coordenadaY == 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX - 1, coordenadaY + 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY + 1));

                }

            }

            if(coordenadaY == 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                {

                    int[] coordenadasOrigen     = {coordenadaX, coordenadaY};
                    int[] coordenadasDestino    = {coordenadaX - 1, coordenadaY - 1};

                    if(!Tablero.validarJaqueAlMoverPiezaPropia(coordenadasOrigen, coordenadasDestino))
                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY - 1));

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

        /***** PEON *****/

        if(coordenadaX + 1 <= 7)
        {

            if(coordenadaY - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY - 1);

                    if(piezaObtenida.obtenerColor() == 1)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY + 1);

                    if(piezaObtenida.obtenerColor() == 1)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

        }

        if(coordenadaX - 1 >= 0)
        {

            if(coordenadaY - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY - 1);

                    if(piezaObtenida.obtenerColor() == 0)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

            if(coordenadaY + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY + 1);

                    if(piezaObtenida.obtenerColor() == 0)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

        }

        if(coordenadaY + 1 <= 7)
        {

            if(coordenadaX - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY + 1);

                    if(piezaObtenida.obtenerColor() == 0)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

            if(coordenadaX + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY + 1);

                    if(piezaObtenida.obtenerColor() == 1)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

        }

        if(coordenadaY - 1 >= 0)
        {

            if(coordenadaX - 1 >= 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY - 1);

                    if(piezaObtenida.obtenerColor() == 0)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

            if(coordenadaX + 1 <= 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                {

                    Pieza piezaObtenida = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY - 1);

                    if(piezaObtenida.obtenerColor() == 1)
                    {

                        if(piezaObtenida instanceof Peon)
                            return true;

                    }

                }

            }

        }

        /***************/

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

        final int NEGRAS            = 0;

        int[] movimientos = obtenerMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO EN DIAGONAL
        if(color == NEGRAS)
        {

            if(coordenadaY != 0 && coordenadaY != 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY + 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY + 1));

                        return  movimientosPermitidos;

                    }

                }

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY - 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY - 1));

                        return  movimientosPermitidos;

                    }

                }

            }

            if(coordenadaY == 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY + 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY + 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY + 1));

                        return  movimientosPermitidos;

                    }

                }

            }

            if(coordenadaY == 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX + 1, coordenadaY - 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX + 1, coordenadaY - 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX + 1) +""+ (coordenadaY - 1));

                        return  movimientosPermitidos;

                    }

                }

            }

        }
        else
        {

            if(coordenadaY != 0 && coordenadaY != 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY + 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY + 1));

                        return  movimientosPermitidos;

                    }

                }

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY - 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY - 1));

                        return  movimientosPermitidos;

                    }

                }

            }

            if(coordenadaY == 0)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY + 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY + 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY + 1));

                        return  movimientosPermitidos;

                    }

                }

            }

            if(coordenadaY == 7)
            {

                if(Tablero.validarPiezaEnemiga(coordenadaX - 1, coordenadaY - 1))
                {

                    Pieza piezaEnemiga = Tablero.obtenerPiezaJaque(coordenadaX - 1, coordenadaY - 1);

                    if(piezaEnemiga instanceof Rey)
                    {

                        movimientosPermitidos.add((coordenadaX - 1) +""+ (coordenadaY - 1));

                        return  movimientosPermitidos;

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

            System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♙ "+"\u001B[0m" );
            return;

        }

        if(estaPeligro)
        {

            System.out.print("\u001b[42m"+"\u001b[38;5;127m"+" ♙ "+"\u001B[0m" );
            return;

        }

        if(blancas)
        {

            if(color == NEGRAS)
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♙ "+"\u001B[0m" );
            else
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♙ "+"\u001B[0m");

        }
        else
        {

            if (color == NEGRAS)
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♙ "+"\u001B[0m");
            else
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♙ "+"\u001B[0m");

        }

    }

    @Override
    public int[] obtenerMovimientos()
    {

        int[] movimientos = {2, 0, 0, 0, 1};
        return movimientos;

    }

}
