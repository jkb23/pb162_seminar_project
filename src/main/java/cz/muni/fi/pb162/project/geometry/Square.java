package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Square extends GeneralRegularPolygon {
    /**
     *
     * @param center center of vertex
     * @param diameter diameter of vertex
     */
    public Square(Vertex2D center, double diameter){
        super(center, 4, diameter / 2);
    }

    /**
     *
     * @param obj circular object
     */
    public Square(Circular obj){
        this(obj.getCenter(), obj.getRadius() * 2);
    }

    /**
     *
     * @return formatted string
     */
    public String toString(){
        return "Square: vertices="
                + getVertex(0).toString()
                + " " + getVertex(1).toString()
                + " " + getVertex(2).toString()
                + " " + getVertex(3).toString();
    }
}
