package Proyectos;

import java.util.Scanner;
import java.util.Random;

public class PiedraPapelTijera {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int puntosUsuario = 0;
        int puntosIA = 0;

        System.out.println("Este es un juego de piedra, papel o tijera.");
        System.out.println("La idea es que elijas una opción y compitas con una IA.");
        System.out.println("Quien llegue primero a 5 puntos gana.");

        partida(sc, rd, puntosUsuario, puntosIA);
    }

    // 1-Piedra    2-Papel    3-Tijera
    public static void partida(Scanner sc, Random rd, int puntosUsuario, int puntosIA) {
        while (puntosUsuario != 5 && puntosIA != 5) {
            int eleccionIA = rd.nextInt(3) + 1;

            String eleccionIA2 = "";

            switch (eleccionIA) {
                case 1:
                    eleccionIA2 = "Piedra";
                    break;

                case 2:
                    eleccionIA2 = "Papel";
                    break;

                case 3:
                    eleccionIA2 = "Tijera";
                    break;
            }

            System.out.println("\n¿Que elegís? ¿Piedra, papel o tijera?");
            System.out.println("1) Piedra\n2) Papel\n3) Tijera");
            int eleccionUsuario = sc.nextInt();

            if (eleccionUsuario < 1 || eleccionUsuario > 3) {
                System.out.println("Elija una opción válida");
                continue;
            }

            if (((eleccionUsuario == 1 && eleccionIA == 3) || (eleccionUsuario == 2 && eleccionIA == 1) || (eleccionUsuario == 3 && eleccionIA == 2))) {
                System.out.println("La IA eligió " + eleccionIA2 + "\n¡Ganaste esta ronda!");
                puntosUsuario++;
            }

            if (((eleccionUsuario == 3 && eleccionIA == 1) || (eleccionUsuario == 1 && eleccionIA == 2) || (eleccionUsuario == 2 && eleccionIA == 3))) {
                System.out.println("La IA eligió " + eleccionIA2 + "\nPerdiste esta ronda...");
                puntosIA++;
            }

            if (eleccionUsuario == eleccionIA) {
                System.out.println("La IA eligió " + eleccionIA2 + "\nEmpate");
            }

            System.out.println("\nPuntaje Usuario: " + puntosUsuario + "\nPuntaje IA: " + puntosIA);

        }

        if (puntosUsuario == 5) {
            System.out.println("\nGanaste la partida");
        }

        if (puntosIA == 5) {
            System.out.println("\nPerdiste la partida");
        }
    }
}
