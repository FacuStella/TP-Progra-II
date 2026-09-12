package controllers;

import views.socio.VistaSocio;
import sherlockhomes.EntradaCons;
import models.Socio;
import sherlockhomes.SocioRepositoryFile;

public class ControllerSocio implements Controller<Socio> {
    
    private SocioRepositoryFile asocciatedRepository;
    private VistaSocio vistaSocio;
    private int accion; 
    
    public ControllerSocio(){
        asocciatedRepository = new SocioRepositoryFile();
        vistaSocio = new VistaSocio();
    }
    
    @Override
    public void iniciar(Socio s){
            do{
                vistaSocio.menu();
                accion = EntradaCons.ingresaInt();
                ejecutar(s);
            } while(accion != 0);
    }

    @Override
    public void ejecutar(Socio socioAux) {
        switch (accion) {
            case 1 -> asocciatedRepository.listarSocioVehiculos(socioAux);
            case 2 -> asocciatedRepository.listarSocioGarages(socioAux);
            case 0 -> vistaSocio.salir();
            default -> vistaSocio.noReconocida();
        }
    }
    

    
}