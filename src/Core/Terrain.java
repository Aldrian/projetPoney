package Core;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Game.PointInt;


/*
 * Format fichier :
 * 0 Vide
 * 1 Platform //OK
 * 2 Pit //OK
 * 3 Spawn Monster //OK
 * 4 Spawn Player //OK
 * 5 Spawn Bomb //OK
 * 6 Spawn Box //OK
 */
public class Terrain
{
	int [][] blocks;
	
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
			
			for (int i=9;i>-1;i--)
			{
				for (int j=9;j>-1;j--)
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
		
		for (int i=9;i>-1;i--)
		{
			String s=new String();
			for (int j=9;j>-1;j--)
			{
				s+=blocks[i][j];
			}
			System.out.println(s);
		}
		System.out.println("Terrain chargé");
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
			
		while(i!=10) {
		
			for(j=0;j<10;j++) {
					
				if(blocks[i][j]==1) {
					
					plateforme = new Platform(new PointInt(i*80,j*60)); 
					plateforme.setHeight(60);
					
					while (j<10 && blocks[i][j]==1) {
						plateforme.setWidth(plateforme.getWidth()+80);
						j++;
					}
					list.add(plateforme);
				}
					
				else if(blocks[i][j]==2) {
					
					lePit = new Pit(new PointInt(i*80,j*60));
					lePit.setHeight(60);
						
					while (j<10 && blocks[i][j]==2) {
						lePit.setWidth(lePit.getWidth()+80);
						j++;
					}
					list.add(lePit);
				}
					
			}
			i++;
		}
		
		list.add(new Wall(new PointInt(-1,0),1,600));
		list.add(new Wall(new PointInt(800,0),1,600));
		
		return list;	
	}
	
	/**
	 * Retourne la liste des points de spawn des bombes
	 * @return List<PointInt>
	 */
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
	
	/**
	 * Retourne le point de spawn de la box
	 * @return PointInt
	 */
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
	
	/**
	 * Retourne le point de spawn des joueurs
	 * @return PointInt
	 */
	public PointInt players()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(blocks[i][j]==4)
				{
					return new PointInt(i*80,j*60);
				}
			}					
		}
		return null;
	}
	
	/**
	 *  Retourne le point de spawn des monstres
	 * @return PointInt
	 */
	public PointInt monsters()
	{		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(blocks[i][j]==3)
				{
					return new PointInt(i*80,j*60);
				}
			}					
		}		
		return null;
	}
	
	public static void main(String[] args)
	{
    	Terrain terrain=new Terrain("res/map/terrain.txt");

	}
}

