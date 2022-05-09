package cz.muni.fi.pb162.project.geometry;

import java.util.Objects;

/**
 * @author Matus Jakab
 */
public class Vertex2D implements Comparable<Vertex2D> {
    private final double x;
    private final double y;

    public double getX() {
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    /**
     *
     * @param x coordinate x
     * @param y coordinate y
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
     * @param vert vertex we want to create middle with
     * @return the middle
     */

    public Vertex2D createMiddle(Vertex2D vert) {
        return new Vertex2D((this.getX() + vert.getX()) / 2,
                (this.getY() + vert.getY()) / 2);
    }

    /**
     *
     * @param vertex another vertex
     * @return Euclidean distance as double
     */

    public double distance(Vertex2D vertex){
        if (vertex == null){
            return -1.0;
        }

        var x2 = vertex.getX();
        var x1 = this.getX();
        var y2 = vertex.getY();
        var y1 = this.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Vertex2D vertex2D = (Vertex2D) o;
        return Double.compare(vertex2D.x, x) == 0 && Double.compare(vertex2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     *
     * @param vertex the object to be compared.
     * @return  negative int if given vertex's coordinates are bigger
     *          positive int if original vertex's coordinates are bigger
     *          0 if they are equal
     *          (at first compares X coordinate then Y)
     */
    public int compareTo(Vertex2D vertex){
        if (this.getX() == vertex.getX()) {
            return Double.compare(this.getY(), vertex.getY());
        }

        return Double.compare(this.getX(), vertex.getX());
    }
}
