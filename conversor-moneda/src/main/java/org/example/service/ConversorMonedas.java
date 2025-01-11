package org.example.service;


import org.example.api.ConsumidorAPI;
import org.example.model.Moneda;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ConversorMonedas {
    private ConsumidorAPI consumidorAPI;
    private Map<String, Moneda> monedasDisponibles;


    public ConversorMonedas(String apiKey) {
        this.consumidorAPI = new ConsumidorAPI(apiKey);
        inicializarMonedasDisponibles();
    }


    private void inicializarMonedasDisponibles() {
        monedasDisponibles = new HashMap<>();
        monedasDisponibles.put("USD", new Moneda("USD", "Dólar Estadounidense", 1.0));
        monedasDisponibles.put("ARS", new Moneda("ARS", "Peso Argentino", 1.0));
        monedasDisponibles.put("BRL", new Moneda("BRL", "Real Brasileño", 1.0));
        monedasDisponibles.put("COP", new Moneda("COP", "Peso Colombiano", 1.0));
        monedasDisponibles.put("EUR", new Moneda("EUR", "Euro", 1.0));
    }


    public double convertirMoneda(String monedaOrigen, String monedaDestino, double monto) throws IOException {
        // Validar monedas
        if (!monedasDisponibles.containsKey(monedaOrigen) ||
                !monedasDisponibles.containsKey(monedaDestino)) {
            throw new IllegalArgumentException("Moneda no válida");
        }


        // Obtener tasa de cambio
        double tasaCambio = consumidorAPI.obtenerTasaCambio(monedaOrigen, monedaDestino);


        // Realizar conversión
        return monto * tasaCambio;
    }


    public Map<String, Moneda> getMonedasDisponibles() {
        return monedasDisponibles;
    }
}