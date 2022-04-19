package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Matus Jakab
 */
public class Paper implements Drawable, PolygonFactory {
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
    public void drawPolygon(Polygon polygon) throws TransparentColorException{
        if(this.color == Color.WHITE) {
            throw new TransparentColorException("Can't draw with white color on white paper");
        }
        this.drawn.add(new ColoredPolygon(polygon, color));
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
    public void eraseAll() throws EmptyDrawableException{
        if (drawn.isEmpty()){
            throw new EmptyDrawableException("Paper is empty");
        }
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

    /**
     *
     * @param arr collection which the polygon can be built from; the collection is not modified
     * @return new polygon
     */
    public Polygon tryToCreatePolygon(List<Vertex2D> arr){
        if (arr == null){
            throw new NullPointerException("The list of vertices is null");
        }

        Polygon poly;
        List<Vertex2D> newArr = new ArrayList<>(arr);

        try {
            poly = new CollectionPolygon(newArr);
        } catch (IllegalArgumentException e){
            while (newArr.contains(null)){
                newArr.remove(null);
            }
            poly = new CollectionPolygon(newArr);
        }

        return poly;
    }

    /**
     *
     * @param arr collection of polygons (every polygon is collection of vertices)
     * @throws EmptyDrawableException exception
     */
    public void tryToDrawPolygons(List<List<Vertex2D>> arr) throws EmptyDrawableException{
        boolean notDrawn = true;
        Throwable cause = null;
        for (List<Vertex2D> verList : arr){
            try {
                Polygon polygon = tryToCreatePolygon(verList);
                drawPolygon(polygon);
                notDrawn = false;
            } catch (TransparentColorException e){
                this.color = Color.BLACK;
                cause = e;
            } catch (MissingVerticesException | NullPointerException e){
                cause = e;
            }
        }
        if (notDrawn){
            throw new EmptyDrawableException("nothing drawn", cause);
        }
    }

    /**
     *
     * @param color color
     * @return set of polygons
     */
    public Set<Polygon> getPolygonsWithColor(Color color){
        Set<Polygon> ret = new HashSet<>();
        for (ColoredPolygon polygon : drawn){
            if (polygon.getColor() == color){
                ret.add(polygon.getPolygon());
            }
        }
        return ret;
    }
}
