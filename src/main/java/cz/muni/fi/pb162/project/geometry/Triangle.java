package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Triangle extends ArrayPolygon {
    private final Triangle[] triArray = new Triangle[3];

    /**
     *
     * @param first point of triangle
     * @param second point of triangle
     * @param third point of triangle
     */

    public Triangle(Vertex2D first, Vertex2D second, Vertex2D third){
        super(new Vertex2D[] {first, second, third});
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
        return ("Triangle: vertices=" + this.getVertex(0).toString() + " " +
                this.getVertex(1).toString() + " " + this.getVertex(2).toString());
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
        double toleration = 0.001;
        double x = this.getVertex(0).distance(getVertex(1));
        double y = this.getVertex(0).distance(getVertex(2));
        double z = this.getVertex(1).distance(getVertex(2));

        return Math.abs(x - y) < toleration && Math.abs(x - z) < toleration;
    }

}
