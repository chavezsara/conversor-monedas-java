import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiService {
    private static final String API_KEY = "e89f32c52ab7261cf170eea9";

    public static double obtenerTasa(String base, String objetivo) throws Exception {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + objetivo;

        HttpURLConnection conexion = (HttpURLConnection) new URL(urlStr).openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder json = new StringBuilder();
        String linea;
        while ((linea = reader.readLine()) != null) json.append(linea);
        reader.close();

        JSONObject data = new JSONObject(json.toString());
        return data.getDouble("conversion_rate");
    }
}
