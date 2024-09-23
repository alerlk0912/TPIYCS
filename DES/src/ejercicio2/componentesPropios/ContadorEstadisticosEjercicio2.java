package ejercicio2.componentesPropios;

import des.ContadoresEstadisticos;

import java.util.ArrayList;

/* Variables que almacenan información estadística referida al comportamiento del sistema. */

public class ContadorEstadisticosEjercicio2 extends ContadoresEstadisticos {

    private int cantSolicitudesProcesadas;
    private ArrayList<Double> tiemposEspera = new ArrayList<>();

    public ContadorEstadisticosEjercicio2() {
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
    public long getCantidadSolicitudesAtendidasMenosTresMinutos(){
        return this.tiemposEspera.stream().filter(tiempoEspera -> tiempoEspera <= 3.0).count();
    }

    public int getCantidadTiemposDeEspera() {
        return tiemposEspera.size();
    }
}
