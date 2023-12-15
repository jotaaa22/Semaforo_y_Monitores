package semaforo;

import java.util.concurrent.Semaphore;

public class Recurso {
	private Semaphore semaforo;
	private int numDisponibles;
	
	public Recurso(int n) {
		semaforo = new Semaphore(n, true);
		numDisponibles = n;
	}
	
	public void reservar(int r) {
		try {
			semaforo.acquire(r);
			numDisponibles -= r;
			System.out.println(Thread.currentThread().getName() + " ha reservado " + r + " recursos. Recursos a disposición: " + numDisponibles);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void liberar(int l) {
		numDisponibles += l;
		semaforo.release();
		System.out.println(Thread.currentThread().getName() + " ha liberado " + l + " recursos. Recursos a disposición: " + numDisponibles);
	}
	
	public int getNumDisponibles() {
		return numDisponibles;
	}
}
