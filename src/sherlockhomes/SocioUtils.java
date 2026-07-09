package sherlockhomes;

import java.util.ArrayList;

public class SocioUtils {
    public static Socio buscarSocioPorDni(ArrayList<Socio> socios, int dni) {
        for (Socio s : socios) {
            if (s.getDNI() == dni) {
                return s;
            }
        }
        return null;
    }
}
