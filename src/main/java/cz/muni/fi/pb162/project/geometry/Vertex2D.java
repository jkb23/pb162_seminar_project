package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Vertex2D {
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
}
