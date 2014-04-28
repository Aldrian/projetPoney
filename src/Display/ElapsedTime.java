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




}
