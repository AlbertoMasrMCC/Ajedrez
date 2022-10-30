import java.util.ArrayList;

public class Tablero
{

    private Casilla[][] dimensiones;

    private boolean turnoBlanca;

    static private int[] numeros    = {1, 2, 3, 4, 5, 6, 7, 8};

    static private String[] letras     = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public Tablero()
    {

        dimensiones = new Casilla[8][8];
        turnoBlanca = true;

    }

    public void inicializarTablero()
    {

        boolean ocupado;
        int[] coordenadas = new int[2];

        for (int i = 0; i < dimensiones.length; i++)
        {

            for(int j = 0; j < dimensiones[i].length ; j++)
            {

                Pieza pieza = crearPieza(i, j);

                ocupado = false;

                if(pieza != null)
                    ocupado = true;

                coordenadas[0] = i;
                coordenadas[1] = j;

                Casilla casilla = new Casilla(pieza, ocupado, coordenadas);
                dimensiones[i][j] = casilla;

            }

        }

    }

    private Pieza crearPieza(int coordenadaX, int coordenadaY)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        Pieza pieza;

        // CREAR TORRES
        if((coordenadaX == 0 && coordenadaY == 0) || (coordenadaX == 0 && coordenadaY == 7) ||
           (coordenadaX == 7 && coordenadaY == 0) || (coordenadaX == 7 && coordenadaY == 7))
        {

            if(coordenadaX == 0)
                pieza = new Torre(NEGRAS, true);
            else
                pieza = new Torre(BLANCAS, true);

            return pieza;

        }

        // CREAR CABALLO
        if((coordenadaX == 0 && coordenadaY == 1) || (coordenadaX == 0 && coordenadaY == 6) ||
           (coordenadaX == 7 && coordenadaY == 1) || (coordenadaX == 7 && coordenadaY == 6))
        {

            if(coordenadaX == 0)
                pieza = new Caballo(NEGRAS, true);
            else
                pieza = new Caballo(BLANCAS, true);

            return pieza;

        }

        // CREAR ALFIL
        if((coordenadaX == 0 && coordenadaY == 2) || (coordenadaX == 0 && coordenadaY == 5) ||
           (coordenadaX == 7 && coordenadaY == 2) || (coordenadaX == 7 && coordenadaY == 5))
        {

            if(coordenadaX == 0)
                pieza = new Alfil(NEGRAS, true);
            else
                pieza = new Alfil(BLANCAS, true);

            return pieza;

        }

        // CREAR REY
        if((coordenadaX == 0 && coordenadaY == 3) ||
           (coordenadaX == 7 && coordenadaY == 3))
        {

            if(coordenadaX == 0)
                pieza = new Rey(NEGRAS, true);
            else
                pieza = new Rey(BLANCAS, true);

            return pieza;

        }

        // CREAR REINA
        if((coordenadaX == 0 && coordenadaY == 4) ||
           (coordenadaX == 7 && coordenadaY == 4))
        {

            if(coordenadaX == 0)
                pieza = new Reina(NEGRAS, true);
            else
                pieza = new Reina(BLANCAS, true);

            return pieza;

        }

        // CREAR PEON
        if((coordenadaX == 1) ||
          (coordenadaX == 6))
        {

            if(coordenadaX == 1)
                pieza = new Peon(NEGRAS, true);
            else
                pieza = new Peon(BLANCAS, true);

            return pieza;

        }

        return null;

    }

    public void mostrarTablero()
    {

        int numerosContador = 7;

        boolean blancas = true;

        for (int i = 0; i < dimensiones.length; i++)
        {

            blancas = !blancas;

            for(int j = 0; j < dimensiones[i].length; j++)
            {

                pintarPieza(dimensiones[i][j].getPieza(), blancas, false);

                blancas = !blancas;


                if(j == 7)
                {

                    System.out.println("\u001b[48;5;31m"+"\u001b[38;5;31m"+"♜"+"\u001b[30m"+ numeros[numerosContador] + " "+"\u001b[0m");
                    numerosContador--;

                }

            }

        }

        for (int i = 0; i < letras.length; i++)
        {

            System.out.print("\u001b[48;5;31m"+"\u001b[38;5;31m"+"♜"+"\u001b[30m"+ letras[i]+ " "+"\u001b[0m");

        }

        System.out.println();

    }

    public void mostrarTablero(ArrayList<String> movimientosPermitidos, String coordenadaPiezaSeleccionada)
    {

        int numerosContador = 7;

        boolean blancas = true;

        for (int i = 0; i < dimensiones.length; i++)
        {

            blancas = !blancas;

            for(int j = 0; j < dimensiones[i].length; j++)
            {

                String movimientoActual = i +"" +j;

                if(movimientosPermitidos.contains(movimientoActual))
                    pintarMovimientosPermitidos();
                else
                {

                    if(movimientoActual.equals(coordenadaPiezaSeleccionada))
                        pintarPieza(dimensiones[i][j].getPieza(), blancas, true);
                    else
                        pintarPieza(dimensiones[i][j].getPieza(), blancas, false);

                }

                blancas = !blancas;

                if(j == 7)
                {

                    System.out.println("\u001b[48;5;31m"+"\u001b[38;5;31m"+"♜"+"\u001b[30m"+ numeros[numerosContador] + " "+"\u001b[0m");
                    numerosContador--;

                }

            }

        }

        for (int i = 0; i < letras.length; i++)
        {

            System.out.print("\u001b[48;5;31m"+"\u001b[38;5;31m"+"♜"+"\u001b[30m"+ letras[i]+ " "+"\u001b[0m");

        }

        System.out.println();

    }

    public void pintarPieza(Pieza pieza, boolean blancas, boolean seleccionada)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        if(pieza == null)
        {

            if(blancas)
            {

                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;250m"+" ♜ " + "\u001B[0m");

            }
            else
            {

                System.out.print("\u001b[48;5;8m"+"\u001b[38;5;8m"+" ♜ "+"\u001B[0m");

            }

            return;

        }

        if(pieza instanceof Torre)
        {

            if(seleccionada)
            {

                System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♜ "+"\u001B[0m" );
                return;

            }

            if(blancas)
            {

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♜ "+"\u001B[0m" );
                else
                    System.out.print("\u001b[48;5;7m"+"\u001b[38;5;255m"+" ♜ "+"\u001B[0m");

            }
            else
            {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♜ "+"\u001B[0m");
                else
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♜ "+"\u001B[0m");

            }

            return;

        }

        if(pieza instanceof Caballo)
        {

            if(seleccionada)
            {

                System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♞ "+"\u001B[0m" );
                return;

            }

            if(blancas)
            {

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♞ "+"\u001B[0m" );
                else
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♞ "+"\u001B[0m");

            }
            else
            {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♞ "+"\u001B[0m");
                else
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♞ "+"\u001B[0m");

            }

            return;

        }

        if(pieza instanceof Alfil)
        {

            if(seleccionada)
            {

                System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♝ "+"\u001B[0m" );
                return;

            }

            if(blancas)
            {

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♝ "+"\u001B[0m" );
                else
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♝ "+"\u001B[0m");

            }
            else
            {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♝ "+"\u001B[0m");
                else
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♝ "+"\u001B[0m");

            }

            return;

        }

        if(pieza instanceof Rey)
        {

            if(seleccionada)
            {

                System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♚ "+"\u001B[0m" );
                return;

            }

            if(blancas)
            {

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♚ "+"\u001B[0m" );
                else
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♚ "+"\u001B[0m");

            }
            else
            {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♚ "+"\u001B[0m");
                else
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♚ "+"\u001B[0m");

            }

            return;

        }

        if(pieza instanceof Reina)
        {

            if(seleccionada)
            {

                System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♛ "+"\u001B[0m" );
                return;

            }

            if(blancas)
            {

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♛ "+"\u001B[0m" );
                else
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♛ "+"\u001B[0m");

            }
            else
            {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♛ "+"\u001B[0m");
                else
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♛ "+"\u001B[0m");

            }

            return;

        }

        if(pieza instanceof Peon)
        {

            if(seleccionada)
            {

                System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♙ "+"\u001B[0m" );
                return;

            }

            if(blancas)
            {

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♙ "+"\u001B[0m" );
                else
                    System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♙ "+"\u001B[0m");

            }
            else
            {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♙ "+"\u001B[0m");
                else
                    System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♙ "+"\u001B[0m");

            }

            return;

        }

    }

    public void pintarMovimientosPermitidos()
    {

        System.out.print("\u001b[42;1m"+"\u001b[32;1m"+" ♜ " + "\u001B[0m");

    }

    public boolean validarPiezaSeleccionada(int coordenadaX, int coordenadaY)
    {

        int turnoActual;

        if (turnoBlanca)
            turnoActual = 1;
        else
            turnoActual = 0;

        if (dimensiones[coordenadaX][coordenadaY].getPieza() == null)
            return false;

        if (dimensiones[coordenadaX][coordenadaY].getPieza().getLado() != turnoActual)
            return false;

        return true;

    }

    public ArrayList<String> movimientosPosible(int coordenadaX, int coordenadaY)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        Casilla casilla = dimensiones[coordenadaX][coordenadaY];

        Pieza pieza = casilla.getPieza();

        int[] movimientos = pieza.getMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

            // MOVIMIENTO HACIA ADELANTE
            if(movimientos[0] != 0)
            {

                if(pieza instanceof Peon)
                {

                    if (pieza.getLado() == NEGRAS)
                    {

                        if(coordenadaX == 1)
                        {

                            for (int j = coordenadaX + 1; j <= coordenadaX + movimientos[0]; j++)
                            {

                                if (validarPiezaSeleccionada(j,coordenadaY)){
                                    break;
                                }else{
                                    movimientosPermitidos.add(j +""+ coordenadaY);
                                }

                            }

                        }
                        else
                        {
                            if (!validarPiezaSeleccionada(coordenadaX + 1,coordenadaY))
                                movimientosPermitidos.add((coordenadaX + 1) +""+ coordenadaY);

                        }

                    }
                    else
                    {

                        if(coordenadaX == 6)
                        {

                            for (int j = coordenadaX - 1; j >= coordenadaX - movimientos[0]; j--)
                            {

                                if (validarPiezaSeleccionada(j,coordenadaY)){
                                    break;
                                }else{
                                    movimientosPermitidos.add(j +""+ coordenadaY);
                                }

                            }

                        }
                        else
                        {

                            if (!validarPiezaSeleccionada(coordenadaX - 1,coordenadaY))
                                movimientosPermitidos.add((coordenadaX - 1) +""+ coordenadaY);

                        }

                    }

                }
                else
                    if(pieza instanceof Caballo)
                    {

                        int movimientoPosible = coordenadaX - movimientos[0];

                        if(movimientoPosible >= 0)
                        {

                            if(coordenadaY - 1 >= 0)
                            {
                                if (!validarPiezaSeleccionada(movimientoPosible,coordenadaY-1))
                                    movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));


                            }

                            if(coordenadaY + 1 <= 7)
                            {

                                if (!validarPiezaSeleccionada(movimientoPosible,coordenadaY+1))
                                    movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

                            }

                        }

                    }
                    else
                    {

                        for (int j = coordenadaX - 1; j >= coordenadaX - movimientos[0]; j--)
                        {

                            if(j < 0)
                                break;

                            if (validarPiezaSeleccionada(j,coordenadaY)){
                                break;
                            }else{
                                movimientosPermitidos.add(j +""+ coordenadaY);
                            }

                        }

                    }

            }

            // MOVIMIENTO HACIA LA DERECHA
            if(movimientos[1] != 0)
            {

                if(pieza instanceof Caballo)
                {

                    int movimientoPosible = coordenadaY + movimientos[0];

                    if(movimientoPosible <= 7)
                    {

                        if(coordenadaX - 1 >= 0)
                        {

                            if (!validarPiezaSeleccionada(coordenadaX-1,movimientoPosible))
                                movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

                        }

                        if(coordenadaX + 1 <= 7)
                        {
                            if (!validarPiezaSeleccionada(coordenadaX+1,movimientoPosible))
                                movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);
                        }

                    }

                }
                else
                {

                    for (int j = coordenadaY + 1; j <= coordenadaY + movimientos[1]; j++)
                    {

                        if(j > 7)
                            break;

                        if (validarPiezaSeleccionada(coordenadaX,j)){
                            break;
                        }else{
                            movimientosPermitidos.add(coordenadaX +""+ j);
                        }

                    }

                }

            }

            // MOVIMIENTO HACIA ABAJO
            if(movimientos[2] != 0)
            {

                if(pieza instanceof Caballo)
                {

                    int movimientoPosible = coordenadaX + movimientos[0];

                    if(movimientoPosible <= 7)
                    {

                        if(coordenadaY - 1 >= 0)
                        {

                            if (!validarPiezaSeleccionada(movimientoPosible,coordenadaY-1))
                                movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));
                        }

                        if(coordenadaY + 1 <= 7)
                        {

                            if (!validarPiezaSeleccionada(movimientoPosible,coordenadaY+1))
                                movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

                        }

                    }

                }
                else
                {

                    for (int j = coordenadaX + 1; j <= coordenadaX + movimientos[2]; j++)
                    {

                        if(j > 7)
                            break;

                        if (validarPiezaSeleccionada(j,coordenadaY)){
                            break;
                        }else{
                            movimientosPermitidos.add(j +""+ coordenadaY);
                        }


                    }

                }

            }

            // MOVIMIENTO HACIA LA IZQUIERDA
            if(movimientos[3] != 0)
            {

                if(pieza instanceof Caballo)
                {

                    int movimientoPosible = coordenadaY - movimientos[0];

                    if(movimientoPosible >= 0)
                    {

                        if(coordenadaX - 1 >= 0)
                        {

                            if (!validarPiezaSeleccionada(coordenadaX-1,movimientoPosible))
                                movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

                        }

                        if(coordenadaX + 1 <= 7)
                        {
                            if (!validarPiezaSeleccionada(coordenadaX+1,movimientoPosible))
                                movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);
                        }

                    }

                }
                else
                {

                    for (int j = coordenadaY - 1; j >= coordenadaY - movimientos[3]; j--)
                    {

                        if(j < 0)
                            break;

                        if (validarPiezaSeleccionada(coordenadaX,j)){
                            break;
                        }else{
                            movimientosPermitidos.add(coordenadaX +""+ j);
                        }


                    }

                }

            }

            // MOVIMIENTO EN DIAGONAL
            if(movimientos[4] != 0)
            {

                if(pieza instanceof Peon)
                    return movimientosPermitidos;

                // ARRIBA DERECHA
                for(int x = coordenadaX - 1, y = coordenadaY + 1; x >= coordenadaX - movimientos[4] || y < coordenadaY - movimientos[4]; x--, y++)
                {

                    if (x < 0)
                        break;

                    if(y > 7)
                        break;

                    if (validarPiezaSeleccionada(x,y)){
                        break;
                    }else{
                        movimientosPermitidos.add(x +""+ y);
                    }



                }

                // ARRIBA IZQUIERDA
                for(int x = coordenadaX - 1, y = coordenadaY - 1; x >= coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x--, y--)
                {

                    if (x < 0)
                        break;

                    if(y < 0)
                        break;

                    if (validarPiezaSeleccionada(x,y)){
                        break;
                    }else{
                        movimientosPermitidos.add(x +""+ y);
                    }

                }

                // ABAJO IZQUIERDA
                for(int x = coordenadaX + 1, y = coordenadaY - 1; x < coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x++, y--)
                {

                    if (x > 7)
                        break;

                    if(y < 0)
                        break;

                    if (validarPiezaSeleccionada(x,y)){
                        break;
                    }else{
                        movimientosPermitidos.add(x +""+ y);
                    }
                }

                // ABAJO DERECHA
                for(int x = coordenadaX + 1, y = coordenadaY + 1; x > coordenadaX - movimientos[4] || y >= coordenadaY - movimientos[4]; x++, y++)
                {

                    if (x > 7)
                        break;

                    if(y > 7)
                        break;

                   if (validarPiezaSeleccionada(x,y)){
                        break;
                    }else{
                        movimientosPermitidos.add(x +""+ y);
                    }


                }

            }

        return movimientosPermitidos;

    }

    public void jugada(int[] coordenadaOrigen, int[] coordenadaDestino)
    {
        int coordXOrigen = coordenadaOrigen[0];
        int coordYOrigen = coordenadaOrigen[1];
        int coordXDesti = coordenadaDestino[0];
        int coordYDesti = coordenadaDestino[1];

        Casilla casillaOrigen = dimensiones[coordXOrigen][coordYOrigen];
        Casilla casillaDestino = dimensiones[coordXDesti][coordYDesti];

        Pieza piezaOrigen = casillaOrigen.getPieza();

        casillaDestino.setPieza(piezaOrigen);

        casillaOrigen.setPieza(null);

    }

    public boolean validarJaque()
    {

        return true;

    }

    public boolean validarJaqueMate()
    {

        return false;

    }

    public boolean isTurnoBlanca()
    {

        return turnoBlanca;

    }

    public void setTurnoBlanca(boolean turnoBlanca)
    {

        this.turnoBlanca = turnoBlanca;

    }

    public static int[] getNumeros() {
        return numeros;
    }

    public static String[] getLetras() {
        return letras;
    }

}
