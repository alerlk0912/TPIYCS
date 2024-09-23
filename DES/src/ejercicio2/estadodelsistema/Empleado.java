package ejercicio2.estadodelsistema;

public class Empleado {
    Boolean estaOcupado; /* false = libre / true = ocupado */
    Solicitud solicitudEnProcesamiento; /* Solicitud que está siendo retenida en el servidor. */

    public Empleado(boolean estado) {
        super();
        estaOcupado = estado;
        solicitudEnProcesamiento = null;
    }

    public boolean getEstaOcupado() {
        return estaOcupado;
    }

    public void pasarAOcupado(Solicitud solicitud) {
        estaOcupado = true;
        solicitudEnProcesamiento = solicitud;
    }

    public void setEstaOcupado(boolean estado) {
        estaOcupado = estado;
    }

}
