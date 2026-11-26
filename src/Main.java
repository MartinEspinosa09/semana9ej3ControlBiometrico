import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MetodoAutenticacion huella1 = new HuellaDigital(7, "BIO-H01", 99.4);
        MetodoAutenticacion rostro1 = new ReconocimientoFacial(9, "CAM-02", true);


        MetodoAutenticacion huella2 = new HuellaDigital(5, "BIO-H03", 98.1);


        Empleado emp1 = new Empleado("EMP-101", "Sofía Paredes", "Seguridad TI");
        emp1.agregarMetodo(huella1);
        emp1.agregarMetodo(rostro1);


        Empleado emp2 = new Empleado("EMP-102", "Mateo Cevallos", "Operaciones");
        emp2.agregarMetodo(huella2);


        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(emp1);
        empleados.add(emp2);

        System.out.println("=== METODOS DE AUTENTICACION POR EMPLEADO ===");
        for (Empleado emp : empleados) {
            System.out.println(emp.listarMetodos());
            System.out.println();
        }

        int umbralIngresado = 7;
        System.out.println("=== CONSULTA DE UMBRAL (NIVEL > " + umbralIngresado + ") ===");
        for (Empleado emp : empleados) {
            System.out.println(emp.consultarUmbral(umbralIngresado));
        }
    }
}