package semaforo;

import java.util.Random;

public class ConsumidorRecursos implements Runnable{
	
	private Recurso recurso;
	private Random rdm = new Random();
	
	public ConsumidorRecursos(Recurso recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public void run() {
		while(recurso.getNumDisponibles() > 0) {
			int numRequerido = rdm.nextInt(5) + 1;
			recurso.reservar(numRequerido);
			
			int numLiberado = rdm.nextInt(numRequerido) + 1;
			recurso.liberar(numLiberado);
		}
		
	}
	
}
