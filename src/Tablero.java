import java.util.ArrayList;

public class Tablero
{

    static private Casilla[][] casillasTablero;

    static private boolean turnoBlanca;

    static private ArrayList<Casilla> piezasNegras;

    static private ArrayList<Casilla> piezasBlancas;

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

                    if(pieza.obtenerColor() == 0)
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
        tmpPiezasNegras.add(piezasNegras.get(4));
        piezasNegras.remove(4);

        // Rey blancas
        tmpPiezasBlancas.add(piezasBlancas.get(12));
        piezasBlancas.remove(12);

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

    public static int encontrarElementoArregloPiezas(ArrayList<Casilla> piezasBuscar, int coordenadaX, int coordenadaY)
    {

        for (int i = 0; i < piezasBuscar.size(); i++)
        {

            int [] coordenadasPiezaEncontrar = piezasBuscar.get(i).obtenerCoordenadas();

            if(coordenadasPiezaEncontrar[0] == coordenadaX && coordenadasPiezaEncontrar[1] == coordenadaY)
                return i;

        }

        return -1;

    }

    public static ArrayList<Casilla> copiarElementosArregloPiezas(ArrayList<Casilla> arregloOrigen, ArrayList<Casilla> arregloDestino)
    {

        arregloDestino.clear();

        for(Casilla piezaCopiar: arregloOrigen)
        {

            arregloDestino.add(piezaCopiar);

        }

        return arregloDestino;

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

                pieza = new Torre(NEGRAS);

            }
            else
            {

                pieza = new Torre(BLANCAS);

            }

            return pieza;

        }

        // CREAR CABALLO
        if((coordenadaX == 0 && coordenadaY == 1) || (coordenadaX == 0 && coordenadaY == 6) ||
           (coordenadaX == 7 && coordenadaY == 1) || (coordenadaX == 7 && coordenadaY == 6))
        {

            if(coordenadaX == 0)
            {

                pieza = new Caballo(NEGRAS);

            }
            else
            {

                pieza = new Caballo(BLANCAS);

            }

            return pieza;

        }

        // CREAR ALFIL
        if((coordenadaX == 0 && coordenadaY == 2) || (coordenadaX == 0 && coordenadaY == 5) ||
           (coordenadaX == 7 && coordenadaY == 2) || (coordenadaX == 7 && coordenadaY == 5))
        {

            if(coordenadaX == 0)
            {

                pieza = new Alfil(NEGRAS);

            }
            else
            {

                pieza = new Alfil(BLANCAS);

            }

            return pieza;

        }

        // CREAR REY
        if((coordenadaX == 0 && coordenadaY == 4) ||
           (coordenadaX == 7 && coordenadaY == 4))
        {

            if(coordenadaX == 0)
            {

                pieza = new Rey(NEGRAS);

            }
            else
            {

                pieza = new Rey(BLANCAS);

            }

            return pieza;

        }

        // CREAR REINA
        if((coordenadaX == 0 && coordenadaY == 3) ||
           (coordenadaX == 7 && coordenadaY == 3))
        {

            if(coordenadaX == 0)
            {

                pieza = new Reina(NEGRAS);

            }
            else
            {

                pieza = new Reina(BLANCAS);

            }

            return pieza;

        }

        // CREAR PEON
        if((coordenadaX == 1) ||
          (coordenadaX == 6))
        {

            if(coordenadaX == 1)
            {

                pieza = new Peon(NEGRAS);

            }
            else
            {

                pieza = new Peon(BLANCAS);

            }

            return pieza;

        }

        return null;

    }

    public void mostrarTablero()
    {

        int numerosContador = 7;

        boolean blancas = false;

        for (int i = 0; i < casillasTablero.length; i++)
        {

            blancas = !blancas;

            for(int j = 0; j < casillasTablero[i].length; j++)
            {

                pintarPieza(casillasTablero[i][j], blancas, false, false);

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

        boolean blancas = false;

        for (int i = 0; i < casillasTablero.length; i++)
        {

            blancas = !blancas;

            for(int j = 0; j < casillasTablero[i].length; j++)
            {

                String movimientoActual = i +"" +j;

                if(movimientosPermitidos.contains(movimientoActual))
                {

                    Pieza pieza = casillasTablero[i][j].obtenerPieza();

                    if(pieza != null)
                        pintarPieza(casillasTablero[i][j], blancas, false, true);
                    else
                        pintarMovimientosPermitidos();

                }
                else
                {

                    if(movimientoActual.equals(coordenadaPiezaSeleccionada))
                        pintarPieza(casillasTablero[i][j], blancas, true, false);
                    else
                        pintarPieza(casillasTablero[i][j], blancas, false, false);

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

    public void pintarPieza(Casilla casilla, boolean blancas, boolean seleccionada, boolean estaPeligro)
    {

        if(casilla.obtenerPieza() == null)
        {

            casilla.pintarse(blancas);

            return;

        }

        casilla.obtenerPieza().pintarse(blancas, seleccionada, estaPeligro);

    }

    public void pintarMovimientosPermitidos()
    {

        System.out.print("\u001b[42;1m"+"\u001b[32;1m"+" ♜ " + "\u001B[0m");

    }

    public static boolean validarPiezaAliada(int coordenadaX, int coordenadaY)
    {

        int turnoActual = turnoBlanca ? 1 :0;

        if (casillasTablero[coordenadaX][coordenadaY].obtenerPieza() == null)
            return false;

        if (casillasTablero[coordenadaX][coordenadaY].obtenerPieza().obtenerColor() != turnoActual)
            return false;

        return true;

    }

    public static boolean validarPiezaEnemiga(int coordenadaX, int coordenadaY)
    {

        int turnoActual = turnoBlanca ? 1 :0;

        if(casillasTablero[coordenadaX][coordenadaY].obtenerPieza() == null)
            return false;

        if (casillasTablero[coordenadaX][coordenadaY].obtenerPieza().obtenerColor() == turnoActual)
            return false;

        return true;

    }

    public void validarConversionPeon(int [] coordenadaPieza)
    {

        Casilla casillaPieza = casillasTablero[coordenadaPieza[0]] [coordenadaPieza[1]];

        Pieza pieza = casillaPieza.obtenerPieza();

        if(!(pieza instanceof Peon))
            return;

        if(pieza.obtenerColor() == 0)
        {

            if(coordenadaPieza[0] != 7)
                return;

            ((Peon) pieza).convertirse(coordenadaPieza);

        }
        else
        {

            if(coordenadaPieza[0] != 0)
                return;

            ((Peon) pieza).convertirse(coordenadaPieza);

        }

    }

    public boolean validarEmpate()
    {

        if(piezasBlancas.size() == 1 && piezasNegras.size() == 1)
            return true;
        else
            return false;

    }

    public static void cambiarPeonTablero(int[] coordenadasPeon, Pieza piezaNueva, int color)
    {

        casillasTablero[coordenadasPeon[0]][coordenadasPeon[1]].establecerPieza(piezaNueva);

    }

    public static Pieza obtenerPiezaJaque(int coordenadaX, int coordenadaY)
    {

        return casillasTablero[coordenadaX][coordenadaY].obtenerPieza();

    }

    public ArrayList<String> movimientosPosible(int coordenadaX, int coordenadaY)
    {

        Casilla casilla = casillasTablero[coordenadaX][coordenadaY];

        Pieza pieza = casilla.obtenerPieza();

        return pieza.moverse(coordenadaX, coordenadaY);

    }

    public static void jugada(int[] coordenadaOrigen, int[] coordenadaDestino)
    {

        int coordXOrigen = coordenadaOrigen[0];
        int coordYOrigen = coordenadaOrigen[1];
        int coordXDesti = coordenadaDestino[0];
        int coordYDesti = coordenadaDestino[1];

        Casilla casillaOrigen = casillasTablero[coordXOrigen][coordYOrigen];
        Casilla casillaDestino = casillasTablero[coordXDesti][coordYDesti];

        Pieza piezaOrigen  = casillaOrigen.obtenerPieza();
        Pieza piezaDestino = casillaDestino.obtenerPieza();

        if(turnoBlanca)
        {

            int indiceArreglo = encontrarElementoArregloPiezas(piezasBlancas, coordXOrigen, coordYOrigen);

            piezasBlancas.set(indiceArreglo, casillaDestino);

            if(piezaDestino != null)
                piezasNegras.remove(casillaDestino);

        }
        else
        {

            int indiceArreglo = encontrarElementoArregloPiezas(piezasNegras, coordXOrigen, coordYOrigen);

            piezasNegras.set(indiceArreglo, casillaDestino);

            if(piezaDestino != null)
                piezasBlancas.remove(casillaDestino);

        }

        casillaDestino.establecerPieza(piezaOrigen);

        casillaOrigen.establecerPieza(null);

    }

    public static boolean validarJaque(int[] coordenadaOrigen, int[] coordenadaDestino, int tipoValidacion)
    {

        if(tipoValidacion == 1)
            if(validarJaqueAlMoverPiezaPropia(coordenadaOrigen, coordenadaDestino))
                return true;

        if(tipoValidacion == 2)
            if(validarJaqueAlMoverPieza())
                return true;

        return false;

    }

    public static boolean validarJaqueAlMoverPiezaPropia(int[] coordenadaOrigen, int[] coordenadaDestino)
    {

        int coordXOrigen = coordenadaOrigen[0];
        int coordYOrigen = coordenadaOrigen[1];
        int coordXDesti = coordenadaDestino[0];
        int coordYDesti = coordenadaDestino[1];

        Casilla tmpCasillaOrigen = casillasTablero[coordXOrigen][coordYOrigen];
        Casilla tmpCasillaDestino = casillasTablero[coordXDesti][coordYDesti];

        Pieza tmpPiezaOrigen = tmpCasillaOrigen.obtenerPieza();
        Pieza tmpPiezaDestino = tmpCasillaDestino.obtenerPieza();

        ArrayList<Casilla> tmpPiezasNegras = new ArrayList<>();
        ArrayList<Casilla> tmpPiezasBlancas = new ArrayList<>();

        tmpPiezasNegras = copiarElementosArregloPiezas(piezasNegras, tmpPiezasNegras);
        tmpPiezasBlancas = copiarElementosArregloPiezas(piezasBlancas, tmpPiezasBlancas);

        Rey rey;
        int coordenadaX;
        int coordenadaY;

        int[] cordenadasRey;

        if(turnoBlanca)
        {

            cordenadasRey = piezasBlancas.get(0).obtenerCoordenadas();
            rey = (Rey) casillasTablero[cordenadasRey[0]][cordenadasRey[1]].obtenerPieza();

        }
        else
        {

            cordenadasRey = piezasNegras.get(0).obtenerCoordenadas();
            rey = (Rey) casillasTablero[cordenadasRey[0]][cordenadasRey[1]].obtenerPieza();

        }

        jugada(coordenadaOrigen, coordenadaDestino);

        if(turnoBlanca)
        {

            cordenadasRey = piezasBlancas.get(0).obtenerCoordenadas();
            coordenadaX = cordenadasRey[0];
            coordenadaY = cordenadasRey[1];

        }
        else
        {

            cordenadasRey = piezasNegras.get(0).obtenerCoordenadas();
            coordenadaX = cordenadasRey[0];
            coordenadaY = cordenadasRey[1];

        }

        boolean jaque = rey.validarMovimientosJaque(coordenadaX, coordenadaY);

        casillasTablero[coordXOrigen][coordYOrigen].establecerPieza(tmpPiezaOrigen);
        casillasTablero[coordXDesti][coordYDesti].establecerPieza(tmpPiezaDestino);

        piezasNegras = copiarElementosArregloPiezas(tmpPiezasNegras, piezasNegras);
        piezasBlancas = copiarElementosArregloPiezas(tmpPiezasBlancas, piezasBlancas);

        if(jaque)
            return true;
        else
            return false;

    }

    public static boolean validarJaqueAlMoverPieza()
    {

        Rey rey;
        int coordenadaX;
        int coordenadaY;

        int[] cordenadasPiezas;

        if(turnoBlanca)
        {

            cordenadasPiezas = piezasBlancas.get(0).obtenerCoordenadas();

            rey = (Rey) casillasTablero[cordenadasPiezas[0]][cordenadasPiezas[1]].obtenerPieza();
            coordenadaX = cordenadasPiezas[0];
            coordenadaY = cordenadasPiezas[1];

        }
        else
        {

            cordenadasPiezas = piezasNegras.get(0).obtenerCoordenadas();

            rey = (Rey) casillasTablero[cordenadasPiezas[0]][cordenadasPiezas[1]].obtenerPieza();
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

            coordenadasRey  = piezasBlancas.get(0).obtenerCoordenadas();
            rey             = piezasBlancas.get(0).obtenerPieza();

        }
        else
        {

            coordenadasRey  = piezasNegras.get(0).obtenerCoordenadas();
            rey             = piezasNegras.get(0).obtenerPieza();

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

        Pieza piezaPeligrosa = casillasTablero[coordenadaPiezaPeligrosa[0]][coordenadaPiezaPeligrosa[1]].obtenerPieza();

        asignarTurnoBlanca(!turnoBlanca);

        boolean jaque = piezaPeligrosa.validarMovimientosJaque(coordenadaPiezaPeligrosa[0], coordenadaPiezaPeligrosa[1]);

        asignarTurnoBlanca(!turnoBlanca);

        if(jaque)
            return false;
        else
            return true;

    }

    public boolean validarJaqueMateBloquear(int[] coordenadaPiezaPeligrosa)
    {

        Pieza piezaPeligrosa = casillasTablero[coordenadaPiezaPeligrosa[0]][coordenadaPiezaPeligrosa[1]].obtenerPieza();

        asignarTurnoBlanca(!turnoBlanca);

        ArrayList<String> movimientosPiezaPeligrosa = piezaPeligrosa.moverseAtacaRey(coordenadaPiezaPeligrosa[0], coordenadaPiezaPeligrosa[1]);

        if(movimientosPiezaPeligrosa.size() == 1)
            return true;

        ArrayList<Casilla> piezasValidar;

        if(piezaPeligrosa.obtenerColor() == 0)
            piezasValidar = piezasBlancas;
        else
            piezasValidar = piezasNegras;

        asignarTurnoBlanca(!turnoBlanca);

        for (Casilla piezasEnemigas: piezasValidar)
        {

            Pieza piezaEnemiga      = piezasEnemigas.obtenerPieza();

            if(piezaEnemiga instanceof Rey)
                continue;

            int[] coordenadaEnemiga = piezasEnemigas.obtenerCoordenadas();

            ArrayList<String> movimientosPiezaEnemiga = piezaEnemiga.moverse(coordenadaEnemiga[0], coordenadaEnemiga[1]);

            for (String movimientoEnemigo: movimientosPiezaEnemiga)
            {

                if(movimientosPiezaPeligrosa.contains(movimientoEnemigo))
                    return false;

            }

        }

        return true;

    }

    public boolean esTurnoBlanca()
    {

        return turnoBlanca;

    }

    public void asignarTurnoBlanca(boolean turnoBlanca)
    {

        this.turnoBlanca = turnoBlanca;

    }

    public static int[] obtenerNumeros()
    {

        return numeros;

    }

    public static String[] obtenerLetras()
    {

        return letras;

    }

}
