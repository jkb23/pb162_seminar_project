package cz.muni.fi.pb162.project.exception;

/**
 * @author Matus Jakab
 */
public class MissingVerticesException extends RuntimeException{

    /**
     *
     * @param s message
     */
    public MissingVerticesException(String s){
        super(s);
    }

    /**
     *
     * @param c cause
     */
    public MissingVerticesException(Throwable c){
        super(c);
    }

    /**
     *
     * @param s message
     * @param c cause
     */
    public MissingVerticesException(String s, Throwable c){
        super(s, c);
    }
}
