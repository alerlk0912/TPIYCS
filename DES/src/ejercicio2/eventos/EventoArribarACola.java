package ejercicio2.eventos;

import des.*;
import ejercicio2.componentesPropios.ContadorEstadisticosEjercicio2;
import ejercicio2.componentesPropios.LibreriaDeRutinasEjercicio2;
import ejercicio2.estadodelsistema.ModeloDelEjericicio2;
import ejercicio2.estadodelsistema.Solicitud;


public class EventoArribarACola extends Evento {
    private Integer idEmpleado;
    public EventoArribarACola(double tiempoDeOcurrencia) {
        super(tiempoDeOcurrencia);
    }
    @Override
    public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos, LibreriaDeRutinas libreria) {
        ModeloDelEjericicio2 modeloActual = (ModeloDelEjericicio2) modelo;
        LibreriaDeRutinasEjercicio2 libreriaActual = (LibreriaDeRutinasEjercicio2) libreria;
        ContadorEstadisticosEjercicio2 contadoresActuales = (ContadorEstadisticosEjercicio2) contadores;

        //Agendar el próximo arribo de solicitud.
        EventoArribarACola nuevoEvento = new EventoArribarACola(libreriaActual.tiempoEntreArribosSolicitudes());
        eventos.agregar(nuevoEvento);

        //Procesar este arribo, para lo cual es necesario generar la solicitud que acaba de arribar.
        Solicitud solicitudParaAgregar = new Solicitud(this.getTiempoDeOcurrencia());

        if(modeloActual.estanLosEmpladosOcupados()) {
            modeloActual.encolarSolicitud(solicitudParaAgregar);
        }
        else {
            this.idEmpleado = modeloActual.atenderSolicitud(solicitudParaAgregar);
            contadoresActuales.actualizarCantProcesadas();
            solicitudParaAgregar.setTiempoInicioServicio(this.getTiempoDeOcurrencia());
            contadoresActuales.addTiempoEspera(solicitudParaAgregar.getTiempoEspera());
            Double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento();
            EventoTerminaProcesamiento nuevoEventoAdicional = new EventoTerminaProcesamiento(duracionDelProcesamiento, this.idEmpleado);
            eventos.agregar(nuevoEventoAdicional);
        }
    }
}
