package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Square implements Circular {
    private final Vertex2D center;
    private final double diameter;

    public Vertex2D getCenter(){
        return this.center;
    }

    public double getRadius(){
        return this.diameter / 2;
    }

    /**
     *
     * @param center center of vertex
     * @param diameter diameter of vertex
     */
    public Square(Vertex2D center, double diameter){
        this.center = center;
        this.diameter = diameter;
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
     * @param index which vertex to get
     * @return vertex coordinates or null
     */
    public Vertex2D getVertex(int index){
        switch (index) {
            case 0:
                return new Vertex2D(this.getCenter().getX() - this.getRadius(), this.getCenter().getY());
            case 1:
                return new Vertex2D(this.getCenter().getX(), this.getCenter().getY() - this.getRadius());
            case 2:
                return new Vertex2D(this.getCenter().getX() + this.getRadius(), this.getCenter().getY());
            case 3:
                return new Vertex2D(this.getCenter().getX(), this.getCenter().getY() + this.getRadius());
            default:
                return null;
        }
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
