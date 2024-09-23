package ejercicio2.estadodelsistema;

import des.EstadoDelSistema;

import java.util.LinkedList;
import java.util.Optional;

public class ModeloDelEjericicio2 extends EstadoDelSistema {
    private ColaDeSolicitudes cola;
    private LinkedList<Empleado> empleados = new LinkedList<>();

    public void inicializar() {
        cola = new ColaDeSolicitudes();
        int cantidadEmpleados = 1;
        for(int i = 0; i < cantidadEmpleados; i++){
            empleados.add(new Empleado(false));
        }
    }

    public void encolarSolicitud(Solicitud solicitudParaAgregar) {
        System.out.println("\t\t-- El MODELO encola una solicitud, ya que los empleados están ocupado.");
        cola.encolarSolicitud(solicitudParaAgregar);
    }

    public boolean estanLosEmpladosOcupados() {
        return empleados.stream()
                        .allMatch(Empleado::getEstaOcupado);
    }

    public int atenderSolicitud(Solicitud solicitudParaAgregar) {
        Optional<Empleado> primerEmpleadoLibre = empleados.stream()
                                                .filter(empleado -> !empleado.getEstaOcupado())
                                                .findFirst();

        if (primerEmpleadoLibre.isPresent()) {
            Empleado empleadoLibre = primerEmpleadoLibre.get();
            System.out.println("\t\t-- El MODELO define que el empleado " + empleados.indexOf(empleadoLibre) + " atiende una solicitud.");
            empleadoLibre.pasarAOcupado(solicitudParaAgregar);
            return empleados.indexOf(empleadoLibre);
        }else{
            return -1;
        }
    }

    public boolean haySolicitudesEnEspera() {
        return (cola.getCantSolicitudesEsperando()>0);
    }

    public Solicitud obtenerSolicitudPrioritaria() {
        return cola.solicitudPrioritaria();
    }

    public void actualizarServidorDisponible(int idEmpleado) {
        System.out.println("\t\t-- El MODELO deja al empleado " + idEmpleado + " disponible.");
        empleados.get(idEmpleado).setEstaOcupado(false);
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }
}
