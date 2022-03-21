package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class Snowman {
    public static final int COUNT_OF_BALLS = 4;
    private final Circular[] balls = new Circular[4];
    private static final double REDUCTION = 0.8;

    /**
     *
     * @param obj circular object
     * @param red (0, 1> double shrink
     */
    public Snowman(Circular obj, double red){
        if (red <= 0 || red > 1){
            red = REDUCTION;
        }

        balls[0] = obj;
        for (int i = 1; i < COUNT_OF_BALLS; i++){
            Vertex2D newCenter = new Vertex2D(obj.getCenter().getX(),
                    obj.getCenter().getY() + obj.getRadius() * red + obj.getRadius());
            Circle circle = new Circle(newCenter, obj.getRadius() * red);
            balls[i] = circle;
            obj = circle;
        }
    }

    public Circular[] getBalls(){
        return this.balls;
    }
}
