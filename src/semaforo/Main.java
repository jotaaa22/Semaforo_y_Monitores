package semaforo;

public class Main {

	public static void main(String[] args) {
		Productor productor = new Productor(15);
		Recurso recurso = productor.producirRecurso();
		
		int i = 2;
		Thread[] hilos = new Thread[i];
		
		for(int j = 0; j < i; j++) {
			hilos[j] = new Thread(new ConsumidorRecursos(recurso), "Proceso número " + j);
			hilos[j].start();
		}
		try {
		for(Thread hilo : hilos) {
			hilo.join();
		}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
