package org.example.api;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;


public class ConsumidorAPI {
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private String apiKey;


    public ConsumidorAPI(String apiKey) {
        this.apiKey = apiKey;
    }


    public double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws IOException {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url(API_BASE_URL + apiKey + "/latest/" + monedaOrigen)
                .build();


        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error en la solicitud: " + response);
            }


            String jsonData = response.body().string();
            JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();

            // Verificar si la conversión fue exitosa
            if (jsonObject.has("conversion_rates")) {
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

                // Verificar si existe la moneda de destino
                if (conversionRates.has(monedaDestino)) {
                    return conversionRates.get(monedaDestino).getAsDouble();
                } else {
                    throw new IOException("Moneda de destino no encontrada: " + monedaDestino);
                }
            } else {
                throw new IOException("No se encontraron tasas de conversión");
            }
        }
    }
}