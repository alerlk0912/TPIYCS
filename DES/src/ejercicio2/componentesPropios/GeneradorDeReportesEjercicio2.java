package ejercicio2.componentesPropios;

import des.ContadoresEstadisticos;
import des.GeneradorDeReportes;
import modeloejemplo.componentespropios.ContadoresEstadisticosEjemplo;

public class GeneradorDeReportesEjercicio2 extends GeneradorDeReportes {
    @Override
    public void run(ContadoresEstadisticos contadores) {

        ContadorEstadisticosEjercicio2 contadoresEjercicio2 = (ContadorEstadisticosEjercicio2) contadores;

        System.out.println("------------------------------------------------------");
        System.out.println("***GENERADOR DE REPORTES *** ");
        System.out.println("------------------------------------------------------");

        System.out.println("La cantidad de solicitudes procesadas es de: " + contadoresEjercicio2.getCantProcesadas());
        System.out.println("El tiempo de espera de espera promedio es de: " + (contadoresEjercicio2.getAcumuladorTiempoEspera() / contadoresEjercicio2.getCantidadTiemposDeEspera()));
        System.out.println("La cantidad de solicitudes procesadas en menos de 3 minutos es de: " + contadoresEjercicio2.getCantidadSolicitudesAtendidasMenosTresMinutos());
        System.out.println("El porcentaje de clientes atendidos en menos de 3 minutos es de: " + 100.00 * contadoresEjercicio2.getCantidadSolicitudesAtendidasMenosTresMinutos() / contadoresEjercicio2.getCantProcesadas());
        System.out.println("La longitud del ArrayList con los tiempos de espera es  de: " + contadoresEjercicio2.getCantidadTiemposDeEspera());
    }
}
