public class ReconocimientoFacial extends MetodoAutenticacion {
    private String camaraId;
    private boolean deteccionVidaActiva;

    public ReconocimientoFacial(int nivelSeguridad, String camaraId, boolean deteccionVidaActiva) {
        super(nivelSeguridad);
        this.camaraId = camaraId;
        this.deteccionVidaActiva = deteccionVidaActiva;
    }

    public String getCamaraId() {
        return camaraId;
    }

    public boolean isDeteccionVidaActiva() {
        return deteccionVidaActiva;
    }

    @Override
    public String autenticar() {
        String liveness = deteccionVidaActiva ? "con detección de vida activa" : "sin detección de vida";
        return String.format("Rostro verificado en cámara %s (%s)", camaraId, liveness);
    }

    @Override
    public String obtenerDetalle() {
        String liveness = deteccionVidaActiva ? "Activa" : "Inactiva";
        return String.format("Reconocimiento Facial | Cámara: %s | Liveness: %s | Nivel de seguridad: %d",
                camaraId, liveness, getNivelSeguridad());
    }
}