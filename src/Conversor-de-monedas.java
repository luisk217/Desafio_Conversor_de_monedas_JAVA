
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*************************************************");
            System.out.println("  Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("*************************************************");
            System.out.println("1) Dólar => Euro");
            System.out.println("2) Euro => Dólar");
            System.out.println("3) Dólar => Libra esterlina");
            System.out.println("4) Libra esterlina => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("*************************************************");
            System.out.print("Elija una opción válida: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirMoneda("USD", "EUR", scanner);
                    break;
                case 2:
                    convertirMoneda("EUR", "USD", scanner);
                    break;
                case 3:
                    convertirMoneda("USD", "GBP", scanner);
                    break;
                case 4:
                    convertirMoneda("GBP", "USD", scanner);
                    break;
                case 5:
                    convertirMoneda("USD", "COP", scanner);
                    break;
                case 6:
                    convertirMoneda("COP", "USD", scanner);
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 7);

        scanner.close();
    }

    private static void convertirMoneda(String from, String to, Scanner scanner) {
        System.out.print("Ingrese la cantidad en " + from + ": ");
        double cantidad = scanner.nextDouble();

        double tasaCambio = obtenerTasaCambio(from, to);
        if (tasaCambio != -1) {
            double resultado = cantidad * tasaCambio;
            System.out.println(cantidad + " " + from + " equivalen a " + resultado + " " + to + ".");
        } else {
            System.out.println("No se pudo obtener la tasa de cambio. Inténtelo más tarde.");
        }
    }

    private static double obtenerTasaCambio(String from, String to) {
    // Setting URL
        String url_api = "https://v6.exchangerate-api.com/v6/aacc2d79821b1292b9a64d6f/latest/USD" + from + "&symbols=" + to;

        try {
            // Realizar la conexión HTTP
            URL url = new URL(url_api);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // Parsear el JSON de la respuesta
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.has("rates") && jsonResponse.getJSONObject("rates").has(to)) {
                return jsonResponse.getJSONObject("rates").getDouble(to);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }

        return -1; // Retorna -1 si ocurre algún error
    }
}
