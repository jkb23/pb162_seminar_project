package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Triangle {
    private final Vertex2D[] verArray = new Vertex2D[3];
    private final Triangle[] triArray = new Triangle[3];
    private final double toleration = 0.001;

    /**
     *
     * @param first point of triangle
     * @param second point of triangle
     * @param third point of triangle
     */

    public Triangle(Vertex2D first, Vertex2D second, Vertex2D third){
        verArray[0] = first;
        verArray[1] = second;
        verArray[2] = third;
    }

    /**
     *
     * @param first point of triangle
     * @param second point of triangle
     * @param third point of triangle
     * @param depth recursion depth
     */

    public Triangle(Vertex2D first, Vertex2D second, Vertex2D third, int depth){
        this(first, second, third);
        divide(depth);

    }

    /**
     *
     * @param index which from array
     * @return vertex
     */

    public Vertex2D getVertex(int index){
        if (index > 2 || index < 0) {
            return null;
        }
        return this.verArray[index];
    }

    /**
     *
     * @param index which one to get
     * @return selected subtriangle
     */

    public Triangle getSubTriangle(int index){
        if (index > 2 || index < 0 || !this.isDivided()) {
            return null;
        }
        return this.triArray[index];
    }

    /**
     *
     * @return true if triangle is divided
     */

    public boolean isDivided(){
        return this.triArray[0] != null;
    }

    /**
     *
     * @return string of our choice
     */

    @Override
    public String toString(){
        return ("Triangle: vertices=" + this.verArray[0].toString() + " " +
                this.verArray[1].toString() + " " + this.verArray[2].toString());
    }

    /**
     *
     * @return true if we divided triangle
     */

    public boolean divide(){
        if (this.isDivided()) {
            return false;
        }
        
        Vertex2D ab = this.getVertex(0).createMiddle(this.getVertex(1));
        Vertex2D ac = this.getVertex(0).createMiddle(this.getVertex(2));
        Vertex2D bc = this.getVertex(2).createMiddle(this.getVertex(1));

        triArray[0] = new Triangle(this.getVertex(0), ab, ac);
        triArray[1] = new Triangle(this.getVertex(1), ab, bc);
        triArray[2] = new Triangle(this.getVertex(2), ac, bc);

        return true;
    }

    /**
     *
     * @param depth end of a recursion
     */

    public void divide(int depth){
        if (depth <= 0){
            return ;
        }

        divide();
        triArray[0].divide(depth - 1);
        triArray[1].divide(depth - 1);
        triArray[2].divide(depth - 1);
    }

    /**
     *
     * @return true if the triangle is equilateral
     */

    public boolean isEquilateral(){
        double x = this.verArray[0].distance(verArray[1]);
        double y = this.verArray[0].distance(verArray[2]);
        double z = this.verArray[1].distance(verArray[2]);

        return Math.abs(x - y) < toleration && Math.abs(x - z) < toleration;
    }

}
