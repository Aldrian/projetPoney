package Game;

import Display.*;

import org.mini2Dx.core.game.Mini2DxGame;
import org.mini2Dx.core.game.ScreenBasedGame;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Game extends ScreenBasedGame {
   
	 /**************************************************************/
    /***********************BOUCLE DU JEU**************************/
    /**************************************************************/
    @Override
    public void initialise() {
    	this.addScreen(new LoadingScreen());
        this.addScreen(new InGameScreen());
        this.addScreen(new EndGameScreen());
    }

   
    @Override
    public int getInitialScreenId() {
        return LoadingScreen.ID;
    }
    
    /**************************************************************/
    /***************************************************************/
    /**************************************************************/
    
    public static void main(String [] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Mayhem in the skies !";
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 650;
        cfg.useCPUSynch = false;
        cfg.vSyncEnabled = true;
        cfg.resizable = false;
        cfg.addIcon("res/img/Icon/icon-256.png", FileType.Internal);
        cfg.addIcon("res/img/Icon/icon-64.png", FileType.Internal);
        cfg.addIcon("res/img/Icon/icon-32.png", FileType.Internal);
        new LwjglApplication(new Mini2DxGame(new Game()), cfg);
    }
    
}

