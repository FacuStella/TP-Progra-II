package sherlockhomes;

public class AccionesEmpleado {

    void ejecutar(Empleado empleadoAux, int opc) {
        switch (opc) {
            case 1 -> {
                System.out.println("Se consultan zonas asignadas del empleado.");
                empleadoAux.getZonasAsignadas();
            }
            case 2 -> {
                System.out.println("Se consultan vehiculos encargados del empleado.");
                empleadoAux.getZonasAsignadas();
            }
            case 0 -> {
                System.out.println("Gracias vuelva prontos.");
            }
            default ->{
                System.out.println("Opcion no reconocida.");
            }
        }
    }
}
