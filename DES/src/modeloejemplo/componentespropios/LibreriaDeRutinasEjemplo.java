package modeloejemplo.componentespropios;

import des.LibreriaDeRutinas;

import java.util.Random;

/* Subprogramas usados para generar observaciones aleatorias desde las distribuciones de 
 * probabilidad asociadas al modelo. */

public class LibreriaDeRutinasEjemplo extends LibreriaDeRutinas {

	public Double tiempoEntreArribosSolicitudes() {
		Random random = new Random();
		return -1.91 * Math.log(random.nextDouble(1));
	}

	public Double tiempoDeProcesamiento() {
		Random random = new Random();
		return random.nextDouble(1)*2 + 0.5;
	}


}
