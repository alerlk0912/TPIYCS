package ejercicio2.componentesPropios;

import des.LibreriaDeRutinas;

import java.util.Random;

public class LibreriaDeRutinasEjercicio2 extends LibreriaDeRutinas {
    public Double tiempoEntreArribosSolicitudes() {
        Random random = new Random();
        return -1.91 * Math.log(random.nextDouble(1));
    }

    public Double tiempoDeProcesamiento() {
        Random random = new Random();
        return random.nextDouble(1)*(2.5 - 0.5) + 0.5;
    }


}
