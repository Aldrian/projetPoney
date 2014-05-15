package Display;

public class ElapsedTime {
	
	int secCount = 0;
	int minCount = 0;
	
	private Timer t;
			
	public ElapsedTime()
	{
		t = new Timer();
		
	}
	
	public void start()
	{
		t.run();
	}
	
	
	class Timer extends Thread{
		boolean enMarche;
		public Timer(){
			enMarche=false;
		}
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
		public void arret(){
			enMarche=false;
		}
		
		
		
	}
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


