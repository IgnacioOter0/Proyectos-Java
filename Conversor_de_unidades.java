package Proyectos;

import java.util.Scanner;

public class Conversor_de_unidades {

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

        int valorMenu1;
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
                menuPrincipal(sc);

        }
    }

    public static void convertirTemperatura(Scanner sc) {

        System.out.println("Elija la unidad para convertir");
        System.out.println("1) Celsius");
        System.out.println("2) Fahrenheit");
        System.out.println("3) Kelvin");
        System.out.println("4) Atrás");
        System.out.println("5) Salir del programa");

        int valorMenu2;
        int unidadDestino = 0;
        valorMenu2 = sc.nextInt();
        int unidadOrigen = valorMenu2;

        convertirTemperatura2(sc, valorMenu2, unidadDestino, unidadOrigen);
    }

    public static void convertirTemperatura2(Scanner sc, int valorMenu2, int unidadDestino, int unidadOrigen) {

        switch (valorMenu2) {
            case 1:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Fahrenheit");
                System.out.println("2) Kelvin");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirTemperatura3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 2:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Celsius");
                System.out.println("2) Kelvin");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirTemperatura3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 3:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Celsius");
                System.out.println("2) Fahrenheit");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirTemperatura3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 4:
                menuPrincipal(sc);
                break;

            case 5:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                convertirTemperatura(sc);
                break;
        }
    }

    public static void convertirTemperatura3(Scanner sc, int valorMenu2, int unidadOrigen, int unidadDestino) {

        double cantidadConvertir;
        switch (unidadDestino) {
            case 1:
                System.out.println("Escriba la cantidad que desea convertir");
                cantidadConvertir = sc.nextDouble();
                convertirTemperatura4(sc, cantidadConvertir, unidadOrigen, unidadDestino);
                break;

            case 2:
                System.out.println("Escriba la cantidad que desea convertir");
                cantidadConvertir = sc.nextDouble();
                convertirTemperatura4(sc, cantidadConvertir, unidadOrigen, unidadDestino);
                break;

            case 3:
                convertirTemperatura(sc);
                break;

            case 4:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                convertirTemperatura2(sc, valorMenu2, unidadDestino, unidadOrigen);
                break;

        }
    }

    public static void convertirTemperatura4(Scanner sc, double cantidadConvertir, int unidadOrigen, int unidadDestino) {

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
                System.out.println("Ingrese una opción válida");
                return;
        }

        if (resultadoFinal % 1 == 0) {
            System.out.printf("El resultado es: %.0f\n", resultadoFinal);
        } else {
            System.out.printf("El resultado es: %.4f\n", resultadoFinal);
        }
        reset(sc);
    }

    public static void convertirDistancia(Scanner sc) {

        System.out.println("Elija la unidad para convertir");
        System.out.println("1) Kilómetros");
        System.out.println("2) Millas");
        System.out.println("3) Pies");
        System.out.println("4) Atrás");
        System.out.println("5) Salir del programa");

        int valorMenu2;
        int unidadDestino = 0;
        valorMenu2 = sc.nextInt();
        int unidadOrigen = valorMenu2;

        convertirDistancia2(sc, valorMenu2, unidadDestino, unidadOrigen);
    }

    public static void convertirDistancia2(Scanner sc, int valorMenu2, int unidadDestino, int unidadOrigen) {

        switch (valorMenu2) {
            case 1:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Millas");
                System.out.println("2) Pies");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirDistancia3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 2:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Kilómetros");
                System.out.println("2) Pies");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirDistancia3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 3:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Kilómetros");
                System.out.println("2) Millas");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirDistancia3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 4:
                menuPrincipal(sc);
                break;

            case 5:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                convertirDistancia(sc);
                break;
        }
    }

    public static void convertirDistancia3(Scanner sc, int valorMenu2, int unidadOrigen, int unidadDestino) {

        double cantidadConvertir;
        switch (unidadDestino) {
            case 1:
                System.out.println("Escriba la cantidad que desea convertir");
                cantidadConvertir = sc.nextDouble();
                convertirDistancia4(sc, cantidadConvertir, unidadOrigen, unidadDestino);
                break;

            case 2:
                System.out.println("Escriba la cantidad que desea convertir");
                cantidadConvertir = sc.nextDouble();
                convertirDistancia4(sc, cantidadConvertir, unidadOrigen, unidadDestino);
                break;

            case 3:
                convertirDistancia(sc);
                break;

            case 4:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                convertirDistancia2(sc, valorMenu2, unidadDestino, unidadOrigen);
                break;

        }
    }

    public static void convertirDistancia4(Scanner sc, double cantidadConvertir, int unidadOrigen, int unidadDestino) {

        double resultadoFinal = 0;
        switch (unidadOrigen) {
            case 1: // Kilómetros
                if (unidadDestino == 1) {
                    resultadoFinal = cantidadConvertir * 0.6213711922; // Millas
                } else if (unidadDestino == 2) {
                    resultadoFinal = cantidadConvertir * 3280.839895; // Pies
                }
                break;

            case 2: // Millas
                if (unidadDestino == 1) {
                    resultadoFinal = cantidadConvertir * 1.609344; // Kilómetros
                } else if (unidadDestino == 2) {
                    resultadoFinal = cantidadConvertir * 5280; // Pies
                }
                break;

            case 3: // Pies
                if (unidadDestino == 1) {
                    resultadoFinal = cantidadConvertir / 3280.839895; // Kilómetros
                } else if (unidadDestino == 2) {
                    resultadoFinal = cantidadConvertir / 5280; // Millas
                }
                break;
        }

        if (resultadoFinal % 1 == 0) {
            System.out.printf("El resultado es: %.0f\n", resultadoFinal);
        } else {
            System.out.printf("El resultado es: %.4f\n", resultadoFinal);
        }
        reset(sc);
    }

    public static void convertirPeso(Scanner sc) {

        System.out.println("Elija la unidad para convertir");
        System.out.println("1) Kilogramos");
        System.out.println("2) Libras");
        System.out.println("3) Onzas");
        System.out.println("4) Atrás");
        System.out.println("5) Salir del programa");

        int valorMenu2;
        int unidadDestino = 0;
        valorMenu2 = sc.nextInt();
        int unidadOrigen = valorMenu2;

        convertirPeso2(sc, valorMenu2, unidadDestino, unidadOrigen);
    }

    public static void convertirPeso2(Scanner sc, int valorMenu2, int unidadDestino, int unidadOrigen) {

        switch (valorMenu2) {
            case 1:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Libras");
                System.out.println("2) Onzas");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirPeso3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 2:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Kilogramos");
                System.out.println("2) Onzas");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirPeso3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 3:
                System.out.println("Elija la unidad a la cual convertir");
                System.out.println("1) Kilogramos");
                System.out.println("2) Libras");
                System.out.println("3) Atrás");
                System.out.println("4) Salir del programa");
                unidadDestino = sc.nextInt();
                convertirPeso3(sc, valorMenu2, unidadOrigen, unidadDestino);
                break;

            case 4:
                menuPrincipal(sc);
                break;

            case 5:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                convertirPeso(sc);
                break;
        }
    }

    public static void convertirPeso3(Scanner sc, int valorMenu2, int unidadOrigen, int unidadDestino) {

        double cantidadConvertir;
        switch (unidadDestino) {
            case 1:
                System.out.println("Escriba la cantidad que desea convertir");
                cantidadConvertir = sc.nextDouble();
                convertirPeso4(sc, cantidadConvertir, unidadOrigen, unidadDestino);
                break;

            case 2:
                System.out.println("Escriba la cantidad que desea convertir");
                cantidadConvertir = sc.nextDouble();
                convertirPeso4(sc, cantidadConvertir, unidadOrigen, unidadDestino);
                break;

            case 3:
                convertirPeso(sc);
                break;

            case 4:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                convertirPeso2(sc, valorMenu2, unidadDestino, unidadOrigen);
                break;

        }
    }

    public static void convertirPeso4(Scanner sc, double cantidadConvertir, int unidadOrigen, int unidadDestino) {

        double resultadoFinal = 0;
        switch (unidadOrigen) {
            case 1: // Kilogramos
                if (unidadDestino == 1) {
                    resultadoFinal = cantidadConvertir * 2.2046226218; // Libras
                } else if (unidadDestino == 2) {
                    resultadoFinal = cantidadConvertir * 35.27396195; // Onzas
                }
                break;

            case 2: // Libras
                if (unidadDestino == 1) {
                    resultadoFinal = cantidadConvertir * 0.45359237; // Kilogramos
                } else if (unidadDestino == 2) {
                    resultadoFinal = cantidadConvertir * 16; // Onzas
                }
                break;

            case 3: // Onzas
                if (unidadDestino == 1) {
                    resultadoFinal = cantidadConvertir * 0.0283495231; // Kilogramos
                } else if (unidadDestino == 2) {
                    resultadoFinal = cantidadConvertir / 16; // Libras
                }
                break;
        }

        if (resultadoFinal % 1 == 0) {
            System.out.printf("El resultado es: %.0f\n", resultadoFinal);
        } else {
            System.out.printf("El resultado es: %.4f\n", resultadoFinal);
        }
        reset(sc);
    }

    public static void reset(Scanner sc) {

        System.out.println("¿Querés realizar otra conversión?");
        System.out.println("1) Si");
        System.out.println("2) No");

        int valorMenu0 = sc.nextInt();

        switch (valorMenu0) {
            case 1:
                menuPrincipal(sc);

            case 2:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                reset(sc);

        }
    }
}
