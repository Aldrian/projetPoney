package Core;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Game.PointInt;


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
	private int [][] blocks;
	
	/**
	 * Constructeur de terrain
	 * @param file
	 */
	public Terrain(String file)
	{
		blocks=new int[10][10];
		
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
		
		/*//Affichage console des blocks
		for (int i=0;i<800;i+=80)
		{
			for (int j=0;j<600;j+=60)
			{
				System.out.print(pixels[i][j]);
			}
			System.out.println();
		}
		*/
	}
	
	
	
	/**
	 * Retourne la liste des plateformes(+ Pit + Walls) en fonction du fichier de terrain 
	 * @return
	 */
	public HashSet<NotMovingEntity> plateforme(){
			
		HashSet<NotMovingEntity> list = new HashSet<NotMovingEntity>();
			
		int i=0;
		int j=0;
			
		Platform plateforme = null;
		Pit lePit = null;
			
		while(j!=10) {
		
			for(i=0;i<10;i++) {
					
				if(blocks[i][j]==1) {
					
					plateforme = new Platform(new PointInt(i*80,j*60)); 
					plateforme.setHeight(60);
					
					while (i<10 && blocks[i][j]==1) {
						plateforme.setWidth(plateforme.getWidth()+80);
						i++;
					}
					list.add(plateforme);
				}
					
				else if(blocks[i][j]==2) {
					
					lePit = new Pit(new PointInt(i*80,j*60));
					lePit.setHeight(60);
						
					while (i<10 && blocks[i][j]==2) {
						lePit.setWidth(lePit.getWidth()+80);
						i++;
					}
					list.add(lePit);
				}
					
			}
			j++;
		}
		
		list.add(new Wall(new PointInt(0,0),-1,600));
		list.add(new Wall(new PointInt(800,0),1,600));
		
		return list;	
	}
	
	public List<PointInt> bombs()
	{
		List<PointInt> bombspawn=new ArrayList<PointInt>();
		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(blocks[i][j]==5)
				{
					bombspawn.add(new PointInt(i*80,j*60));
				}
			}					
		}		
		return bombspawn;
	}
	
	public PointInt box()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(blocks[i][j]==6)
				{
					return new PointInt(i*80,j*60);
				}
			}					
		}
	return null;
	}
}

