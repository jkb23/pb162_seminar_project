package cz.muni.fi.pb162.project.geometry;

import java.text.DecimalFormat;

/**
 * @author Matus Jakab
 */
public class Vertex2D {
    private double x = 0;
    private double y = 0;

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    /**
     *
     * @return formatted output
     */

    public String getInfo(){
        DecimalFormat ft = new DecimalFormat("########.0");
        return "[" + ft.format(x) + ", " +ft.format(y) + "]";
    }

    /**
     *
     * @return sum of coordinates
     */

    public double sumCoordinates(){
        return this.x + this.y;
    }

    /**
     *
     * @param vertex to move with
     */

    public void move(Vertex2D vertex){
        this.x += vertex.x;
        this.y += vertex.y;
    }
}
