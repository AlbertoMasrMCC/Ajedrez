import java.util.ArrayList;

public class Tablero
{

    static private Casilla[][] casillasTablero;

    static private int[] reyNegras;

    static private int[] reyBlancas;

    static private boolean turnoBlanca;

    final static private int[] numeros    = {1, 2, 3, 4, 5, 6, 7, 8};

    final static private String[] letras  = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public Tablero()
    {

        casillasTablero = new Casilla[8][8];
        turnoBlanca     = true;
        reyNegras       = new int[2];
        reyBlancas      = new int[2];
        inicializarTablero();

    }

    public void inicializarTablero()
    {

        int[] coordenadas = new int[2];

        for (int i = 0; i < casillasTablero.length; i++)
        {

            for(int j = 0; j < casillasTablero[i].length ; j++)
            {

                Pieza pieza = crearPieza(i, j);

                coordenadas[0] = i;
                coordenadas[1] = j;

                Casilla casilla = new Casilla(pieza, coordenadas);
                casillasTablero[i][j] = casilla;

                if(pieza instanceof Rey)
                {

                    if(pieza.getLado() == 0)
                    {

                        reyNegras[0] = i;
                        reyNegras[1] = j;

                    }
                    else
                    {

                        reyBlancas[0] = i;
                        reyBlancas[1] = j;

                    }

                    System.out.println();

                }

            }

        }

    }

    public Pieza crearPieza(int coordenadaX, int coordenadaY)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        Pieza pieza;

        // CREAR TORRES
        if((coordenadaX == 0 && coordenadaY == 0) || (coordenadaX == 0 && coordenadaY == 7) ||
           (coordenadaX == 7 && coordenadaY == 0) || (coordenadaX == 7 && coordenadaY == 7))
        {

            if(coordenadaX == 0)
            {

                pieza = new Torre(NEGRAS, true);

            }
            else
            {

                pieza = new Torre(BLANCAS, true);

            }

            return pieza;

        }

        // CREAR CABALLO
        if((coordenadaX == 0 && coordenadaY == 1) || (coordenadaX == 0 && coordenadaY == 6) ||
           (coordenadaX == 7 && coordenadaY == 1) || (coordenadaX == 7 && coordenadaY == 6))
        {

            if(coordenadaX == 0)
            {

                pieza = new Caballo(NEGRAS, true);

            }
            else
            {

                pieza = new Caballo(BLANCAS, true);

            }

            return pieza;

        }

        // CREAR ALFIL
        if((coordenadaX == 0 && coordenadaY == 2) || (coordenadaX == 0 && coordenadaY == 5) ||
           (coordenadaX == 7 && coordenadaY == 2) || (coordenadaX == 7 && coordenadaY == 5))
        {

            if(coordenadaX == 0)
            {

                pieza = new Alfil(NEGRAS, true);

            }
            else
            {

                pieza = new Alfil(BLANCAS, true);

            }

            return pieza;

        }

        // CREAR REY
        if((coordenadaX == 0 && coordenadaY == 3) ||
           (coordenadaX == 7 && coordenadaY == 3))
        {

            if(coordenadaX == 0)
            {

                pieza = new Rey(NEGRAS, true);

            }
            else
            {

                pieza = new Rey(BLANCAS, true);

            }

            return pieza;

        }

        // CREAR REINA
        if((coordenadaX == 0 && coordenadaY == 4) ||
           (coordenadaX == 7 && coordenadaY == 4))
        {

            if(coordenadaX == 0)
            {

                pieza = new Reina(NEGRAS, true);

            }
            else
            {

                pieza = new Reina(BLANCAS, true);

            }

            return pieza;

        }

        // CREAR PEON
        if((coordenadaX == 1) ||
          (coordenadaX == 6))
        {

            if(coordenadaX == 1)
            {

                pieza = new Peon(NEGRAS, true);

            }
            else
            {

                pieza = new Peon(BLANCAS, true);

            }

            return pieza;

        }

        return null;

    }

    public void mostrarTablero()
    {

        int numerosContador = 7;

        boolean blancas = true;

        for (int i = 0; i < casillasTablero.length; i++)
        {

            blancas = !blancas;

            for(int j = 0; j < casillasTablero[i].length; j++)
            {

                pintarPieza(casillasTablero[i][j].getPieza(), blancas, false);

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

        for (int i = 0; i < casillasTablero.length; i++)
        {

            blancas = !blancas;

            for(int j = 0; j < casillasTablero[i].length; j++)
            {

                String movimientoActual = i +"" +j;

                if(movimientosPermitidos.contains(movimientoActual))
                    pintarMovimientosPermitidos();
                else
                {

                    if(movimientoActual.equals(coordenadaPiezaSeleccionada))
                        pintarPieza(casillasTablero[i][j].getPieza(), blancas, true);
                    else
                        pintarPieza(casillasTablero[i][j].getPieza(), blancas, false);

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

        pieza.pintarse(blancas, seleccionada);

    }

    public void pintarMovimientosPermitidos()
    {

        System.out.print("\u001b[42;1m"+"\u001b[32;1m"+" ♜ " + "\u001B[0m");

    }

    public static boolean validarPiezaAliada(int coordenadaX, int coordenadaY)
    {

        int turnoActual = turnoBlanca ? 1 :0;

        if (casillasTablero[coordenadaX][coordenadaY].getPieza() == null)
            return false;

        if (casillasTablero[coordenadaX][coordenadaY].getPieza().getLado() != turnoActual)
            return false;

        return true;

    }

    public static boolean validarPiezaEnemiga(int coordenadaX, int coordenadaY)
    {

        int turnoActual = turnoBlanca ? 1 :0;

        if(casillasTablero[coordenadaX][coordenadaY].getPieza() == null)
            return false;

        if (casillasTablero[coordenadaX][coordenadaY].getPieza().getLado() == turnoActual)
            return false;

        return true;

    }

    public static Pieza obtenerPiezaJaque(int coordenadaX, int coordenadaY)
    {

        return casillasTablero[coordenadaX][coordenadaY].getPieza();

    }

    public ArrayList<String> movimientosPosible(int coordenadaX, int coordenadaY)
    {

        Casilla casilla = casillasTablero[coordenadaX][coordenadaY];

        Pieza pieza = casilla.getPieza();

        return pieza.moverse(coordenadaX, coordenadaY);

    }

    public void jugada(int[] coordenadaOrigen, int[] coordenadaDestino)
    {

        int coordXOrigen = coordenadaOrigen[0];
        int coordYOrigen = coordenadaOrigen[1];
        int coordXDesti = coordenadaDestino[0];
        int coordYDesti = coordenadaDestino[1];

        Casilla casillaOrigen = casillasTablero[coordXOrigen][coordYOrigen];
        Casilla casillaDestino = casillasTablero[coordXDesti][coordYDesti];

        Pieza piezaOrigen = casillaOrigen.getPieza();

        casillaDestino.setPieza(piezaOrigen);

        casillaOrigen.setPieza(null);

    }

    public boolean validarJaque(int[] coordenadaOrigen, int[] coordenadaDestino)
    {

        int coordXOrigen = coordenadaOrigen[0];
        int coordYOrigen = coordenadaOrigen[1];
        int coordXDesti = coordenadaDestino[0];
        int coordYDesti = coordenadaDestino[1];

        Casilla tmpCasillaOrigen = casillasTablero[coordXOrigen][coordYOrigen];
        Casilla tmpCasillaDestino = casillasTablero[coordXDesti][coordYDesti];

        Pieza tmpPiezaOrigen = tmpCasillaOrigen.getPieza();
        Pieza tmpPiezaDestino = tmpCasillaDestino.getPieza();

        Rey rey;
        int coordenadaX;
        int coordenadaY;

        if(turnoBlanca)
        {

            rey = (Rey) casillasTablero[reyBlancas[0]][reyBlancas[1]].getPieza();
            coordenadaX = reyBlancas[0];
            coordenadaY = reyBlancas[1];

        }
        else
        {

            rey = (Rey) casillasTablero[reyNegras[0]][reyNegras[1]].getPieza();
            coordenadaX = reyNegras[0];
            coordenadaY = reyNegras[1];

        }

        jugada(coordenadaOrigen, coordenadaDestino);

        boolean jaque = rey.validarMovimientosJaque(coordenadaX, coordenadaY);

        casillasTablero[coordXOrigen][coordYOrigen].setPieza(tmpPiezaOrigen);
        casillasTablero[coordXDesti][coordYDesti].setPieza(tmpPiezaDestino);

        if(jaque)
            return true;
        else
            return false;

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
