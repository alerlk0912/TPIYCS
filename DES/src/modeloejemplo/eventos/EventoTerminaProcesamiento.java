package modeloejemplo.eventos;

import des.*;
import ejercicio2.componentesPropios.LibreriaDeRutinasEjercicio2;
import modeloejemplo.componentespropios.ContadoresEstadisticosEjemplo;
import modeloejemplo.componentespropios.LibreriaDeRutinasEjemplo;
import modeloejemplo.estadodelsistema.ModeloDelEjemplo;
import modeloejemplo.estadodelsistema.Solicitud;

public class EventoTerminaProcesamiento extends Evento {

	public EventoTerminaProcesamiento(double tiempoDeOcurrencia) {
		super(tiempoDeOcurrencia);
	}

	@Override
	public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos,
			LibreriaDeRutinas libreria) {
		
		ContadoresEstadisticosEjemplo contadoresEjemplo = (ContadoresEstadisticosEjemplo) contadores;
		LibreriaDeRutinasEjemplo libreriaEjemplo = (LibreriaDeRutinasEjemplo) libreria;
		contadoresEjemplo.actualizarCantProcesadas();
		
		ModeloDelEjemplo modeloActual = (ModeloDelEjemplo) modelo;

		if(modeloActual.haySolicitudesEnEspera()) {
			Solicitud solicitudAProcesar = modeloActual.obtenerSolicitudPrioritaria();
			modeloActual.atenderSolicitud(solicitudAProcesar);
			solicitudAProcesar.setTiempoInicioServicio(this.getTiempoDeOcurrencia());
			((ContadoresEstadisticosEjemplo) contadores).addTiempoEspera(
					solicitudAProcesar.getTiempoInicioServicio() - solicitudAProcesar.getTiempoArribo());
			Double duracionDelProcesamiento = libreriaEjemplo.tiempoDeProcesamiento();
			EventoTerminaProcesamiento nuevoEvento = new EventoTerminaProcesamiento(duracionDelProcesamiento);
			eventos.agregar(nuevoEvento);
		}

		else {

			modeloActual.actualizarServidorDisponible();
		}

	}

}
