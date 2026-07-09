package acciones;

import sherlockhomes.Socio;

public class AccionesSocio {

    public void ejecutar(Socio socioAux, int opc) {
        switch (opc) {
            case 1 -> {
                System.out.println("Buscando vehiculos.");
                socioAux.getVehiculos();
            }
            case 2 -> {
                System.out.println("Buscando garages.");
                socioAux.getGarages();
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