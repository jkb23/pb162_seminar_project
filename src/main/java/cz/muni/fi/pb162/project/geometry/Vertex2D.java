package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Vertex2D {
    private double x;
    private double y;

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    /**
     *
     * @param x coordinte x
     * @param y coordinte y
     */

    public Vertex2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     *
     */

    public Vertex2D(){
        this.x = 0;
        this.y = 0;
    }

    /**
     *
     * @return formatted output
     */

    @Override
    public String toString(){
        return "[" + x + ", " + y + "]";
    }

    /**
     *
     * @param vert vertex we want create middle with
     * @return the middle
     */

    public Vertex2D createMiddle(Vertex2D vert) {
        Vertex2D newVertex = new Vertex2D();
        newVertex.setX((this.getX() + vert.getX()) / 2);
        newVertex.setY((this.getY() + vert.getY()) / 2);

        return newVertex;
    }
}
