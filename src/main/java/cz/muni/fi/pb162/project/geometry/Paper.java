package cz.muni.fi.pb162.project.geometry;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Matus Jakab
 */
public class Paper implements Drawable {
    private Color color;
    private final Set<ColoredPolygon> drawn;

    /**
     * constructor
     */
    public Paper(){
        this.color = Color.BLACK;
        this.drawn = new HashSet<>();
    }

    /**
     *
     * @param drawable item of Drawable interface
     */
    public Paper(Drawable drawable){
        this.color = Color.BLACK;
        this.drawn = new HashSet<>(drawable.getAllDrawnPolygons());
    }

    /**
     *
     * @param color the color which the following drawn objects are going to have
     */
    public void changeColor(Color color){
        this.color = color;
    }

    /**
     *
     * @param polygon polygon to be drawn
     */
    public void drawPolygon(Polygon polygon){
        if(this.color != Color.WHITE) {
            this.drawn.add(new ColoredPolygon(polygon, color));
        }
    }

    /**
     *
     * @param polygon polygon to be erased
     */
    public void erasePolygon(ColoredPolygon polygon){
        drawn.remove(polygon);
    }

    /**
     * removed all polygons from paper
     */
    public void eraseAll(){
        drawn.clear();
    }

    /**
     *
     * @return all colored polygons
     */
    public Set<ColoredPolygon> getAllDrawnPolygons(){
        return Collections.unmodifiableSet(drawn);
    }

    /**
     *
     * @return amount of unique vertices on paper
     */
    public int uniqueVerticesAmount(){
        HashSet<Vertex2D> vertices = new HashSet<>();
        for (ColoredPolygon polygon : drawn){
            for(int i = 0; i < polygon.getPolygon().getNumVertices(); i++){
                vertices.add(polygon.getPolygon().getVertex(i));
            }
        }
        return vertices.size();
    }
}
