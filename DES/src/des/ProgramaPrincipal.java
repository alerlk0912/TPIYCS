package des;

import ejercicio2.componentesPropios.GeneradorDeReportesEjercicio2;
import ejercicio2.componentesPropios.LibreriaDeRutinasEjercicio2;
import ejercicio2.componentesPropios.ListaDeEnventosEjericicio2;
import ejercicio2.estadodelsistema.ModeloDelEjericicio2;
import ejercicio2.componentesPropios.ContadorEstadisticosEjercicio2;

import static java.lang.Thread.sleep;

/* Subprograma que invoca a la Rutina de Tiempo para determinar evento inminente, 
 * transfiriendo el control a la Rutina de Evento asociada para que actualice el
 * Estado del Sistema. */

public class ProgramaPrincipal {

	//Creación de los componentes propios del ejemplo.
	private static EstadoDelSistema modelo;		
	private static ContadoresEstadisticos contadores;
	private static GeneradorDeReportes reporte;
	private static LibreriaDeRutinas libreria;
	private static ListaDeEventos eventos;
		
	public static void main(String[] args){

		//Creación de los componentes propios del ejemplo a ejecutar.
		crearComponentesDependientes();
		
		//Creación de los componentes generales.
		RutinaDeInicializacion inicializacion = new RutinaDeInicializacion();
		RutinaDeTiempo manejoDeTiempo = new RutinaDeTiempo();
		RelojDeSimulacion reloj = new RelojDeSimulacion();

		System.out.println("------------------------------------------------------");
		System.out.println("***INICIALIZACION");
		System.out.println("------------------------------------------------------");
		
		//Flujo de control
		inicializacion.run(reloj,modelo,contadores,eventos,libreria);
		
		do { 
			
			System.out.println("------------------------------------------------------");
			System.out.println("***PROGRAMA PRINCIPAL *** t=" + reloj.getValor());
			System.out.println("------------------------------------------------------");
						
			//Invocar a la rutina de tiempo.
			Evento eventoPorEjecutar = manejoDeTiempo.run(eventos,reloj);
			
			System.out.println("\t\t-- El SIMULADOR determina que el EVENTO MAS INMINENTE se dará en " + eventoPorEjecutar.getTiempoQueFaltaParaQueOcurra() + " unidades de tiempo.");
			System.out.println("\t\t-- El SIMULADOR actualiza el RELOJ para ejecutar el EVENTO MAS INMINENTE del tipo " + eventoPorEjecutar.getClass().getSimpleName() + ".");
			
			//Invocar a la rutina de evento.
			eventoPorEjecutar.rutinaDeEvento(modelo,contadores,eventos,libreria);

			
		}while(!terminoLaSimulacion(reloj,contadores));
		
		reporte.run(contadores);

	}

	private static void crearComponentesDependientes() {
		//TODO Aca se crean los componentes propios del modelo a ejecutar.
		modelo = new ModeloDelEjericicio2();
		contadores = new ContadorEstadisticosEjercicio2();
		reporte = new GeneradorDeReportesEjercicio2();
		libreria = new LibreriaDeRutinasEjercicio2();
		eventos = new ListaDeEnventosEjericicio2();
	}

	private static boolean terminoLaSimulacion(RelojDeSimulacion reloj, ContadoresEstadisticos contadores) {
		//TODO Aca se debe programar según el fin sea por tiempo o cantidad.
		
		//Ejemplo por tiempo
		int tiempoDeSimulacion = 8 * 60;
		return reloj.getValor() >= tiempoDeSimulacion;

		//Ejemplo por cantidad: "Que se hayan procesado 15 solicitudes."
//		ContadorEstadisticosEjercicio2 contadorEjemplo = (ContadorEstadisticosEjercicio2) contadores;
//		int cantidadDeSimulacion = contadorEjemplo.getCantProcesadas(), topeDeSimulacion=50;
//		return cantidadDeSimulacion >= topeDeSimulacion;

	}

}
