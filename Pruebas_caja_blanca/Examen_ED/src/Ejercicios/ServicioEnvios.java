package Ejercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Servicio que calcula el coste de envío internacional según el país de destino,
 * el tipo de servicio y el peso del paquete.
 */
public class ServicioEnvios {

    private static final Logger log = Logger.getLogger(ServicioEnvios.class.getName());

    private static final double TARIFA_BASE = 20.0;
    private static final double RECARGO_EXPRES = 15.0;
    private static final double SUPLEMENTO_PESO = 10.0;
    private static final double LIMITE_PESO = 10.0;

    private static final Map<String, Double> TARIFAS_POR_PAIS = new HashMap<>();

    static {
        TARIFAS_POR_PAIS.put("Francia", 25.0);
        TARIFAS_POR_PAIS.put("Italia", 28.0);
        TARIFAS_POR_PAIS.put("EEUU", 35.0);
    }

    /**
     * Calcula el coste total del envío para el paquete proporcionado.
     *
     * @param paquete el paquete que se desea enviar.
     * @return coste total redondeado a 2 decimales.
     * @throws IllegalArgumentException si el paquete es null o tiene datos inválidos.
     */
    public static double calcularCosteEnvio(PaqueteEnviado paquete) {
        if (paquete == null) {
            throw new IllegalArgumentException("El paquete no puede ser null.");
        }

        if (paquete.getPesoKg() < 0) {
            throw new IllegalArgumentException("El peso del paquete no puede ser negativo.");
        }

        if (paquete.getTipoServicio() == null || paquete.getTipoServicio().isBlank()) {
            throw new IllegalArgumentException("El tipo de servicio no puede estar vacío.");
        }

        log.info("Calculando envío para: " + paquete);

        double base = TARIFAS_POR_PAIS.getOrDefault(paquete.getPaisDestino(), TARIFA_BASE);
        double total = base;

        if (paquete.getTipoServicio().equalsIgnoreCase("expres")) {
            total += RECARGO_EXPRES;
        }

        if (paquete.getPesoKg() > LIMITE_PESO) {
            total += SUPLEMENTO_PESO;
        }

        return redondearADosDecimales(total);
    }

    /**
     * Añade o actualiza la tarifa base de envío para un país.
     *
     * @param pais  el nombre del país.
     * @param tarifa la tarifa base (debe ser positiva).
     * @throws IllegalArgumentException si la tarifa es negativa o cero.
     */
    public static void agregarTarifaPais(String pais, double tarifa) {
        if (tarifa <= 0) {
            throw new IllegalArgumentException("La tarifa debe ser mayor que cero.");
        }
        TARIFAS_POR_PAIS.put(pais, tarifa);
        log.info("Tarifa actualizada para " + pais + ": " + tarifa);
    }

    private static double redondearADosDecimales(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
