package ejercicio2.eventos;

// Guardar el id del trabajor a terminar


import des.*;
import ejercicio2.componentesPropios.ContadorEstadisticosEjercicio2;
import ejercicio2.componentesPropios.LibreriaDeRutinasEjercicio2;
import ejercicio2.estadodelsistema.ModeloDelEjericicio2;
import ejercicio2.estadodelsistema.Solicitud;


public class EventoTerminaProcesamiento extends Evento {
    private Integer idEmpleado;
    public EventoTerminaProcesamiento(double saltoDeTiempo, Integer idEmpleado) {
        super(saltoDeTiempo);
        this.idEmpleado = idEmpleado;
    }

    @Override
    public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos,
                               LibreriaDeRutinas libreria) {

        ContadorEstadisticosEjercicio2 contadoresEjemplo = (ContadorEstadisticosEjercicio2) contadores;
        ModeloDelEjericicio2 modeloActual = (ModeloDelEjericicio2) modelo;
        LibreriaDeRutinasEjercicio2 libreriaActual = (LibreriaDeRutinasEjercicio2) libreria;

        if(modeloActual.haySolicitudesEnEspera()) {
            modeloActual.actualizarServidorDisponible(this.idEmpleado);
            Solicitud solicitudAProcesar = modeloActual.obtenerSolicitudPrioritaria();
            this.idEmpleado = modeloActual.atenderSolicitud(solicitudAProcesar);
            contadoresEjemplo.actualizarCantProcesadas();
            solicitudAProcesar.setTiempoInicioServicio(this.getTiempoDeOcurrencia());
            contadoresEjemplo.addTiempoEspera(solicitudAProcesar.getTiempoEspera());
            Double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento();
            EventoTerminaProcesamiento nuevoEvento = new EventoTerminaProcesamiento(duracionDelProcesamiento, this.idEmpleado);
            eventos.agregar(nuevoEvento);
        }

        else {
            modeloActual.actualizarServidorDisponible(this.idEmpleado);
        }

    }
}

