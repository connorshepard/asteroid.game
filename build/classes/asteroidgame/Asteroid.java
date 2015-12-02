
package asteroidgame;

import blobzx.*;
import java.util.Random;
import java.lang.Math;
import java.awt.Point;

/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author: Connor Shepard
 */
public class Asteroid extends PolyBlob {
    
    private static Random random = new Random();
    
    public Asteroid( int idx, int jdx, double rot ) {
    
        // Construct a polyblob for flow mode
        // with the input velocity and rotation values
        super( -100, -100, rot );
        int sides = (random.nextInt(5)) + 5;
        int vertex = sides;
        int distance[] = new int[vertex];
        int j = 0;
        while (j < vertex)
        {
            distance[j] = (random.nextInt(11)) + 5;
            j++;
        }

        double angle[] = new double[vertex];
        int i = 0;
        double twopi = 2*(Math.PI);
        double region = twopi / sides;
        while (i < sides)
        {
            angle[i] = (i * region) + (Math.random() * region);
            i++;
        }

        Point[] point = new Point[vertex];
        int p = 0;
        int[] x = new int[vertex];
        int[] y = new int[vertex];
        while (p < vertex)
        {
            point[p] = BlobUtils.rotatePoint(distance[p], angle[p]);
            double xcoordinate = point[p].getX();
            x[p] = (int) xcoordinate;
            double ycoordinate = point[p].getY();
            y[p] = (int) ycoordinate;
            p++;
        }

        setDelta(idx, jdx);
        setPolygon(x,y);
    }
}
