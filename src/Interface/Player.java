package Interface;

import org.mini2Dx.core.geom.Point;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;


public class Player {
     private Point previousPosition;
     private Point currentPosition;
    // private Sprite sprite;
     
     private Animator animation;

     public Player() {
          previousPosition = new Point(400,200);
          currentPosition = new Point(400,200);
          
          // Init l'affiche du joeur
          animation = new Animator(new Point(400,200));
          animation.create();
         
          //Initialise sprite
          //Texture img = new Texture(Gdx.files.internal("res\\img\\J1\\stand.png"));
          //sprite = new Sprite(img);
          //sprite.setPosition(400, 200);
          // sprite.flip(false, true);
     }
     
     public void update(int i) {
         previousPosition = new Point(currentPosition);
         if(i == 1 ){
           	currentPosition.set(currentPosition.x + 10f, currentPosition.y);
         }
         else currentPosition.set(currentPosition.x - 10f, currentPosition.y);
     }

     public void interpolate(float alpha) {
          //Use the lerp (linear interpolate) method from LibGDX 
          //to interpolate between the previous and current positions
          //This will return the render coordinates
          Vector2 renderPosition = previousPosition.lerp(currentPosition, alpha);
          // sprite.setPosition(renderPosition.x, renderPosition.y);
          
          animation.update(renderPosition.x, renderPosition.y);
     }

     public void render(Graphics g) {
          animation.render();
     }
}