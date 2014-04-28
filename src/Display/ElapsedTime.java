package Display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;

public class ElapsedTime {
	
	private Timer time;
	
	public ElapsedTime()
	{
		time = new Timer();
	}
	
	public String GetElapsedTime()
	{
		
		return time.toString();
	}
	
	public void stop(){
		time.stop();
	}
	
	public void start(){
		time.start();
	}




}
