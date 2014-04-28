package Display;

import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;


public class ElapsedTime {
	
	Float time = (float) 0;
	
	public ElapsedTime()
	{
		
	}
	
	public String GetElapsedTime()
	{		
		String buf = new DecimalFormat("##").format(time)+"s";
		if (time > 60)
		{
			buf = (int)(time/60)+"m"+new DecimalFormat("##").format(time%+60)+"s";
		}
		return buf;
	}
	
	public void update() 
	{
		time += Gdx.graphics.getDeltaTime();
	}

	/* GESTION 2 
	public class ElapsedTime {
		
		float miliCount = 0;
		float secCount = 0;
		float minCount = 0;
		
				
		public float sec() {
			return secCount;
		}
		public float min() {
			return minCount;
		}

		public void update() 
		{
			miliCount += Gdx.graphics.getDeltaTime();
			if(miliCount >= 1){
			    miliCount = 0;
			    secCount  ++;
			    if(secCount  == 60){
			        secCount  = 0;
			        minCount++;
			    }
			}
		}




	}
*/

}
