package com.sherlockhomes.acciones;

import com.sherlockhomes.model.Socio;
import com.sherlockhomes.model.SocioRepositoryFile;

public class AccionesSocio {
    
    SocioRepositoryFile asocciatedRepository;
    
    public AccionesSocio(){
        asocciatedRepository = new SocioRepositoryFile();
    }

    public void ejecutar(Socio socioAux, int opc) {
        switch (opc) {
            case 1 -> asocciatedRepository.listarSocioVehiculos(socioAux);
            case 2 -> asocciatedRepository.listarSocioGarages(socioAux);
            case 0 -> {}
            default -> System.out.println("Opcion no reconocida");
        }
    }
    

    
}