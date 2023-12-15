package monitores;

import java.util.Random;

public class AgregarCoches extends Thread{
	
	private Via via;
	
	public AgregarCoches(Via via) {
		this.via = via;
		start();
	}
	
	public int añadirCochesN() {
		Random rdm = new Random();
		int cochesNS = rdm.nextInt(10) +1;
		int timeSleep = rdm.nextInt(25000 -5000) +25;
		try {
			sleep(timeSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return cochesNS;
	}
	public int añadirCochesS() {
		Random rdm = new Random();
		int cochesSN = rdm.nextInt(10) +1;
		int timeSleep = rdm.nextInt(25000 -5000) +25;
		try {
			sleep(timeSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return cochesSN;
	}
	
	public void run() {
		while(true) {
			int cochesNS = añadirCochesN();
			via.añadirNorte(cochesNS);
			int cochesSN = añadirCochesS();
			via.añadirSur(cochesSN);
			
		}
	}
}
