import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ajedrez
{

    public static void main(String[] args)
    {

        Tablero tablero = new Tablero();

        tablero.inicializarTablero();

        tablero.mostrarTablero();

        do
        {

            String jugador = "";

            if(tablero.isTurnoBlanca())
                jugador = "Jugador blancas";
            else
                jugador = "Jugador negras";

            int[] coordenadasOrigen = pedirPiezaMover(jugador, false);

            if(!tablero.validarPiezaSeleccionada(coordenadasOrigen[0], coordenadasOrigen[1]))
            {

                System.out.println("Por favor seleccione las coordenadas de una de sus piezas");
                continue;

            }

            ArrayList<String> movimientosPermitidos = tablero.movimientosPosible(coordenadasOrigen[0], coordenadasOrigen[1]);

            if(movimientosPermitidos.size() == 0)
            {

                System.out.println("No hay movimientos permitidos, favor de seleccionar otra pieza.");
                continue;

            }

            String coordenadaPiezaSeleccionada = coordenadasOrigen[0] +""+ coordenadasOrigen[1];

            tablero.mostrarTablero(movimientosPermitidos, coordenadaPiezaSeleccionada);

            if(!deseaContinuar())
                continue;

            int[] coordenadasDestino = pedirPiezaMover(jugador, true);

            while (!movimientosPermitidos.contains(coordenadasDestino[0] +""+ coordenadasDestino[1]))
            {

                System.out.println("Seleccione una coordenada correcta.");
                coordenadasDestino = pedirPiezaMover(jugador, true);

            }

            tablero.jugada(coordenadasOrigen, coordenadasDestino);

            tablero.mostrarTablero();

            tablero.setTurnoBlanca(!tablero.isTurnoBlanca());

        }while(!tablero.validarJaqueMate());

    }

    private static int[] pedirPiezaMover(String jugador, boolean decision)
    {

        Scanner entrada = new Scanner(System.in);

        final int SIN_ASIGNAR_INDICE      = -1;

        int coordenadaX = SIN_ASIGNAR_INDICE;
        int coordenadaY = SIN_ASIGNAR_INDICE;
        String coordenada;

        while (true)
        {

            try
            {

                if(decision)
                    System.out.print(jugador +" introduzca las coordenada de la pieza que se desea mover: ");
                else
                    System.out.print(jugador +" introduzca la coordenada de destino de su pieza: ");

                coordenada = entrada.nextLine();

                if(coordenada.length() != 2)
                {

                    System.out.println("Introduzca una coordenada válida, (Letra y Numero)");
                    continue;

                }

                for (int i = 0; i < Tablero.getLetras().length; i++)
                {

                    String[] letras = Tablero.getLetras();

                    if(letras[i].equals(Character.toString(coordenada.charAt(0)).toUpperCase()))
                    {

                        coordenadaX = i;
                        break;

                    }

                }

                if(coordenadaX == SIN_ASIGNAR_INDICE)
                {

                    System.out.println("Introduzca un valor entre A y H");
                    continue;

                }

                for (int i = 0; i < Tablero.getNumeros().length; i++)
                {

                    int[] numeros = Tablero.getNumeros();

                    if(numeros[i] == Integer.parseInt(Character.toString(coordenada.charAt(1))))
                    {

                        coordenadaY = 8 - numeros[i];
                        break;

                    }

                }

                if(coordenadaY == SIN_ASIGNAR_INDICE)
                {

                    System.out.println("Introduzca un valor entre 1 y 8");
                    continue;

                }

                break;

            }
            catch (Exception e)
            {

                System.out.println("Introduzca una coordenada válida, (Letra y Numero)");

            }
        }



        int[] movimientos = {coordenadaY, coordenadaX};

        return movimientos;

    }

    private static boolean deseaContinuar()
    {

        while (true)
        {

            Scanner entrada = new Scanner(System.in);

            String continuar;

            System.out.print("¿Desea continuar? (SI/NO)");
            continuar = entrada.nextLine();

            if(!continuar.equalsIgnoreCase("SI") && !continuar.equalsIgnoreCase("NO"))
            {

                System.out.println("Introduzca SI o NO.");
                continue;

            }

            if(continuar.equalsIgnoreCase("SI"))
                return true;
            else
                return false;

        }

    }

}