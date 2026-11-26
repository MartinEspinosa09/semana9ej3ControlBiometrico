public abstract class MetodoAutenticacion {
    private int nivelSeguridad;

    public MetodoAutenticacion(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public boolean superaUmbral(int umbral) {
        return nivelSeguridad > umbral;
    }

    public abstract String autenticar();

    public abstract String obtenerDetalle();
}