package Core;

import java.io.*;
import java.util.HashSet;


/*
 * Format fichier :
 * 0 Vide
 * 1 Platform
 * 2 Pit
 * 3 Spawn Monster
 * 4 Spawn Player
 * 5 Spawn Bomb
 * 6 Spawn Box
 */
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
	
	
	//permet de récupérer une liste contenant un nombre minimal de plateforme
		public HashSet<NotMovingEntity> plateforme(int [][] block){
			
			HashSet<NotMovingEntity> list = new HashSet<NotMovingEntity>();
			
			int i=0;
			int j=0;
			
			Platform plateforme = null;
			Pit lePit = null;
			
			while(j!=10) {
				
				for(i=0;i<10;i++) {
					
					if(block[i][j]==1) {
						
						plateforme = new Platform();
						plateforme.setHeight(60);
						
						while (i<10 && block[i][j]==1) {
							plateforme.setWidth(plateforme.getWidth()+80);
							i++;
						}
						list.add(plateforme);
					}
					
					else if(block[i][j]==2) {
						
						lePit = new Pit();
						lePit.setHeight(60);
						
						while (i<10 && block[i][j]==2) {
							lePit.setWidth(lePit.getWidth()+80);
							i++;
						}
						list.add(lePit);
					}
					
				}
				j++;
			}
			return list;	
		}
		
	
	//Main de test
	public static void main(String [] args)
	{
		Terrain t=new Terrain("res/map/terrain.txt");
		
		
	}
}

