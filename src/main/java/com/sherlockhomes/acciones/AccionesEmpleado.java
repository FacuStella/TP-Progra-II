package com.sherlockhomes.acciones;

import com.sherlockhomes.model.Empleado;
import com.sherlockhomes.model.EmpleadoRepositoryFile;

public class AccionesEmpleado {
    
    EmpleadoRepositoryFile employeeRepository;
    
    public AccionesEmpleado(){
        employeeRepository = new EmpleadoRepositoryFile();
    }

    public void ejecutar(Empleado empleadoAux, int opc) {
        switch (opc) {
            case 1 -> employeeRepository.listarEmpleadoZonas(empleadoAux);
            case 2 -> employeeRepository.listarEmpleadoVehiculos(empleadoAux);
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }  
}
