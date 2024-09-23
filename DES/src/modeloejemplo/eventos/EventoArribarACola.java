package modeloejemplo.eventos;

import des.*;
import modeloejemplo.componentespropios.ContadoresEstadisticosEjemplo;
import modeloejemplo.componentespropios.LibreriaDeRutinasEjemplo;
import modeloejemplo.estadodelsistema.ModeloDelEjemplo;
import modeloejemplo.estadodelsistema.Solicitud;

public class EventoArribarACola extends Evento {

	public EventoArribarACola(double tiempoDeOcurrencia) {
		super(tiempoDeOcurrencia);
	}

	@Override
	public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos,
			LibreriaDeRutinas libreria) {
				
		ModeloDelEjemplo modeloActual = (ModeloDelEjemplo) modelo;
		LibreriaDeRutinasEjemplo libreriaActual = (LibreriaDeRutinasEjemplo) libreria;
		
		//Agendar el próximo arribo de solicitud.
		EventoArribarACola nuevoEvento = new EventoArribarACola(libreriaActual.tiempoEntreArribosSolicitudes());
		eventos.agregar(nuevoEvento);
		
		//Procesar este arribo, para lo cual es necesario generar la solicitud que acaba de arribar.
		Solicitud solicitudParaAgregar = new Solicitud(this.getTiempoDeOcurrencia());
		
		if(modeloActual.estaServidorOcupado()) {
			modeloActual.encolarSolicitud(solicitudParaAgregar);
		}
		else {
			modeloActual.atenderSolicitud(solicitudParaAgregar);
			solicitudParaAgregar.setTiempoInicioServicio(this.getTiempoDeOcurrencia());
			((ContadoresEstadisticosEjemplo) contadores).addTiempoEspera(
					solicitudParaAgregar.getTiempoInicioServicio() - solicitudParaAgregar.getTiempoArribo());
			Double duracionDelProcesamiento = libreriaActual.tiempoDeProcesamiento();
			EventoTerminaProcesamiento nuevoEventoAdicional = new EventoTerminaProcesamiento(duracionDelProcesamiento);	
			eventos.agregar(nuevoEventoAdicional);
		}
	}

}
