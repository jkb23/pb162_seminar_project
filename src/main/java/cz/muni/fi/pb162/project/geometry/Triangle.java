package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Triangle {
    private Vertex2D[] verArray = new Vertex2D[3];
    private Triangle[] triArray = new Triangle[3];

    /**
     *
     * @param first vertex
     * @param second vertex
     * @param third vertex
     */
    public Triangle(Vertex2D first, Vertex2D second, Vertex2D third){
        verArray[0] = first;
        verArray[1] = second;
        verArray[2] = third;
    }

    /**
     *
     * @param index which one
     * @return selected vertex
     */

    public Vertex2D getVertex(int index){
        if (index > 2 || index < 0) {
            return null;
        }
        return this.verArray[index];
    }

    /**
     *
     * @param index which one
     * @param vertex new vertex
     */

    public void setVertex(int index, Vertex2D vertex){
        if (index > 2 || index < 0){
            return;
        }
        this.verArray[index] = vertex;
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
        Vertex2D zToO = this.getVertex(0).createMiddle(this.getVertex(1));
        Vertex2D zToT = this.getVertex(0).createMiddle(this.getVertex(2));
        Vertex2D tToO = this.getVertex(2).createMiddle(this.getVertex(1));

        Triangle f = new Triangle(this.getVertex(0), zToO, zToT);
        Triangle s = new Triangle(this.getVertex(1), zToO, tToO);
        Triangle t = new Triangle(this.getVertex(2), zToT, tToO);

        triArray[0] = f;
        triArray[1] = s;
        triArray[2] = t;

        return true;
    }

}
