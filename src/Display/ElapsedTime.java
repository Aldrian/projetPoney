package Display;

/**
 * Classe gérant le temps écoulé à l'aide d'un timet basé sur un thread.
 * @author Julien
 *
 */
public class ElapsedTime {
	
	int secCount = 0;
	int minCount = 0;
	
	private Timer t;
			
	/**
	 * Constructeur par défaut instanciant le thread
	 */
	public ElapsedTime()
	{
		t = new Timer();
		
	}
	
	/**
	 * Démarre le thread de comptage
	 */
	public void start()
	{
		t.run();
	}
	
	
	/**
	 * Thread de comptage incrémentant les secondes.
	 * Basé sur un sleep(1000)
	 * @author Julien
	 *
	 */
	class Timer extends Thread{
		boolean enMarche;
		
		/**
		 * Constructeur par défaut initialisant le booléen contrôlant le compteur
		 */
		public Timer(){
			enMarche=false;
		}
		/**
		 * Compte tant que emMarche = true
		 */
		public void run(){
			enMarche=true;
			try{
				sleep(1000);
			}
			catch(InterruptedException esleep){}
			while(enMarche){
				secCount ++;
				if (secCount == 60)
				{
					secCount = 0;
					minCount++;
				}
				try{
					sleep(1000);
				}
				catch(InterruptedException esleep){}
			}		
		}
		
		/**
		 * Passe le booléen à false, ce qui arrête le compteur
		 */
		public void arret(){
			enMarche=false;
		}
		
		
		
	}
	
	/******************************************************************/
	/***********************GETTERS************************************/
	/******************************************************************/
	public int sec() {
		return secCount;
	}
	public int min() {
		return minCount;
	}

	public Timer getT() {
		return t;
	}

	




}


