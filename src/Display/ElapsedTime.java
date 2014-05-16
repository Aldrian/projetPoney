package Display;

/**
 * Classe g�rant le temps �coul� � l'aide d'un timet bas� sur un thread.
 * @author Julien
 *
 */
public class ElapsedTime {
	
	int secCount = 0;
	int minCount = 0;
	
	private Timer t;
			
	/**
	 * Constructeur par d�faut instanciant le thread
	 */
	public ElapsedTime()
	{
		t = new Timer();
		
	}
	
	/**
	 * D�marre le thread de comptage
	 */
	public void start()
	{
		t.run();
	}
	
	
	/**
	 * Thread de comptage incr�mentant les secondes.
	 * Bas� sur un sleep(1000)
	 * @author Julien
	 *
	 */
	class Timer extends Thread{
		boolean enMarche;
		
		/**
		 * Constructeur par d�faut initialisant le bool�en contr�lant le compteur
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
		 * Passe le bool�en � false, ce qui arr�te le compteur
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


