package Core;

import java.io.*;

public class Terrain
{
	private int [][] pixels;
	
	public Terrain(String file)
	{
		int [][] blocks=new int[10][10];
		
		try
		{
			FileInputStream fis = new FileInputStream(file);
			
			for (int i=0;i<10;i++)
			{
				for (int j=0;j<10;j++)
				{
					blocks[i][j]=Character.getNumericValue(fis.read());
				}
				fis.skip(2);
			}
			fis.close();
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		pixels=new int[800][600];
		
		for(int i = 0; i<10; i++)
		{
			for (int x=i*80;x<(i+1)*80;x++)
			{
				for (int j = 0; j < 10; j++)
				{
					for (int y=j*60;y<(j+1)*60;y++)
					{
						pixels[x][y]=blocks[i][j];
					}
				}
			}			
		}
		
		//Affichage console des blocks
		for (int i=0;i<800;i+=80)
		{
			for (int j=0;j<600;j+=60)
			{
				System.out.print(pixels[i][j]);
			}
			System.out.println();
		}
		
	}
	
	//Main de test
	public static void main(String [] args)
	{
		Terrain t=new Terrain("res/map/terrain.txt");
		
		
	}
}

