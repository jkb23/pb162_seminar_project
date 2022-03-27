package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Circle extends GeneralRegularPolygon {

    /**
     *
     * @param center center o circle
     * @param radius radius of circle
     */

    public Circle(Vertex2D center, double radius){
        super(center, Integer.MAX_VALUE, radius);
        this.setColor(Color.RED);
    }

    /**
     *
     */

    public Circle(){
        this (new Vertex2D(0.0, 0.0), 1.0);
    }

    /**
     *
     * @return formatted output
     */

    @Override
    public String toString(){
        return "Circle: center=" + this.getCenter().toString() + ", radius=" + this.getRadius();
    }

    @Override
    public double getEdgeLength(){
        return 0;
    }
}
