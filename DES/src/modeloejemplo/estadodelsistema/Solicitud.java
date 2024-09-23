package modeloejemplo.estadodelsistema;

/* Solicitud que puede ser procesada por el servidor. */

public class Solicitud {
	int clase;
	private Double tiempoArribo;
	private Double tiempoInicioServicio;


	public Solicitud(Double tiempoArribo) {
		super();
		this.clase = (int) ((Math.random()*3) + 1);
		this.tiempoArribo = tiempoArribo;
	}

	public int getClase() {
		return clase;
	}

	public void setClase(int clase) {
		this.clase = clase;
	}

	public Double getTiempoArribo() {
		return tiempoArribo;
	}

	public void setTiempoArribo(Double tiempoArribo) {
		this.tiempoArribo = tiempoArribo;
	}

	public Double getTiempoInicioServicio() {
		return tiempoInicioServicio;
	}

	public void setTiempoInicioServicio(Double tiempoInicioServicio) {
		this.tiempoInicioServicio = tiempoInicioServicio;
	}
}

