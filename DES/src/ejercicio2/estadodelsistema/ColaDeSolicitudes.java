package ejercicio2.estadodelsistema;

import java.util.LinkedList;
import java.util.Queue;

public class ColaDeSolicitudes {

    private Queue<Solicitud> cola1;

    public ColaDeSolicitudes() {
        super();
        cola1 = new LinkedList<Solicitud>();
    }

    public void encolarSolicitud(Solicitud solicitudParaAgregar) {
        cola1.add(solicitudParaAgregar);
    }

    public int getCantSolicitudesEsperando() {
        return cola1.size();
    }

    public Solicitud solicitudPrioritaria() {
        Solicitud ret;
        ret = cola1.remove();
        return ret;
    }

}
