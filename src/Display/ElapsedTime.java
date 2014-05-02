package Display;

public class ElapsedTime {
	
	int secCount = 0;
	int minCount = 0;
	
	private Timer t;
			
	public ElapsedTime()
	{
		t = new Timer();
		t.start();
	}
	
	class Timer extends Thread{
		boolean enMarche;
		public Timer(){
			enMarche=true;
		}
		public void run(){
			enMarche=true;
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

	




}


