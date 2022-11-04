import java.util.ArrayList;

public class Tablero
{

    static private Casilla[][] casillasTablero;

    static private ArrayList<Casilla> piezasNegras;

    static private ArrayList<Casilla> piezasBlancas;

    static private boolean turnoBlanca;

    final static private int[] numeros    = {1, 2, 3, 4, 5, 6, 7, 8};

    final static private String[] letras  = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public Tablero()
    {

        casillasTablero = new Casilla[8][8];
        turnoBlanca     = true;
        piezasNegras    = new ArrayList<>();
        piezasBlancas   = new ArrayList<>();
        inicializarTablero();

    }

    public void inicializarTablero()
    {

        for (int i = 0; i < casillasTablero.length; i++)
        {

            for(int j = 0; j < casillasTablero[i].length ; j++)
            {

                Pieza pieza = crearPieza(i, j);

                int[]coordenadas = {i , j};

                Casilla casilla = new Casilla(pieza, coordenadas);
                casillasTablero[i][j] = casilla;

                if(pieza != null)
                {

                    if(pieza.getLado() == 0)
                    {

                        piezasNegras.add(casilla);

                    }
                    else
                    {

                        piezasBlancas.add(casilla);

                    }

                    System.out.println();

                }

            }

        }

        ordenarArreglosPiezas();

    }

    public void ordenarArreglosPiezas()
    {

        ArrayList<Casilla> tmpPiezasNegras = new ArrayList<>();
        ArrayList<Casilla> tmpPiezasBlancas = new ArrayList<>();

        // Rey negras
        tmpPiezasNegras.add(piezasNegras.get(3));
        piezasNegras.remove(3);

        // Rey blancas
        tmpPiezasBlancas.add(piezasBlancas.get(11));
        piezasBlancas.remove(11);

        for (Casilla piezaNegras: piezasNegras)
        {

            tmpPiezasNegras.add(piezaNegras);

        }

        for (Casilla piezaBlancas: piezasBlancas)
        {

            tmpPiezasBlancas.add(piezaBlancas);

        }

        piezasNegras.clear();
        piezasBlancas.clear();

        piezasNegras = tmpPiezasNegras;
        piezasBlancas = tmpPiezasBlancas;

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

                pintarPieza(casillasTablero[i][j], blancas, false);

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
                        pintarPieza(casillasTablero[i][j], blancas, true);
                    else
                        pintarPieza(casillasTablero[i][j], blancas, false);

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

    public void pintarPieza(Casilla casilla, boolean blancas, boolean seleccionada)
    {

        if(casilla.getPieza() == null)
        {

            casilla.pintarse(blancas);

            return;

        }

        casilla.getPieza().pintarse(blancas, seleccionada);

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

        if(piezaOrigen instanceof Rey)
        {

            int[] cordenadasPiezas;

            if(piezaOrigen.getLado() == 0)
            {

                cordenadasPiezas = piezasNegras.get(0).getCoordenadas();

                cordenadasPiezas[0] = coordXDesti;
                cordenadasPiezas[1] = coordYDesti;

            }
            else
            {

                cordenadasPiezas = piezasBlancas.get(0).getCoordenadas();

                cordenadasPiezas[0] = coordXDesti;
                cordenadasPiezas[1] = coordYDesti;

            }

        }

        casillaDestino.setPieza(piezaOrigen);

        casillaOrigen.setPieza(null);

    }

    public boolean validarJaque(int[] coordenadaOrigen, int[] coordenadaDestino, int tipoValidacion)
    {

        if(tipoValidacion == 1)
            if(validarJaqueAlMoverPiezaPropia(coordenadaOrigen, coordenadaDestino))
                return true;

        if(tipoValidacion == 2)
            if(validarJaqueAlMoverPieza())
                return true;

        return false;

    }

    public boolean validarJaqueAlMoverPiezaPropia(int[] coordenadaOrigen, int[] coordenadaDestino)
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

        int[] cordenadasPiezas;

        if(turnoBlanca)
        {

            cordenadasPiezas = piezasBlancas.get(0).getCoordenadas();

            rey = (Rey) casillasTablero[cordenadasPiezas[0]][cordenadasPiezas[1]].getPieza();

        }
        else
        {

            cordenadasPiezas = piezasNegras.get(0).getCoordenadas();

            rey = (Rey) casillasTablero[cordenadasPiezas[0]][cordenadasPiezas[1]].getPieza();

        }

        jugada(coordenadaOrigen, coordenadaDestino);

        if(turnoBlanca)
        {

            coordenadaX = cordenadasPiezas[0];
            coordenadaY = cordenadasPiezas[1];

        }
        else
        {

            coordenadaX = cordenadasPiezas[0];
            coordenadaY = cordenadasPiezas[1];

        }

        boolean jaque = rey.validarMovimientosJaque(coordenadaX, coordenadaY);

        casillasTablero[coordXOrigen][coordYOrigen].setPieza(tmpPiezaOrigen);
        casillasTablero[coordXDesti][coordYDesti].setPieza(tmpPiezaDestino);

        if(tmpPiezaOrigen instanceof Rey)
        {

            if(tmpPiezaOrigen.getLado() == 0)
            {

                cordenadasPiezas[0] = coordXOrigen;
                cordenadasPiezas[1] = coordYOrigen;

            }
            else
            {

                cordenadasPiezas[0] = coordXOrigen;
                cordenadasPiezas[1] = coordYOrigen;

            }

        }

        if(jaque)
            return true;
        else
            return false;

    }

    public boolean validarJaqueAlMoverPieza()
    {

        Rey rey;
        int coordenadaX;
        int coordenadaY;

        int[] cordenadasPiezas;

        if(turnoBlanca)
        {

            cordenadasPiezas = piezasBlancas.get(0).getCoordenadas();

            rey = (Rey) casillasTablero[cordenadasPiezas[0]][cordenadasPiezas[1]].getPieza();
            coordenadaX = cordenadasPiezas[0];
            coordenadaY = cordenadasPiezas[1];

        }
        else
        {

            cordenadasPiezas = piezasNegras.get(0).getCoordenadas();

            rey = (Rey) casillasTablero[cordenadasPiezas[0]][cordenadasPiezas[1]].getPieza();
            coordenadaX = cordenadasPiezas[0];
            coordenadaY = cordenadasPiezas[1];

        }

        boolean jaque = rey.validarMovimientosJaque(coordenadaX, coordenadaY);

        if(jaque)
            return true;
        else
            return false;

    }

    public boolean validarJaqueMate(int[] coordenadaPiezaPeligrosa)
    {

        if(!validarJaqueMateRey())
            return false;

        if(!validarJaqueMatePiezaPeligrosa(coordenadaPiezaPeligrosa))
            return false;

        if(!validarJaqueMateBloquear(coordenadaPiezaPeligrosa))
            return false;

        return true;

    }

    public boolean validarJaqueMateRey()
    {

        int[] coordenadasRey;
        Pieza rey;

        if(turnoBlanca)
        {

            coordenadasRey  = piezasBlancas.get(0).getCoordenadas();
            rey             = piezasBlancas.get(0).getPieza();

        }
        else
        {

            coordenadasRey  = piezasNegras.get(0).getCoordenadas();
            rey             = piezasNegras.get(0).getPieza();

        }

        ArrayList<String> movimientosPosible = rey.moverse(coordenadasRey[0], coordenadasRey[1]);

        for (String movimientoRey: movimientosPosible)
        {

            int[] coordenadasDestinoRey = {Integer.parseInt(Character.toString(movimientoRey.charAt(0))), Integer.parseInt(Character.toString(movimientoRey.charAt(1)))};

            if(!validarJaque(coordenadasRey, coordenadasDestinoRey, 1))
                return false;

        }

        return true;

    }

    public boolean validarJaqueMatePiezaPeligrosa(int[] coordenadaPiezaPeligrosa)
    {

        Pieza piezaPeligrosa = casillasTablero[coordenadaPiezaPeligrosa[0]][coordenadaPiezaPeligrosa[1]].getPieza();

        setTurnoBlanca(!turnoBlanca);

        boolean jaque = piezaPeligrosa.validarMovimientosJaque(coordenadaPiezaPeligrosa[0], coordenadaPiezaPeligrosa[1]);

        setTurnoBlanca(!turnoBlanca);

        if(jaque)
            return false;
        else
            return true;

    }

    public boolean validarJaqueMateBloquear(int[] coordenadaPiezaPeligrosa)
    {

        Pieza piezaPeligrosa = casillasTablero[coordenadaPiezaPeligrosa[0]][coordenadaPiezaPeligrosa[1]].getPieza();

        setTurnoBlanca(!turnoBlanca);

        ArrayList<String> movimientosPiezaPeligrosa = piezaPeligrosa.moverseAtacaRey(coordenadaPiezaPeligrosa[0], coordenadaPiezaPeligrosa[1]);

        ArrayList<Casilla> piezasValidar;

        if(piezaPeligrosa.getLado() == 0)
            piezasValidar = piezasBlancas;
        else
            piezasValidar = piezasNegras;

        for (Casilla piezasEnemigas: piezasValidar)
        {

            Pieza piezaEnemiga      = piezasEnemigas.getPieza();

            if(piezaEnemiga instanceof Rey)
                continue;

            int[] coordenadaEnemiga = piezasEnemigas.getCoordenadas();

            ArrayList<String> movimientosPiezaEnemiga = piezaEnemiga.moverse(coordenadaEnemiga[0], coordenadaEnemiga[1]);

            for (String movimientoEnemigo: movimientosPiezaEnemiga)
            {

                if(movimientosPiezaPeligrosa.contains(movimientoEnemigo))
                {

                    setTurnoBlanca(!turnoBlanca);
                    return false;

                }

            }

        }

        setTurnoBlanca(!turnoBlanca);

        return true;

    }

    public boolean isTurnoBlanca()
    {

        return turnoBlanca;

    }

    public void setTurnoBlanca(boolean turnoBlanca)
    {

        this.turnoBlanca = turnoBlanca;

    }

    public static int[] getNumeros()
    {

        return numeros;

    }

    public static String[] getLetras()
    {

        return letras;

    }

}
