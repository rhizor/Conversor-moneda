package org.example;


import org.example.service.ConversorMonedas;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // IMPORTANTE: Reemplaza 'TU_API_KEY' con tu clave real de ExchangeRate-API
        ConversorMonedas conversor = new ConversorMonedas("TU_API_KEY");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            mostrarMenu();

            try {
                int opcion = scanner.nextInt();

                if (opcion == 0) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                procesarConversion(conversor, opcion, scanner);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar buffer
            }
        }

        scanner.close();
    }


    private static void mostrarMenu() {
        System.out.println("\n=== Conversor de Monedas ===");
        System.out.println("1. Dólar a Peso Argentino");
        System.out.println("2. Peso Argentino a Dólar");
        System.out.println("3. Dólar a Real Brasileño");
        System.out.println("4. Real Brasileño a Dólar");
        System.out.println("5. Dólar a Peso Colombiano");
        System.out.println("6. Peso Colombiano a Dólar");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }


    private static void procesarConversion(ConversorMonedas conversor, int opcion, Scanner scanner) {
        String monedaOrigen, monedaDestino;

        switch (opcion) {
            case 1:
                monedaOrigen = "USD";
                monedaDestino = "ARS";
                break;
            case 2:
                monedaOrigen = "ARS";
                monedaDestino = "USD";
                break;
            case 3:
                monedaOrigen = "USD";
                monedaDestino = "BRL";
                break;
            case 4:
                monedaOrigen = "BRL";
                monedaDestino = "USD";
                break;
            case 5:
                monedaOrigen = "USD";
                monedaDestino = "COP";
                break;
            case 6:
                monedaOrigen = "COP";
                monedaDestino = "USD";
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }


        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();


        try {
            double resultado = conversor.convertirMoneda(monedaOrigen, monedaDestino, monto);
            System.out.printf("%.2f %s = %.2f %s%n",
                    monto, monedaOrigen, resultado, monedaDestino);
        } catch (Exception e) {
            System.out.println("Error en la conversión: " + e.getMessage());
        }
    }
}