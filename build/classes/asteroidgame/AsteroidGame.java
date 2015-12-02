
package asteroidgame;

import blobzx.BlobGUI;
import blobzx.SandBox;
import blobzx.SandBoxMode;
import java.awt.Dimension;
import java.util.Random;

/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author: Connor Shepard
 */
public class AsteroidGame implements BlobGUI {

    public static void main(String[] args) {
        new AsteroidGame();
    }
    
    SandBox sandbox = new SandBox();

    public AsteroidGame() {
    
        SandBox realSandbox = sandbox;
        realSandbox.setSandBoxMode(SandBoxMode.FLOW);
        realSandbox.setFrameRate(15);
        realSandbox.init(this);
    }
        
    @Override
    public void generate() {                    
       
        Random random = new Random();
        
        for(int num = 0; num < 10; num++)
        {
            int xvelocity = (random.nextInt(7)) - 3;
            if (xvelocity == 0)
                xvelocity++;
            int yvelocity = (random.nextInt(7)) - 3;
            if (yvelocity == 0)
                yvelocity--;
            double rotation = (random.nextInt(2));
            if (rotation == 0)
                rotation = -0.1;
            else
                rotation = 0.1;
            
            Asteroid asteroid = new Asteroid(xvelocity, yvelocity, rotation);
            sandbox.addBlob(asteroid);    
            
            Dimension dim = sandbox.getPanelBounds();
        
            Rocket apollo = new Rocket(dim.width/2, dim.height/2, sandbox);
            sandbox.addBlob(apollo);
        }
        }
        
        
}
