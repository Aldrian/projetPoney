package Interface;

import org.mini2Dx.core.geom.Point;

import Game.Move;
import Game.PointInt;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * SuperClasse Animation
 * Initialise uniquement l'origine de l'animation
 * D�fini les fonctions de rendu et de mise � jour pour les toutes les classes d�rivant d'animator
 * @author Ga�tan
 *
 */
public abstract class Animator implements ApplicationListener 
{
	protected int    FRAME_COLS = 4;
	protected int    FRAME_LINES = 3;

	protected Animation walkAnimation[]; // Animation
	protected Texture walkSheet; // Chargement de la feuille de sprite
	protected Array<TextureRegion> walkFrames; // Stockage des sprites
	protected SpriteBatch spriteBatch; // Sprite buffer
	protected TextureRegion currentFrame; // sprite courante

	protected Point renderPosition; // Position de l'animation

	protected float stateTime;  // temps

	protected Move mouvement; // Mouvement demand� au joueur (pas de lerp)

	protected int typeAnimation; // Donne le type d'animation demand�

	/**
	 * Constructeur par d�faut, prenant en param�tre le point o� l'animation appara�tra � sa cr�ation
	 * @param point d'origine
	 */
	public Animator(Point origin)
	{
		this.renderPosition = origin;
		mouvement = new Move(new PointInt(origin),new PointInt(origin));
	}



	/**
	 * Mise � jour des coordonn�es courantes de l'animation
	 * Prend en param�tres les float de la position de rendu et le mouvement de l'entit�
	 * En d�duit la direction que 'animation doit prendre
	 * @param coordonn�e de render x
	 * @param coordonn�e de render y
	 * @param mouvement associ�
	 */
	public void update(float x, float y, Move mouvement)
	{
		renderPosition.x = x;
		renderPosition.y = y;
		this.mouvement = mouvement;

		if(mouvement.isLeft())
		{
			typeAnimation = 1;
		}
		else if(mouvement.isRight())
		{
			typeAnimation = 0;
		}
		else if (typeAnimation == 0 && mouvement.isStatic())
		{
			typeAnimation = 2;
		}
		else if (typeAnimation == 1 && mouvement.isStatic())
		{
			typeAnimation = 3;
		}
		
	}

	/**
	 * M�thode de rendu graphique
	 * Lance le spriteBatch avec l'animation ad�quate
	 */
	@Override
	public void render()
	{
		//Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = walkAnimation[typeAnimation].getKeyFrame(stateTime, true);
		currentFrame.setRegion(currentFrame, 0, 0, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_LINES);

		spriteBatch.begin();
		spriteBatch.draw(currentFrame, renderPosition.x , renderPosition.y);
		spriteBatch.end();
		
		//System.out.println(renderPosition.x);
		//System.out.println(renderPosition.y);
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int arg0, int arg1) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}
}
