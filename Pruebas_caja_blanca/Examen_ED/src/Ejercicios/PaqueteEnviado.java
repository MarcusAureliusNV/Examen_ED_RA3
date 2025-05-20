package Ejercicios;

public class PaqueteEnviado {
    private String paisDestino;
    private double pesoKg;
    private String tipoServicio; // "estandar" o "expres"

    public PaqueteEnviado(String paisDestino, double pesoKg, String tipoServicio) {
        this.paisDestino = paisDestino;
        this.pesoKg = pesoKg;
        this.tipoServicio = tipoServicio;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    @Override
    public String toString() {
        return "PaqueteEnviado{" +
                "paisDestino='" + paisDestino + '\'' +
                ", pesoKg=" + pesoKg +
                ", tipoServicio='" + tipoServicio + '\'' +
                '}';
    }
}
