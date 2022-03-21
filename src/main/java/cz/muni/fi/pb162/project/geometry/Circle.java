package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Circle implements Measurable, Circular {
    private final Vertex2D center;
    private final double radius;

    /**
     *
     * @param center center o circle
     * @param radius radius of circle
     */

    public Circle(Vertex2D center, double radius){
        this.center = center;
        this.radius = radius;
    }

    /**
     *
     */

    public Circle(){
        this (new Vertex2D(0.0, 0.0), 1.0);
    }

    public Vertex2D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    /**
     *
     * @return formatted output
     */

    @Override
    public String toString(){
        return "Circle: center=" + center.toString() + ", radius=" + radius;
    }

    /**
     *
     * @return width of circle
     */
    public double getWidth(){
        return this.radius * 2;
    }

    /**
     *
     * @return height of circle
     */
    public double getHeight(){
        return this.radius *2;
    }
}
