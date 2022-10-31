import java.util.ArrayList;

public class Caballo extends Pieza
{

    public Caballo(int lado, boolean vivo)
    {

        this.lado           = lado;
        this.vivo           = vivo;

    }
    @Override
    public ArrayList<String> moverse(int coordenadaX, int coordenadaY)
    {

        int movimientoPosible;

        int[] movimientos = getMovimientos();

        ArrayList<String> movimientosPermitidos = new ArrayList<String>();

        // MOVIMIENTO HACIA ADELANTE
        movimientoPosible = coordenadaX - movimientos[0];

        if(movimientoPosible >= 0)
        {

            if(coordenadaY - 1 >= 0)
            {

                if (!Tablero.validarPiezaSeleccionada(movimientoPosible, coordenadaY - 1))
                    movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));

            }

            if(coordenadaY + 1 <= 7)
            {

                if (!Tablero.validarPiezaSeleccionada(movimientoPosible, coordenadaY + 1))
                    movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

            }

        }

        // MOVIMIENTO HACIA LA DERECHA
        movimientoPosible = coordenadaY + movimientos[0];

        if(movimientoPosible <= 7)
        {

            if(coordenadaX - 1 >= 0)
            {

                if (!Tablero.validarPiezaSeleccionada(coordenadaX - 1, movimientoPosible))
                    movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

            }

            if(coordenadaX + 1 <= 7)
            {

                if (!Tablero.validarPiezaSeleccionada(coordenadaX + 1, movimientoPosible))
                    movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);

            }

        }

        // MOVIMIENTO HACIA ABAJO
        movimientoPosible = coordenadaX + movimientos[0];

        if(movimientoPosible <= 7)
        {

            if(coordenadaY - 1 >= 0)
            {

                if (!Tablero.validarPiezaSeleccionada(movimientoPosible, coordenadaY - 1))
                    movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY - 1));
            }

            if(coordenadaY + 1 <= 7)
            {

                if (!Tablero.validarPiezaSeleccionada(movimientoPosible, coordenadaY + 1))
                    movimientosPermitidos.add(movimientoPosible +""+ (coordenadaY + 1));

            }

        }

        // MOVIMIENTO HACIA LA IZQUIERDA
        movimientoPosible = coordenadaY - movimientos[0];

        if(movimientoPosible >= 0)
        {

            if(coordenadaX - 1 >= 0)
            {

                if (!Tablero.validarPiezaSeleccionada(coordenadaX - 1, movimientoPosible))
                    movimientosPermitidos.add((coordenadaX - 1) +""+ movimientoPosible);

            }

            if(coordenadaX + 1 <= 7)
            {
                if (!Tablero.validarPiezaSeleccionada(coordenadaX + 1, movimientoPosible))
                    movimientosPermitidos.add((coordenadaX + 1) +""+ movimientoPosible);
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

            System.out.print("\u001b[48;5;177m"+"\u001b[38;5;127m"+" ♞ "+"\u001B[0m" );
            return;

        }

        if(blancas)
        {

            if(lado == NEGRAS)
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;232m"+" ♞ "+"\u001B[0m" );
            else
                System.out.print("\u001b[48;5;250m"+"\u001b[38;5;255m"+" ♞ "+"\u001B[0m");

        }
        else
        {

            if (lado == NEGRAS)
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;232m" + " ♞ "+"\u001B[0m");
            else
                System.out.print("\u001b[48;5;8m" + "\u001b[38;5;255m" + " ♞ "+"\u001B[0m");

        }

    }

    @Override
    public int[] getMovimientos()
    {

        int[] movimientos = {2, 2, 2, 2, 0};
        return movimientos;

    }

}
