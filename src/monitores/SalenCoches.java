package monitores;

import java.util.Random;

public class SalenCoches extends Thread{

		private Via via;
		
		public SalenCoches(Via via){
			this.via = via;
			start();
		}
		
		public void echarCochesN(int cochesNS){
			Random rdm = new Random();
			int timeSleep = rdm.nextInt(25000 -5000) +25;
			try {
				sleep(timeSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Salen " + cochesNS + " coches hacia el sur.");
		}
		public void echarCochesS(int cochesSN){
			Random rdm = new Random();
			int timeSleep = rdm.nextInt(25000 -5000) +25;
			try {
				sleep(timeSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Salen " + cochesSN + " coches hacia el norte.");
		}
		
		public void run() {
			while(true) {
				int cochesNS = via.salirNorte();
				echarCochesN(cochesNS);
				int cochesSN = via.salirSur();
				echarCochesS(cochesSN);
			}
		}
		
}
