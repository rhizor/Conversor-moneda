package org.example;


import org.example.service.ConversorMonedas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;


public class ConversorMonedasTest {
    private ConversorMonedas conversor;


    @BeforeEach
    public void setUp() {
        // IMPORTANTE: Reemplaza con tu API key real
        conversor = new ConversorMonedas("TU_API_KEY);
    }


    @Test
    public void testConversionDolarAPesoArgentino() throws IOException {
        double monto = 100.0;
        double resultado = conversor.convertirMoneda("USD", "ARS", monto);

        assertTrue(resultado > 0, "La conversión debe dar un resultado positivo");
    }


    @Test
    public void testConversionPesoArgentinoADolar() throws IOException {
        double monto = 1000.0;
        double resultado = conversor.convertirMoneda("ARS", "USD", monto);

        assertTrue(resultado > 0, "La conversión debe dar un resultado positivo");
    }


    @Test
    public void testMonedaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            conversor.convertirMoneda("XYZ", "USD", 100.0);
        });
    }


    @Test
    public void testMonedaOrigenIgualDestino() throws IOException {
        double monto = 100.0;
        double resultado = conversor.convertirMoneda("USD", "USD", monto);

        assertEquals(monto, resultado, 0.001, "La conversión a la misma moneda debe ser igual");
    }
}
