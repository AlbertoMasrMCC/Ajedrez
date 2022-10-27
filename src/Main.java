import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Tablero tablero = new Tablero();

        tablero.inicializarTablero();

        do
        {

            String jugador = "";
            int coordenadaX = 0;
            int coordenadaY = 0;

            if(tablero.isTurnoBlanca())
                jugador = "Jugador blancas";
            else
                jugador = "Jugador negras";

            while (true)
            {
                try
                {

                    System.out.print(jugador +" introduzca las coordenada X de la pieza que se desea mover: ");
                    coordenadaX = Integer.parseInt(entrada.nextLine());
                    if(coordenadaX<0 || coordenadaX>7){
                        System.out.println(jugador +" introduzca un valor de 0 a 7");
                        continue;
                    }
                    break;

                }
                catch (Exception e)
                {
                    System.out.println("Introduzca un valor entre 0 y 7");
                }
            }

            while (true)
            {

                try
                {

                    System.out.println(jugador +" introduzca la coordenada Y de la pieza que se desea mover: ");
                    coordenadaY = Integer.parseInt(entrada.nextLine());
                    if (coordenadaY<0 || coordenadaY>7){
                        System.out.println(jugador +" introduzca un valor de 0 a 7");
                        continue;
                    }
                    break;

                }
                catch (Exception e)
                {

                    System.out.println("Introduzca un valor entre 0 y 7");

                }

            }

            boolean a = tablero.validarJugada(coordenadaX, coordenadaY);

            if(a)
                System.out.println("Sí es pieza del jugador");
            else
                System.out.println("No es pieza del jugador");

        }while(tablero.validarJaqueMate());

    }
}