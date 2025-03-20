package Proyectos;

import java.util.Scanner;

public class Conversor_de_unidades {

    /*
    Crear un programa que convierta entre diferentes unidades:
    Temperatura (Celsius, Fahrenheit, Kelvin).
    Distancia (metros, kilómetros, millas).
    Peso (kilogramos, libras).
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        menuPrincipal(sc);
    }

    public static void menuPrincipal(Scanner sc) {

        System.out.println("Elija el tipo de conversión:");
        System.out.println("1) Temperatura");
        System.out.println("2) Distancia");
        System.out.println("3) Peso");
        System.out.println("4) Salir del programa");

        int valorMenu1 = 0;
        while (valorMenu1 != 4) {
            valorMenu1 = sc.nextInt();
            switch (valorMenu1) {

                case 1:
                    convertirTemperatura(sc);
                    break;

                case 2:
                    convertirDistancia(sc);
                    break;

                case 3:
                    convertirPeso(sc);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Ingrese una opción válida");

            }

        }

    }

    public static void convertirTemperatura(Scanner sc) {

        System.out.println("Elija la unidad para convertir");
        System.out.println("1) Celsius");
        System.out.println("2) Fahrenheit");
        System.out.println("3) Kelvin");
        System.out.println("4) Atrás");
        System.out.println("5) Salir del programa");

        int valorMenu2 = 0;
        int unidadDestino;
        valorMenu2 = sc.nextInt();
        int unidadOrigen = valorMenu2;
        switch (valorMenu2) {
            case 1:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Fahrenheit");
                System.out.println("2) Kelvin");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirTemperatura2(sc, unidadOrigen, unidadDestino);
                break;

            case 2:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Celsius");
                System.out.println("2) Kelvin");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirTemperatura2(sc, unidadOrigen, unidadDestino);
                break;

            case 3:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Celsius");
                System.out.println("2) Fahrenheit");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirTemperatura2(sc, unidadOrigen, unidadDestino);
                break;

            case 4:
                System.out.println("Elija el tipo de conversión:");
                System.out.println("1) Temperatura");
                System.out.println("2) Distancia");
                System.out.println("3) Peso");
                System.out.println("4) Salir del programa");
                return;

            case 5:
                System.exit(0);
                break;

            default:
                System.out.println("Ingrese una opción válida");
                return;
        }
    }

    public static void convertirTemperatura2(Scanner sc, int unidadOrigen, int unidadDestino) {

        double cantidadConvertir = 0;

        System.out.println("Escriba la cantidad que desea convertir");
        cantidadConvertir = sc.nextDouble();
        convertirTemperatura3(sc, cantidadConvertir, unidadOrigen, unidadDestino);
    }

    public static void convertirTemperatura3(Scanner sc, double cantidadConvertir, int unidadOrigen, int unidadDestino) {

        double resultadoFinal = 0;
        switch (unidadOrigen) {
            case 1: // Celsius
                if (unidadDestino == 1) {
                    resultadoFinal = (cantidadConvertir * 9) / 5 + 32; // Fahrenheit
                } else if (unidadDestino == 2) {
                    resultadoFinal = cantidadConvertir + 273.15; // Kelvin
                }
                break;

            case 2: // Fahrenheit
                if (unidadDestino == 1) {
                    resultadoFinal = (cantidadConvertir - 32) / 1.8; // Celsius
                } else if (unidadDestino == 2) {
                    resultadoFinal = ((cantidadConvertir - 32) * 5) / 9 + 273.15; // Kelvin
                }
                break;

            case 3: // Kelvin
                if (unidadDestino == 1) {
                    resultadoFinal = cantidadConvertir - 273.15; // Celsius
                } else if (unidadDestino == 2) {
                    resultadoFinal = (cantidadConvertir - 273.15) * 9 / 5 + 32; // Fahrenheit
                }
                break;

            default:
                System.out.println("ingrese una opción válida");
                return;
        }

        System.out.println("El resultado es: " + resultadoFinal);
    }

    public static void convertirDistancia(Scanner sc) {
        System.out.println("Elija la unidad para convertir");
        System.out.println("1) Metros");
        System.out.println("2) Kilómetros");
        System.out.println("3) Millas");
        System.out.println("4) Atrás");
        System.out.println("5) Salir del programa");
    }

    public static void convertirPeso(Scanner sc) {
        System.out.println("Elija la unidad para convertir");
        System.out.println("1) Kilogramos");
        System.out.println("2) Libras");
        System.out.println("3) Atrás");
        System.out.println("4) Salir del programa");
    }
}
