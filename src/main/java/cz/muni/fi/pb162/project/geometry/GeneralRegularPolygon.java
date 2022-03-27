package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private Vertex2D center;
    private int numEdges;
    private double radius;
    private Color color = Color.BLACK;

    /**
     *
     * @param center of selected polygon
     * @param numEdges of selected polygon
     * @param radius of selected polygon
     */
    public GeneralRegularPolygon(Vertex2D center, int numEdges, double radius){
        this.center = center;
        this.numEdges = numEdges;
        this.radius = radius;
    }

    /**
     *
     * @return Length of polygon edges
     */
    public double getEdgeLength(){
        return 2 * radius * Math.sin(Math.PI / numEdges);
    }

    public int getNumEdges(){
        return numEdges;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    public void setCenter(Vertex2D center){
        this.center = center;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setNumEdges(int num){
        this.numEdges = num;
    }

    /**
     *
     * @param index integral number of index
     * @return indexth vertex
     */
    public Vertex2D getVertex(int index){
        double x = center.getX() - radius * Math.cos(index * 2 * Math.PI / numEdges);
        double y = center.getY() - radius * Math.sin(index * 2 * Math.PI / numEdges);
        return new Vertex2D(x, y);
    }

    /**
     *
     * @return formatted output
     */
    public String toString(){
        return numEdges + "-gon: center=" + center + ", radius=" + radius + ", color=" + color;
    }
}
