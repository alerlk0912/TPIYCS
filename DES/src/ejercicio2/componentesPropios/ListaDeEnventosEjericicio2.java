package ejercicio2.componentesPropios;

import des.Evento;
import des.LibreriaDeRutinas;
import des.ListaDeEventos;
import des.RelojDeSimulacion;
import modeloejemplo.componentespropios.LibreriaDeRutinasEjemplo;
import ejercicio2.eventos.EventoArribarACola;

import java.util.LinkedList;

public class ListaDeEnventosEjericicio2 extends ListaDeEventos {
    @Override
    public void inicializar(LibreriaDeRutinas libreria, RelojDeSimulacion reloj) {
        lista = new LinkedList<Evento>();
        LibreriaDeRutinasEjercicio2 libreriaEjercicio2 = (LibreriaDeRutinasEjercicio2) libreria;
        Evento primerEvento = new EventoArribarACola(libreriaEjercicio2.tiempoEntreArribosSolicitudes());
        agregar(primerEvento);
    }
}
