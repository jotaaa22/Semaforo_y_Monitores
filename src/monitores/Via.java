package monitores;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Via{
	
	public final int tamañoVia = 1;
	private Queue<Integer> cola = new LinkedList<Integer>();
	
	public synchronized void añadirNorte(int cochesNS) {
		if(cola.size() == tamañoVia) {
			try {
				System.out.println("Vía ocupadada.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cola.add(cochesNS);
		System.out.println("Entraron " + cochesNS + " coches del norte.");
		notify();
	}
	public synchronized void añadirSur(int cochesSN) {
		if(cola.size() == tamañoVia) {
			try {
				System.out.println("Vía ocupadada.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cola.add(cochesSN);
		System.out.println("Entraron " + cochesSN + " coches del sur.");
		notify();
	}
	
	public synchronized int salirNorte() {
		if(cola.size() == 0) {
			try {
				System.out.println("La vía está vacía.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int cochesNS = cola.poll();
		notify();
		return cochesNS;
	}
	public synchronized int salirSur() {
		if(cola.size() == 0) {
			try {
				System.out.println("La vía está vacía.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int cochesSN = cola.poll();
		notify();
		return cochesSN;
	}
}
