import java.util.ArrayList;

public class Empleado {
    private String idEmpleado;
    private String nombre;
    private String departamento;
    private ArrayList<MetodoAutenticacion> metodosAutenticacion;

    public Empleado(String idEmpleado, String nombre, String departamento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.departamento = departamento;
        this.metodosAutenticacion = new ArrayList<>();
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public boolean agregarMetodo(MetodoAutenticacion metodo) {
        if (metodo == null) {
            return false;
        }
        metodosAutenticacion.add(metodo);
        return true;
    }

    public boolean tieneMetodoConNivelMayorA(int umbral) {
        for (MetodoAutenticacion metodo : metodosAutenticacion) {
            if (metodo != null && metodo.superaUmbral(umbral)) {
                return true;
            }
        }
        return false;
    }

    public String consultarUmbral(int umbral) {
        ArrayList<MetodoAutenticacion> coincidentes = new ArrayList<>();
        for (MetodoAutenticacion metodo : metodosAutenticacion) {
            if (metodo != null && metodo.superaUmbral(umbral)) {
                coincidentes.add(metodo);
            }
        }
        if (coincidentes.isEmpty()) {
            return String.format("%s (%s) NO tiene métodos con nivel de seguridad superior a %d.",
                    nombre, idEmpleado, umbral);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s) SÍ tiene métodos con nivel de seguridad superior a %d:\n",
                nombre, idEmpleado, umbral));
        for (int i = 0; i < coincidentes.size(); i++) {
            MetodoAutenticacion m = coincidentes.get(i);
            sb.append("  - ").append(m.obtenerDetalle()).append(" -> ").append(m.autenticar());
            if (i < coincidentes.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String listarMetodos() {
        if (metodosAutenticacion.isEmpty()) {
            return String.format("Empleado: %s [%s] (%s) - Sin métodos asignados.",
                    nombre, idEmpleado, departamento);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Empleado: %s [%s] | Área: %s\n", nombre, idEmpleado, departamento));
        for (int i = 0; i < metodosAutenticacion.size(); i++) {
            MetodoAutenticacion m = metodosAutenticacion.get(i);
            sb.append(i + 1).append(". ").append(m.obtenerDetalle());
            if (i < metodosAutenticacion.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}