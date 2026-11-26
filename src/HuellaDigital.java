public class HuellaDigital extends MetodoAutenticacion {
    private String sensorId;
    private double precisionPorcentaje;

    public HuellaDigital(int nivelSeguridad, String sensorId, double precisionPorcentaje) {
        super(nivelSeguridad);
        this.sensorId = sensorId;
        this.precisionPorcentaje = precisionPorcentaje;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getPrecisionPorcentaje() {
        return precisionPorcentaje;
    }

    @Override
    public String autenticar() {
        return String.format("Huella validada en sensor %s (precisión %.1f%%)", sensorId, precisionPorcentaje);
    }

    @Override
    public String obtenerDetalle() {
        return String.format("Huella Digital | Sensor: %s | Precisión: %.1f%% | Nivel de seguridad: %d",
                sensorId, precisionPorcentaje, getNivelSeguridad());
    }
}