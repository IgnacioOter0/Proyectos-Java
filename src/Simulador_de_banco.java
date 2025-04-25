package Proyectos;

import java.util.Scanner;

public class Simulador_de_banco {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Simulando una base de datos de usuarios
        String[] usuarios = new String[10];
        usuarios[0] = "Alvaro Garcia";
        usuarios[1] = "Jose Perez";
        usuarios[2] = "Paula Alvarez";
        usuarios[3] = "Lucas Gutierrez";
        usuarios[4] = "Adriana Herrera";
        usuarios[5] = "Micaela Diaz";
        usuarios[6] = "Pedro Lopez";
        usuarios[7] = "Felipe Gomez";
        usuarios[8] = "Victoria Gonzalez";
        usuarios[9] = "Sofia Sosa";

        // Simulando una base de datos de PINs
        int[] pins = new int[10];
        pins[0] = 8242;
        pins[1] = 3052;
        pins[2] = 4293;
        pins[3] = 7325;
        pins[4] = 1182;
        pins[5] = 9230;
        pins[6] = 6650;
        pins[7] = 4903;
        pins[8] = 1908;
        pins[9] = 2902;

        // Simulando una base de datos del saldo ($) de los usuarios
        int[] saldos = new int[10];
        saldos[0] = 957200;
        saldos[1] = 131980;
        saldos[2] = 3409220;
        saldos[3] = 1190370;
        saldos[4] = 562820;
        saldos[5] = 164090;
        saldos[6] = 745910;
        saldos[7] = 695690;
        saldos[8] = 1682450;
        saldos[9] = 2202970;

        ingresoUsuarios(sc, usuarios, pins, saldos);
    }

    public static void ingresoUsuarios(Scanner sc, String[] usuarios, int[] pins, int[] saldos) {

        System.out.println("Bienvenido al cajero automático del banco");
        System.out.print("Ingrese su usuario: ");
        String usuarioIngresado = sc.nextLine();
        System.out.print("Ingrese su PIN: ");
        int pinIngresado = sc.nextInt();
        sc.nextLine();

        int numeroUsuario = -1;

        for (int i = 0; i < 10; i++) {
            if (usuarios[i].equals(usuarioIngresado) && pins[i] == pinIngresado) {
                numeroUsuario = i;
            }
        }

        if (numeroUsuario == -1) {
            System.out.println("\nUsuario o PIN incorrecto, intente de nuevo\n");
            ingresoUsuarios(sc, usuarios, pins, saldos);
        } else if (numeroUsuario > -1) {
            System.out.println("\nBienvenido/a, " + usuarios[numeroUsuario]);

        }
        menuPrincipal(sc, usuarios, pins, saldos, numeroUsuario);
    }

    public static void menuPrincipal(Scanner sc, String[] usuarios, int[] pins, int[] saldos, int numeroUsuario) {

        System.out.println("1) Consultar saldo");
        System.out.println("2) Transferir dinero");
        System.out.println("3) Depositar dinero");
        System.out.println("4) Retirar dinero");
        System.out.println("5) Salir");

        int valorMenu = sc.nextInt();
        switch (valorMenu) {
            case 1:
                consultarSaldo(sc, usuarios, pins, saldos, numeroUsuario);
                break;

            case 2:
                transferirDinero(sc, usuarios, pins, saldos, numeroUsuario);
                break;

            case 3:
                depositarDinero(sc, usuarios, pins, saldos, numeroUsuario);
                break;

            case 4:
                retirarDinero(sc, usuarios, pins, saldos, numeroUsuario);
                break;

            case 5:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                menuPrincipal(sc, usuarios, pins, saldos, numeroUsuario);
        }
    }

    public static void consultarSaldo(Scanner sc, String[] usuarios, int[] pins, int[] saldos, int numeroUsuario) {

        System.out.println("Su saldo es de: $" + saldos[numeroUsuario]);

        reset(sc, usuarios, pins, saldos, numeroUsuario);
    }

    public static void transferirDinero(Scanner sc, String[] usuarios, int[] pins, int[] saldos, int numeroUsuario) {

        System.out.println("Ingrese el número de la cuenta a la cual desea transferir");
        int cuentaATransferir = sc.nextInt();

        if (cuentaATransferir <= -1 || cuentaATransferir >= 10) {
            System.out.println("La cuenta a la cual desea transferir no existe, intente nuevamente\n");
            transferirDinero(sc, usuarios, pins, saldos, numeroUsuario);
        } else if (cuentaATransferir == numeroUsuario) {
            System.out.println("No puede transferirse a sí mismo, intente nuevamente\n");
            transferirDinero(sc, usuarios, pins, saldos, numeroUsuario);
        } else {
            System.out.println("Ingrese el monto que desea transferir");
            int montoATransferir = sc.nextInt();
            if (montoATransferir > saldos[numeroUsuario]) {
                System.out.println("El monto que desea transferir es mayor a su saldo");
                reset(sc, usuarios, pins, saldos, numeroUsuario);
            } else if (montoATransferir <= 0) {
                System.out.println("No puedes transferir esa cantidad, intenta nuevamente\n");
                transferirDinero(sc, usuarios, pins, saldos, numeroUsuario);
            } else {
                saldos[numeroUsuario] -= montoATransferir;
                System.out.println("Su nuevo saldo es de: $" + saldos[numeroUsuario]);
                saldos[cuentaATransferir] += montoATransferir;
                System.out.println("El nuevo saldo de la cuenta de " + usuarios[cuentaATransferir] + " es de: $" + saldos[cuentaATransferir]);
            }
        }
        reset(sc, usuarios, pins, saldos, numeroUsuario);
    }

    public static void depositarDinero(Scanner sc, String[] usuarios, int[] pins, int[] saldos, int numeroUsuario) {
        System.out.println("Ingrese el monto a depositar\n(Límite de $250000 por transacción)");
        int montoAIngresar = sc.nextInt();
        if (montoAIngresar > 250000) {
            System.out.println("El monto ingresado supera el límite de la transacción");
            reset(sc, usuarios, pins, saldos, numeroUsuario);
        } else if (montoAIngresar <= 0) {
            System.out.println("No puedes ingresar esa cantidad, intenta nuevamente");
            depositarDinero(sc, usuarios, pins, saldos, numeroUsuario);
        } else {
            System.out.println("Ingresando el dinero a su cuenta...");
            saldos[numeroUsuario] += montoAIngresar;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println("Dinero ingresado con éxito, su nuevo saldo es de $" + saldos[numeroUsuario]);
        }
        reset(sc, usuarios, pins, saldos, numeroUsuario);
    }

    public static void retirarDinero(Scanner sc, String[] usuarios, int[] pins, int[] saldos, int numeroUsuario) {
        System.out.println("Ingrese el monto que desea retirar\n(Límite de $100000 por transacción)");
        int montoARetirar = sc.nextInt();
        if (montoARetirar > 100000) {
            System.out.println("El monto ingresado supera el límite de la transacción");
            reset(sc, usuarios, pins, saldos, numeroUsuario);
        } else if (montoARetirar <= 0) {
            System.out.println("No puedes retirar esa cantidad, intenta nuevamente");
            retirarDinero(sc, usuarios, pins, saldos, numeroUsuario);
        } else {
            System.out.println("Retirando dinero...");
            saldos[numeroUsuario] -= montoARetirar;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println("Dinero retirado con éxito, su nuevo saldo es de $" + saldos[numeroUsuario]);
        }
        reset(sc, usuarios, pins, saldos, numeroUsuario);
    }

    public static void reset(Scanner sc, String[] usuarios, int[] pins, int[] saldos, int numeroUsuario) {

        System.out.println("\n¿Desea realizar otra operación?\n1) Si\n2) No");

        int valorMenu0 = sc.nextInt();
        switch (valorMenu0) {
            case 1:
                menuPrincipal(sc, usuarios, pins, saldos, numeroUsuario);

            case 2:
                System.exit(0);

            default:
                System.out.println("Ingrese una opción válida");
                reset(sc, usuarios, pins, saldos, numeroUsuario);
        }
    }
}
