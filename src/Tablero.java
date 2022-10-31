import java.util.ArrayList;

public class Tablero
{

    static private Casilla[][] dimensiones;

    static private boolean turnoBlanca;

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

    public static boolean validarPiezaSeleccionada(int coordenadaX, int coordenadaY)
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

    public static boolean validarPiezaEnemiga(int coordenadaX, int coordenadaY)
    {

        int turnoActual;

        if (turnoBlanca)
            turnoActual = 1;
        else
            turnoActual = 0;

        if(dimensiones[coordenadaX][coordenadaY].getPieza() == null)
            return false;

        if (dimensiones[coordenadaX][coordenadaY].getPieza().getLado() == turnoActual)
            return false;

        return true;

    }

    public ArrayList<String> movimientosPosible(int coordenadaX, int coordenadaY)
    {

        Casilla casilla = dimensiones[coordenadaX][coordenadaY];

        Pieza pieza = casilla.getPieza();

        return pieza.moverse(coordenadaX, coordenadaY);

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
