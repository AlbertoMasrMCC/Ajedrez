public class Tablero
{

    private Casilla[][] dimensiones;

    public boolean isTurnoBlanca() {
        return turnoBlanca;
    }

    public void setTurnoBlanca(boolean turnoBlanca) {
        this.turnoBlanca = turnoBlanca;
    }

    private boolean turnoBlanca;

    public Tablero()
    {

        dimensiones = new Casilla[8][8];
        turnoBlanca = true;

    }

    public void inicializarTablero()
    {

        boolean blancas = true;

        for (int i = 0; i < dimensiones.length; i++)
        {

            if(blancas)
                blancas = false;
            else
                blancas = true;

            for(int j = 0; j < dimensiones[i].length ; j++)
            {

                Pieza pieza = crearPieza(i, j);

                boolean ocupado = false;

                if(pieza != null)
                    ocupado = true;

                int[] coordenadas = {i, j};

                Casilla casilla = new Casilla(pieza, ocupado, coordenadas);
                dimensiones[i][j] = casilla;

                mostrarTablero(pieza, blancas);

                if(blancas)
                    blancas = false;
                else
                    blancas = true;

            }

            System.out.println();

        }

    }

    private Pieza crearPieza(int coordenadaX, int coordenadaY)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        // CREAR TORRES
        if((coordenadaX == 0 && coordenadaY == 0) || (coordenadaX == 0 && coordenadaY == 7) ||
           (coordenadaX == 7 && coordenadaY == 0) || (coordenadaX == 7 && coordenadaY == 7))
        {

            int[] movimientos = {7, 7, 7, 7, 0};

            Pieza pieza;

            if(coordenadaX == 0)
                pieza = new Torre("Torre", NEGRAS, true, movimientos);
            else
                pieza = new Torre("Torre", BLANCAS, true, movimientos);

            return pieza;

        }

        // CREAR CABALLO
        if((coordenadaX == 0 && coordenadaY == 1) || (coordenadaX == 0 && coordenadaY == 6) ||
           (coordenadaX == 7 && coordenadaY == 1) || (coordenadaX == 7 && coordenadaY == 6))
        {

            int[] movimientos = {2, 2, 2, 2, 0};

            Pieza pieza;

            if(coordenadaX == 0)
                pieza = new Caballo("Caballo", NEGRAS, true, movimientos);
            else
                pieza = new Caballo("Caballo", BLANCAS, true, movimientos);

            return pieza;

        }

        // CREAR ALFIL
        if((coordenadaX == 0 && coordenadaY == 2) || (coordenadaX == 0 && coordenadaY == 5) ||
           (coordenadaX == 7 && coordenadaY == 2) || (coordenadaX == 7 && coordenadaY == 5))
        {

            int[] movimientos = {0, 0, 0, 0, 7};

            Pieza pieza;

            if(coordenadaX == 0)
                pieza = new Alfil("Alfil", NEGRAS, true, movimientos);
            else
                pieza = new Alfil("Alfil", BLANCAS, true, movimientos);

            return pieza;

        }

        // CREAR REY
        if((coordenadaX == 0 && coordenadaY == 3) ||
           (coordenadaX == 7 && coordenadaY == 3))
        {

            int[] movimientos = {1, 1, 1, 1, 1};

            Pieza pieza;

            if(coordenadaX == 0)
                pieza = new Rey("Rey", NEGRAS, true, movimientos);
            else
                pieza = new Rey("Rey", BLANCAS, true, movimientos);

            return pieza;

        }

        // CREAR REINA
        if((coordenadaX == 0 && coordenadaY == 4) ||
           (coordenadaX == 7 && coordenadaY == 4))
        {

            int[] movimientos = {7, 7, 7, 7, 7};

            Pieza pieza;

            if(coordenadaX == 0)
                pieza = new Reina("Reina", NEGRAS, true, movimientos);
            else
                pieza = new Reina("Reina", BLANCAS, true, movimientos);

            return pieza;

        }

        // CREAR PEON
        if((coordenadaX == 1) ||
          (coordenadaX == 6))
        {

            int[] movimientos = {2, 0, 0, 0, 1};

            Pieza pieza;

            if(coordenadaX == 1)
                pieza = new Peon("Peon", NEGRAS, true, movimientos);
            else
                pieza = new Peon("Peon", BLANCAS, true, movimientos);

            return pieza;

        }

        return null;

    }

    public void mostrarTablero(Pieza pieza, boolean blancas)
    {

        final int NEGRAS    = 0;
        final int BLANCAS   = 1;

        if(pieza == null)
        {

            if(blancas)
            {

                System.out.print("\u001B[47m"+"\u001B[37m"+" ♜ " + "\u001B[0m");

            }
            else
            {

                System.out.print("\u001B[40m"+"\u001B[30m"+" ♜ "+"\u001B[0m");

            }

            return;

        }

        if(pieza.getNombre().equals("Torre"))
        {
            if(blancas){

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[47m"+"\u001B[35m"+" ♜ "+"\u001B[0m" );
                else
                    System.out.print("\u001B[47m"+"\u001B[36m"+" ♜ "+"\u001B[0m");

            }else {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[40m" + "\u001B[35m" + " ♜ "+"\u001B[0m");
                else
                    System.out.print("\u001B[40m" + "\u001B[36m" + " ♜ "+"\u001B[0m");

            }

        }

        if(pieza.getNombre().equals("Caballo"))
        {
            if(blancas){

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[47m"+"\u001B[35m"+" ♞ "+"\u001B[0m" );
                else
                    System.out.print("\u001B[47m"+"\u001B[36m"+" ♞ "+"\u001B[0m");

            }else {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[40m" + "\u001B[35m" + " ♞ "+"\u001B[0m");
                else
                    System.out.print("\u001B[40m" + "\u001B[36m" + " ♞ "+"\u001B[0m");

            }

        }

        if(pieza.getNombre().equals("Alfil"))
        {
            if(blancas){

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[47m"+"\u001B[35m"+" ♝ "+"\u001B[0m" );
                else
                    System.out.print("\u001B[47m"+"\u001B[36m"+" ♝ "+"\u001B[0m");

            }else {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[40m" + "\u001B[35m" + " ♝ "+"\u001B[0m");
                else
                    System.out.print("\u001B[40m" + "\u001B[36m" + " ♝ "+"\u001B[0m");

            }

        }

        if(pieza.getNombre().equals("Rey"))
        {
            if(blancas){

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[47m"+"\u001B[35m"+" ♚ "+"\u001B[0m" );
                else
                    System.out.print("\u001B[47m"+"\u001B[36m"+" ♚ "+"\u001B[0m");

            }else {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[40m" + "\u001B[35m" + " ♚ "+"\u001B[0m");
                else
                    System.out.print("\u001B[40m" + "\u001B[36m" + " ♚ "+"\u001B[0m");

            }

        }

        if(pieza.getNombre().equals("Reina"))
        {
            if(blancas){

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[47m"+"\u001B[35m"+" ♛ "+"\u001B[0m" );
                else
                    System.out.print("\u001B[47m"+"\u001B[36m"+" ♛ "+"\u001B[0m");

            }else {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[40m" + "\u001B[35m" + " ♛ "+"\u001B[0m");
                else
                    System.out.print("\u001B[40m" + "\u001B[36m" + " ♛ "+"\u001B[0m");

            }

        }

        if(pieza.getNombre().equals("Peon"))
        {
            if(blancas){

                if(pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[47m"+"\u001B[35m"+" ♙ "+"\u001B[0m" );
                else
                    System.out.print("\u001B[47m"+"\u001B[36m"+" ♙ "+"\u001B[0m");

            }else {

                if (pieza.getLado() == NEGRAS)
                    System.out.print("\u001B[40m" + "\u001B[35m" + " ♙ "+"\u001B[0m");
                else
                    System.out.print("\u001B[40m" + "\u001B[36m" + " ♙ "+"\u001B[0m");

            }

        }

    }

    public void jugada(int coordenadaX, int coordenadaY)
    {



    }

    public Casilla movimientosPosible(Casilla casilla)
    {

        return casilla;

    }

    public boolean validarJaque()
    {

        return true;

    }

    public boolean validarJaqueMate()
    {

        return true;

    }

    public boolean validarJugada(int coordenadaX, int coordenadaY) {

        Casilla casilla = dimensiones[coordenadaX][coordenadaY];
        int turnoActual = 0;

        if (turnoBlanca)
            turnoActual = 1;
        else
            turnoActual = 0;

        if (casilla.getPieza() == null)
            return false;

        if (casilla.getPieza().getLado() != turnoActual)
            return false;

        return true;
    }
}
