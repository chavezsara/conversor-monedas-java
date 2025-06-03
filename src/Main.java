import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("===== CONVERSOR DE MONEDAS =====");
            System.out.println("1. USD -> ARS (Peso argentino)");
            System.out.println("2. USD -> BRL (Real brasileño)");
            System.out.println("3. USD -> COP (Peso colombiano)");
            System.out.println("4. ARS -> USD");
            System.out.println("5. BRL -> USD");
            System.out.println("6. COP -> USD");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingresa el monto a convertir: ");
                double monto = scanner.nextDouble();

                String base = "", objetivo = "";

                switch (opcion) {
                    case 1 -> { base = "USD"; objetivo = "ARS"; }
                    case 2 -> { base = "USD"; objetivo = "BRL"; }
                    case 3 -> { base = "USD"; objetivo = "COP"; }
                    case 4 -> { base = "ARS"; objetivo = "USD"; }
                    case 5 -> { base = "BRL"; objetivo = "USD"; }
                    case 6 -> { base = "COP"; objetivo = "USD"; }
                }

                try {
                    double tasa = ApiService.obtenerTasa(base, objetivo);
                    double resultado = Conversor.convertir(monto, tasa);
                    System.out.printf("%.2f %s = %.2f %s\n\n", monto, base, resultado, objetivo);
                } catch (Exception e) {
                    System.out.println("❌ Error: " + e.getMessage());
                }
            } else if (opcion != 7) {
                System.out.println("⚠️ Opción inválida.");
            }

        } while (opcion != 7);

        System.out.println("👋 Gracias por usar el conversor.");
    }
}