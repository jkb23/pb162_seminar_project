package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Snowman {
    public static final int COUNT_OF_BALLS = 3;
    private final RegularPolygon[] balls = new RegularPolygon[3];
    private static final double REDUCTION = 0.8;

    /**
     *
     * @param obj circular object
     * @param red (0, 1> double shrink
     */
    public Snowman(RegularPolygon obj, double red){
        if (red <= 0 || red > 1){
            red = REDUCTION;
        }

        balls[0] = obj;
        for (int i = 1; i < COUNT_OF_BALLS; i++){
            Vertex2D newCenter = new Vertex2D(obj.getCenter().getX(),
                    obj.getCenter().getY() + obj.getRadius() * red + obj.getRadius());
            GeneralRegularPolygon poly = new GeneralRegularPolygon(newCenter, obj.getNumEdges(), obj.getRadius() * red);
            balls[i] = poly;
            obj = poly;
        }
    }

    public RegularPolygon[] getBalls(){
        return this.balls;
    }
}
