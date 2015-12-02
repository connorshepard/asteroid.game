
package asteroidgame;
import blobzx.*;
import static blobzx.BlobUtils.playSound;
import java.awt.Point;
import java.awt.event.KeyEvent;

/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author: Connor Shepard
 */
public class Rocket extends PolyBlob implements BlobAction, BlobProximity  {
    
    private final int[] xp = { 10, -10, -5, -10 };
    private final int[] yp = { 0, -7, 0, 7 };

    private final int[] x = { 10, -10, -5, -10 };
    private final int[] y = { 0, -7, 0, 7 };
    
    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    
    private final SandBox sandbox;
    
    public Rocket(int xloc, int yloc, SandBox sb)
    {
        super(0,0,0);
        setLoc(xloc,yloc);
        setPolygon(x, y);
        angle = 0;
        sandbox = sb;
    }

    @Override
    public void keyAction(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            int xloc = getLoc().x;
            int yloc = getLoc().y;
            
            xloc = xloc + (int) Math.round (speed * Math.cos(angle));
            yloc = yloc + (int) Math.round (speed * Math.sin(angle));
            setLoc(xloc,yloc);
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) 
        {
            angle -= delta;
            if (angle < 0 ) {
                angle += Math.PI * 2;
            }
            turn();
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
        {
            angle += delta;
            if (angle > 0 ) {
                angle -= Math.PI * 2;
            }
            turn();
                
        }
        
        else if (e.getKeyCode() == 32) //fire rocket w/ spacebar
        {
            launch(sandbox);
            BlobUtils.playSound();
        }
    }
    
    public void turn() {
        
        for (int i = 0; i < 4; i++)
        {
            Point p = BlobUtils.rotatePoint( xp[i], yp[i], angle );
            x[i] = p.x;
            y[i] = p.y;
        }
    }
    
    public void launch(SandBox sb) {
        
        double boundingRadius = 0.5 * getSize();
        double distance = boundingRadius + 5;
        int xloc = getLoc().x;
        int yloc = getLoc().y;
            
        xloc = xloc + (int) Math.round (speed * Math.cos(angle));
        yloc = yloc + (int) Math.round (speed * Math.sin(angle));
        Missile m = new Missile(xloc,yloc,angle);
        sandbox.addBlob(m);
}}