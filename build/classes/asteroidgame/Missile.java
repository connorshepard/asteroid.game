
package asteroidgame;
import blobzx.*;

/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author: Connor Shepard
 */

public class Missile extends Blob implements BlobProximity {

    public Missile(int xloc, int yloc, double angle) {
        super(xloc, yloc);
        
        double speed = 5;
        int diameter = 5;
        
        int dx = (int) Math.round(speed * Math.cos(angle));
        int dy = (int) Math.round(speed * Math.sin(angle));
        
        int missx = xloc + (int) Math.round(speed * Math.cos(angle));
        int missy = yloc + (int) Math.round(speed * Math.sin(angle));
        
        setSize(diameter);
        setDelta(dx, dy);
        setLoc(xloc,yloc); 
    }
    
}
