package modeloejemplo.componentespropios;

import des.ContadoresEstadisticos;

import java.util.ArrayList;

/* Variables que almacenan información estadística referida al comportamiento del sistema. */

public class ContadoresEstadisticosEjemplo extends ContadoresEstadisticos {
	
	private int cantSolicitudesProcesadas;
	private ArrayList<Double> tiemposEspera = new ArrayList<>();

	public ContadoresEstadisticosEjemplo() {
		super();
	}

	public void inicializar() {
		cantSolicitudesProcesadas = 0;
	}

	public int getCantProcesadas() {
		return cantSolicitudesProcesadas;
	}

	public void actualizarCantProcesadas() {
		cantSolicitudesProcesadas++;		
	}

	public void addTiempoEspera(Double tiempoEspera){
		tiemposEspera.add(tiempoEspera);
	}
	public Double getAcumuladorTiempoEspera(){
		return tiemposEspera.stream().mapToDouble(Double :: doubleValue).sum();
	}


	public int getCantidadTiemposDeEspera() {
		return tiemposEspera.size();
	}
}
