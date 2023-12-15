package semaforo;

public class Productor {
	private int totalRecursos;
	
	public Productor(int totalRecursos) {
		this.totalRecursos = totalRecursos;
	}
	
	public Recurso producirRecurso() {
		return new Recurso(totalRecursos);
	}
}
